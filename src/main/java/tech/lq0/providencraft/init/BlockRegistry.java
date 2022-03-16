package tech.lq0.providencraft.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.block.CommunicationTable;
import tech.lq0.providencraft.block.RedAhogeBlock;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);

    public static final RegistryObject<Block> RED_AHOGE_BLOCK = BLOCKS.register("red_ahoge_block", RedAhogeBlock::new);
    public static final RegistryObject<Block> COMMUNICATION_TABLE = BLOCKS.register("communication_table", CommunicationTable::new);
}
