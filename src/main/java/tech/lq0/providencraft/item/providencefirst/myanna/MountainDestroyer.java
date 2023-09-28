package tech.lq0.providencraft.item.providencefirst.myanna;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tiers.ModItemTier;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MountainDestroyer extends PickaxeItem {
    public static final List<Material> MATERIALS = new ArrayList<>();

    static {
        MATERIALS.add(Material.ROCK);
        MATERIALS.add(Material.EARTH);
        MATERIALS.add(Material.SAND);
        MATERIALS.add(Material.ORGANIC);
        MATERIALS.add(Material.ICE);
        MATERIALS.add(Material.PACKED_ICE);
        MATERIALS.add(Material.IRON);
        MATERIALS.add(Material.ANVIL);
        MATERIALS.add(Material.SHULKER);
    }

    public static final String TAG_MULTIMINE = "multimine";

    public MountainDestroyer() {
        super(ModItemTier.DARK_ELF, 6, -3f, (new Properties()).defaultMaxDamage(39).rarity(Rarity.EPIC)
                .group(ModGroup.itemgroup).isImmuneToFire().setNoRepair());
    }

    @Override
    public boolean canHarvestBlock(BlockState blockIn) {
        int i = this.getTier().getHarvestLevel();
        if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
            return i >= blockIn.getHarvestLevel();
        }
        Material material = blockIn.getMaterial();
        return MATERIALS.contains(material) || blockIn.getBlock().getTags().contains(new ResourceLocation("forge:ores"));
    }

    @Override
    @ParametersAreNonnullByDefault
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return MATERIALS.contains(material) || state.getBlock().getTags().contains(new ResourceLocation("forge:ores")) ?
                this.efficiency : super.getDestroySpeed(stack, state);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_MULTIMINE, false);
            ItemNBTTool.setBoolean(stack, TAG_MULTIMINE, !flag);
            playerIn.sendStatusMessage(!flag ? new TranslationTextComponent("des.providencraft.mountain_destroyer.enable") :
                    new TranslationTextComponent("des.providencraft.mountain_destroyer.disable"), true);

        }
        return ActionResult.resultFail(stack);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if ((MATERIALS.contains(state.getMaterial()) || state.getBlock().getTags().contains(new ResourceLocation("forge:ores")))
                && !worldIn.isRemote && entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            stack.damageItem(-1, player, (playerEntity) -> playerEntity.sendBreakAnimation(player.getActiveHand()));

            if (ItemNBTTool.getBoolean(stack, TAG_MULTIMINE, false)) {
                ArrayList<BlockPos> posList = new ArrayList<>();
                if (pos.getY() - entityLiving.getPosY() <= 2 && pos.getY() - entityLiving.getPosY() >= 0) {
                    BlockPos basePos = new BlockPos(pos.getX(), entityLiving.getPosY(), pos.getZ());
                    float yaw = Math.abs(player.rotationYaw);
                    if ((yaw >= 45.0f && yaw <= 135.0f) || (yaw >= 225.0f && yaw <= 315.0f)) {
                        //x-facing
                        posList.add(basePos.add(0, 0, 0));
                        posList.add(basePos.add(0, 0, -1));
                        posList.add(basePos.add(0, 0, 1));
                        posList.add(basePos.add(0, 1, -1));
                        posList.add(basePos.add(0, 1, 0));
                        posList.add(basePos.add(0, 1, 1));
                        posList.add(basePos.add(0, 2, -1));
                        posList.add(basePos.add(0, 2, 0));
                        posList.add(basePos.add(0, 2, 1));
                    } else {
                        //z-facing
                        posList.add(basePos.add(0, 0, 0));
                        posList.add(basePos.add(-1, 0, 0));
                        posList.add(basePos.add(1, 0, 0));
                        posList.add(basePos.add(-1, 1, 0));
                        posList.add(basePos.add(0, 1, 0));
                        posList.add(basePos.add(1, 1, 0));
                        posList.add(basePos.add(-1, 2, 0));
                        posList.add(basePos.add(0, 2, 0));
                        posList.add(basePos.add(1, 2, 0));
                    }
                } else {
                    //up-down-facing
                    posList.add(pos.add(1, 0, 0));
                    posList.add(pos.add(-1, 0, 0));
                    posList.add(pos.add(0, 0, 1));
                    posList.add(pos.add(0, 0, -1));
                    posList.add(pos.add(1, 0, 1));
                    posList.add(pos.add(1, 0, -1));
                    posList.add(pos.add(-1, 0, 1));
                    posList.add(pos.add(-1, 0, -1));
                }
                manualMineBlock(posList, worldIn, entityLiving, stack);
            }
            return true;
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    private void manualMineBlock(ArrayList<BlockPos> pos, World world, LivingEntity player, ItemStack item) {
        for (BlockPos p : pos) {
            BlockState s = world.getBlockState(p);
            if (s.getBlockHardness(world, p) != -1.0F && item.canHarvestBlock(world.getBlockState(p))) {
                BlockState state = world.getBlockState(p);
                TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(p) : null;
                Block.spawnDrops(state, world, p, tileentity, player, player.getHeldItemMainhand());

                world.destroyBlock(p, false);

                ((PlayerEntity) player).addStat(Stats.BLOCK_MINED.get(state.getBlock()), 1);
            }
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.MOUNTAIN_DESTROYER.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, "mountain destroyer modifier", 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World
            worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.mountain_destroyer_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.mountain_destroyer_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.MYANNA);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged && !oldStack.equals(newStack);
    }
}
