package tech.lq0.providencraft.item.donate;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.SoundRegistry;

import javax.annotation.Nullable;
import java.util.List;

public class MusicDiscSongOfAutumn extends MusicDiscItem {
    public MusicDiscSongOfAutumn() {
        super(7, SoundRegistry.SONG_OF_AUTUMN, new Properties().maxStackSize(1).group(ModGroup.donategroup).rarity(Rarity.RARE));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.music_disc_song_of_autumn_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.music_disc_song_of_autumn_2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.donate_item")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    public IFormattableTextComponent getDescription() {
        return new TranslationTextComponent("des.providencraft.music_disc_song_of_autumn_1");
    }
}
