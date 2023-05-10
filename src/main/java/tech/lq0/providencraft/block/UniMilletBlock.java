package tech.lq0.providencraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;
import tech.lq0.providencraft.init.ItemRegistry;

public class UniMilletBlock extends CropsBlock {
    public UniMilletBlock(){
        super(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP));
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return ItemRegistry.UNI_MILLET.get();
    }
}
