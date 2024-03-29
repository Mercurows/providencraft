package tech.lq0.providencraft.item.providenceOI.rino;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tech.lq0.providencraft.entity.projectile.ShuRinoKenEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class ShuRinoKen extends SwordItem {
    public ShuRinoKen(){
        super(ItemTier.IRON, 1, -2.0f, new Properties().maxDamage(406).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.shu_rino_ken_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.shu_rino_ken_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.RINO);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.DIAMOND;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            //First 1
            ShuRinoKenEntity shuRinoKenEntity = new ShuRinoKenEntity(worldIn, playerIn);
            shuRinoKenEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 3.0f, 0.2f);
            worldIn.addEntity(shuRinoKenEntity);

            //Second 2
            new Object() {
                private int ticks = 0;
                private float waitTicks;

                public void start(int waitTicks) {
                    this.waitTicks = waitTicks;
                    MinecraftForge.EVENT_BUS.register(this);
                }

                @SubscribeEvent
                public void tick(TickEvent.ServerTickEvent event) {
                    if (event.phase == TickEvent.Phase.END) {
                        this.ticks++;
                        if (this.ticks >= this.waitTicks) {
                            run();
                        }
                    }
                }

                private void run() {
                    ShuRinoKenEntity shuRinoKenEntity1 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity1.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(shuRinoKenEntity1);

                    ShuRinoKenEntity shuRinoKenEntity2 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity2.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(shuRinoKenEntity2);
                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 3);

            //Third 3
            new Object() {
                private int ticks = 0;
                private float waitTicks;

                public void start(int waitTicks) {
                    this.waitTicks = waitTicks;
                    MinecraftForge.EVENT_BUS.register(this);
                }

                @SubscribeEvent
                public void tick(TickEvent.ServerTickEvent event) {
                    if (event.phase == TickEvent.Phase.END) {
                        this.ticks++;
                        if (this.ticks >= this.waitTicks) {
                            run();
                        }
                    }
                }

                private void run() {
                    ShuRinoKenEntity shuRinoKenEntity1 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity1.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 8.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(shuRinoKenEntity1);

                    ShuRinoKenEntity shuRinoKenEntity2 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity2.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 8.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(shuRinoKenEntity2);

                    ShuRinoKenEntity shuRinoKenEntity3 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity3.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(shuRinoKenEntity3);
                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 6);

            //Fourth 2
            new Object() {
                private int ticks = 0;
                private float waitTicks;

                public void start(int waitTicks) {
                    this.waitTicks = waitTicks;
                    MinecraftForge.EVENT_BUS.register(this);
                }

                @SubscribeEvent
                public void tick(TickEvent.ServerTickEvent event) {
                    if (event.phase == TickEvent.Phase.END) {
                        this.ticks++;
                        if (this.ticks >= this.waitTicks) {
                            run();
                        }
                    }
                }

                private void run() {
                    ShuRinoKenEntity shuRinoKenEntity1 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity1.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw - 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(shuRinoKenEntity1);

                    ShuRinoKenEntity shuRinoKenEntity2 = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity2.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw + 4.0f, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(shuRinoKenEntity2);

                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 9);

            //Fifth 1
            new Object() {
                private int ticks = 0;
                private float waitTicks;

                public void start(int waitTicks) {
                    this.waitTicks = waitTicks;
                    MinecraftForge.EVENT_BUS.register(this);
                }

                @SubscribeEvent
                public void tick(TickEvent.ServerTickEvent event) {
                    if (event.phase == TickEvent.Phase.END) {
                        this.ticks++;
                        if (this.ticks >= this.waitTicks) {
                            run();
                        }
                    }
                }

                private void run() {
                    ShuRinoKenEntity shuRinoKenEntity = new ShuRinoKenEntity(worldIn, playerIn);
                    shuRinoKenEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(shuRinoKenEntity);

                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 12);

            item.damageItem(10, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));
            playerIn.getCooldownTracker().setCooldown(item.getItem(), 30);
        }

        return new ActionResult<>(ActionResultType.SUCCESS, item);
    }
}
