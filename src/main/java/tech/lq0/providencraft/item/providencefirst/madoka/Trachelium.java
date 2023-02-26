package tech.lq0.providencraft.item.providencefirst.madoka;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.render.item.RenderTrachelium;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Trachelium extends Item implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    public static final String TAG_AMMO = "ammo";
    public String CONTROLLER_NAME = "trachelium_controller";

    private boolean fire = false;

    public Trachelium(){
        super(new Properties().maxStackSize(1).maxDamage(8).group(ModGroup.itemgroup).rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD))
                .setISTER(() -> RenderTrachelium::new));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("trachelium_des1")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("trachelium_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.MADOKA);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged && !oldStack.equals(newStack);
    }

    public static int getAmmo(ItemStack stack){
        return ItemNBTTool.getInt(stack, TAG_AMMO, 8);
    }

    public static void setAmmo(ItemStack stack, int num){
        ItemNBTTool.setInt(stack, TAG_AMMO, num);
    }

    public static void shoot(ItemStack stack, PlayerEntity player){
        if(player.isCreative()){
            return;
        }
        setAmmo(stack, Math.max(getAmmo(stack) - 1, 0));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        setAmmo(stack, 8);
        return stack;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(playerIn.isSneaking()){
            setAmmo(stack, 8);
            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 60);
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }
        playerIn.setActiveHand(handIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public void playAnimation(String animationName, ItemStack stack, PlayerEntity player){
        //TODO 使动画正常播放
        if(animationName.equals("fire")){
            new Object() {
                private int ticks = 0;
                private float waitTicks;
                private IWorld world;

                public void start(IWorld world, int waitTicks) {
                    setFire(true);
                    this.waitTicks = waitTicks;
                    MinecraftForge.EVENT_BUS.register(this);
                    this.world = world;
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
                    setFire(false);
                    MinecraftForge.EVENT_BUS.unregister(this);
                }

            }.start(player.world, (int) 15);
        }else if (animationName.equals("reload")){
            //TODO 添加换弹动画
        }
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, CONTROLLER_NAME, 0, this::predicate));
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        if(this.isFire()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.trachelium.fire", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }else {
            return PlayState.STOP;
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    //    @SubscribeEvent
//    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
//        event.enqueueWork(() -> ItemModelsProperties.registerProperty(
//                ItemRegistry.TRACHELIUM.get(), new ResourceLocation(Utils.MOD_ID, "trachelium_ammo"),
//                (itemStack, clientWorld, livingEntity) -> {
//                    if (livingEntity == null) {
//                        return 8;
//                    } else {
//                        ItemStack stack = livingEntity.getActiveItemStack();
//                        return !stack.isEmpty() && itemStack.getItem() instanceof Trachelium ?
//                                Trachelium.getAmmo(stack) : 8;
//                    }
//                }
//        ));
//    }


//    @Override
//    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
//        if(this.getUseDuration(stack) - count < 20) {
//            if (player.getEntityWorld() instanceof ServerWorld) {
//                System.out.println(1919);
//                IParticleData particleData = new TracheliumParticleData(new Vector3d(0, 0, 0),
//                        new Color(255, 255, 255, 0), 0.3f, player.getPosX(), player.getPosY() + 1.3, player.getPosZ(), true);
//                ((ServerWorld) player.getEntityWorld()).spawnParticle(particleData, player.getPosX(), player.getPosY() + 1.3, player.getPosZ(),
//                        3, Math.random() * 3 + 2, Math.random() * 3 + 2, Math.random() * 3 + 2, 0.1D);
//            }
//
//        }
//        super.onUsingTick(stack, player, count);
//    }
}
