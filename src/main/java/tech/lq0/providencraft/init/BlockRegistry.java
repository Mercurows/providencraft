package tech.lq0.providencraft.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.block.*;
import tech.lq0.providencraft.block.bluesand.*;
import tech.lq0.providencraft.block.harano.*;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);

    public static final RegistryObject<Block> RED_AHOGE_BLOCK = BLOCKS.register("red_ahoge_block", RedAhogeBlock::new);
    public static final RegistryObject<Block> WHITE_AHOGE_BLOCK = BLOCKS.register("white_ahoge_block", WhiteAhogeBlock::new);
    public static final RegistryObject<Block> COMMUNICATION_TABLE = BLOCKS.register("communication_table", CommunicationTable::new);
    public static final RegistryObject<Block> PORCELAIN_THRONE = BLOCKS.register("porcelain_throne", PorcelainThrone::new);
    public static final RegistryObject<Block> POINTS_STORE = BLOCKS.register("points_store", PointsStore::new);
    public static final RegistryObject<Block> FUKAMIZU_BREAD_BLOCK = BLOCKS.register("fukamizu_bread_block", FukamizuBreadBlock::new);
    public static final RegistryObject<Block> UNI_MILLET_BLOCK = BLOCKS.register("uni_millet_block", UniMilletBlock::new);

    //Blue Sand Series
    public static final RegistryObject<Block> BLUE_SAND = BLOCKS.register("blue_sand", BlueSand::new);
    public static final RegistryObject<Block> BLUE_SANDSTONE = BLOCKS.register("blue_sandstone", BlueSandstone::new);
    public static final RegistryObject<Block> CUT_BLUE_SANDSTONE = BLOCKS.register("cut_blue_sandstone", CutBlueSandstone::new);
    public static final RegistryObject<Block> CHISELED_BLUE_SANDSTONE = BLOCKS.register("chiseled_blue_sandstone", ChiseledBlueSandstone::new);
    public static final RegistryObject<Block> BLUE_SANDSTONE_SLAB = BLOCKS.register("blue_sandstone_slab", BlueSandstoneSlab::new);
    public static final RegistryObject<Block> BLUE_SANDSTONE_STAIRS = BLOCKS.register("blue_sandstone_stairs", BlueSandstoneStairs::new);
    public static final RegistryObject<Block> BLUE_SANDSTONE_WALL = BLOCKS.register("blue_sandstone_wall", BlueSandstoneWall::new);
    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE = BLOCKS.register("smooth_blue_sandstone", SmoothBlueSandstone::new);
    public static final RegistryObject<Block> CUT_BLUE_SANDSTONE_SLAB = BLOCKS.register("cut_blue_sandstone_slab", CutBlueSandstoneSlab::new);
    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE_SLAB = BLOCKS.register("smooth_blue_sandstone_slab", SmoothBlueSandstoneSlab::new);
    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE_STAIRS = BLOCKS.register("smooth_blue_sandstone_stairs", SmoothBlueSandstoneStairs::new);

    //Harano Wood Series
    public static final RegistryObject<Block> HARANO_LOG = BLOCKS.register("harano_log", HaranoLog::new);
    public static final RegistryObject<Block> HARANO_LEAVES = BLOCKS.register("harano_leaves", HaranoLeaves::new);
    public static final RegistryObject<Block> HARANO_SAPLING = BLOCKS.register("harano_sapling", HaranoSapling::new);
    public static final RegistryObject<Block> HARANO_PLANKS = BLOCKS.register("harano_planks", HaranoPlanks::new);
    public static final RegistryObject<Block> HARANO_WOOD = BLOCKS.register("harano_wood", HaranoWood::new);
    public static final RegistryObject<Block> HARANO_STAIRS = BLOCKS.register("harano_stairs", HaranoStairs::new);
    public static final RegistryObject<Block> HARANO_SLAB = BLOCKS.register("harano_slab", HaranoSlab::new);
    public static final RegistryObject<Block> HARANO_FENCE = BLOCKS.register("harano_fence", HaranoFence::new);
    public static final RegistryObject<Block> HARANO_FENCE_GATE = BLOCKS.register("harano_fence_gate", HaranoFenceGate::new);
    public static final RegistryObject<Block> HARANO_PRESSURE_PLATE = BLOCKS.register("harano_pressure_plate", HaranoPressurePlate::new);
    public static final RegistryObject<Block> STRIPPED_HARANO_LOG = BLOCKS.register("stripped_harano_log", StrippedHaranoLog::new);
    public static final RegistryObject<Block> STRIPPED_HARANO_WOOD = BLOCKS.register("stripped_harano_wood", StrippedHaranoWood::new);
    public static final RegistryObject<Block> HARANO_DOOR = BLOCKS.register("harano_door", HaranoDoor::new);
}
