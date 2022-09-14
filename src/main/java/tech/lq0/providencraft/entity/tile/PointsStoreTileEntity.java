package tech.lq0.providencraft.entity.tile;

import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.init.TileEntityRegistry;

import javax.annotation.Nullable;
import java.util.Collections;

public class PointsStoreTileEntity extends TileEntity implements IMerchant {
    PlayerEntity customer = null;
    MerchantOffers merchantOffers = null;

    public PointsStoreTileEntity() {
        super(TileEntityRegistry.POINTS_STORE.get());
    }

    @Override
    public void setCustomer(@Nullable PlayerEntity player) {
        this.customer = player;
    }

    @Nullable
    @Override
    public PlayerEntity getCustomer() {
        return customer;
    }

    @Override
    public MerchantOffers getOffers() {
        if(merchantOffers == null) {
            addOffers();
            markDirty();
        }
        return merchantOffers;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void setClientSideOffers(@Nullable MerchantOffers offers) {
        this.merchantOffers = offers;
    }

    @Override
    public void onTrade(MerchantOffer offer) {
        offer.resetUses();
    }

    @Override
    public void verifySellingItem(ItemStack stack) {

    }

    @Override
    public int getXp() {
        return 0;
    }

    @Override
    public void setXP(int xpIn) {
    }

    @Override
    public boolean hasXPBar() {
        return false;
    }

    @Override
    public SoundEvent getYesSound() {
        return null;
    }

    @Nullable
    @Override
    public World getWorld() {
        return world;
    }

    public void openGui(PlayerEntity player) {
        setCustomer(player);
        TranslationTextComponent name = new TranslationTextComponent("block.providencraft.points_store");
        this.openMerchantContainer(player, name, 5);
    }

    private void addOffers(){
        merchantOffers = new MerchantOffers();
        Collections.addAll(merchantOffers, offers);
    }

    private static final MerchantOffer[] offers = {
            new MerchantOffer(getPoints(38), getGoods(ItemRegistry.FLUFF_BALL.get(), 1), 64, 0, 0),
            new MerchantOffer(getPoints(1), getGoods(ItemRegistry.GN_SOUL.get(), 2), 64,0,0),
            new MerchantOffer(getPoints(64), getPoints(64), getGoods(ItemRegistry.FETUOZI.get(), 1), 64, 0, 0)
    };

    private static ItemStack getPoints(int count){
        ItemStack points = new ItemStack(ItemRegistry.PDC_POINT.get());
        if(count > 1) {
            points.grow(count - 1);
        }
        return points;
    }

    private static ItemStack getGoods(IItemProvider item, int count){
        ItemStack goods = new ItemStack(item);
        if(count > 1) {
            goods.grow(count - 1);
        }
        return goods;
    }
}
