package tech.lq0.providencraft.item.providenceOI.rino;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
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
import tech.lq0.providencraft.entity.AhogeBoomerangEntity;
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
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            AhogeBoomerangEntity ahogeBoomerangEntity1 = new AhogeBoomerangEntity(worldIn, playerIn);
            AhogeBoomerangEntity ahogeBoomerangEntity2 = new AhogeBoomerangEntity(worldIn, playerIn);
            AhogeBoomerangEntity ahogeBoomerangEntity3 = new AhogeBoomerangEntity(worldIn, playerIn);
            AhogeBoomerangEntity ahogeBoomerangEntity4 = new AhogeBoomerangEntity(worldIn, playerIn);
            AhogeBoomerangEntity ahogeBoomerangEntity5 = new AhogeBoomerangEntity(worldIn, playerIn);
            ahogeBoomerangEntity1.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 3.0f, 0.2f);
            worldIn.addEntity(ahogeBoomerangEntity1);

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
                    ahogeBoomerangEntity2.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(ahogeBoomerangEntity2);
                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 2);

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
                    ahogeBoomerangEntity3.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(ahogeBoomerangEntity3);
                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 4);

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
                    ahogeBoomerangEntity4.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(ahogeBoomerangEntity4);
                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 6);

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
                    ahogeBoomerangEntity5.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 3.0f, 0.2f);
                    worldIn.addEntity(ahogeBoomerangEntity5);
                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }.start((int) 8);
        }

        return new ActionResult<>(ActionResultType.SUCCESS, item);
    }
}
