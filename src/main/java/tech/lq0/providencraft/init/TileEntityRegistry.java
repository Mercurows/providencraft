package tech.lq0.providencraft.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.block.tile.MagicMirrorTileEntity;
import tech.lq0.providencraft.block.tile.PointsStoreTileEntity;

public class TileEntityRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Utils.MOD_ID);

    public static final RegistryObject<TileEntityType<PointsStoreTileEntity>> POINTS_STORE =
            TILE_ENTITY_TYPES.register("points_store",
                    () -> TileEntityType.Builder.create(PointsStoreTileEntity::new, BlockRegistry.POINTS_STORE.get()).build(null));
    public static final RegistryObject<TileEntityType<MagicMirrorTileEntity>> MAGIC_MIRROR =
            TILE_ENTITY_TYPES.register("magic_mirror",
                    () -> TileEntityType.Builder.create(MagicMirrorTileEntity::new, BlockRegistry.MAGIC_MIRROR_BLOCK.get()).build(null));

}
