package tech.lq0.providencraft.item.blockitem;

import net.minecraft.item.BlockItem;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.BlockRegistry;

public class PointsStoreBlockItem extends BlockItem {
    public PointsStoreBlockItem() {
        super(BlockRegistry.POINTS_STORE.get(), new Properties().group(ModGroup.blockgroup));
    }
}
