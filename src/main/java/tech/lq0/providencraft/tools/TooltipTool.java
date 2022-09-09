package tech.lq0.providencraft.tools;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.*;

import java.util.List;

public class TooltipTool {
    public static void addHideText(List<ITextComponent> tooltip, ITextComponent text) {
        if (Screen.hasShiftDown()) {
            tooltip.add(text);
        }
    }

    public static void addLiverInfo(List<ITextComponent> tooltip, Livers liver){
        addHideText(tooltip, new StringTextComponent(""));
        addHideText(tooltip, new TranslationTextComponent("liver").mergeStyle(TextFormatting.WHITE));
        addHideText(tooltip, new TranslationTextComponent(liver.getName()).mergeStyle(Style.EMPTY.setColor(Color.fromHex(liver.getColor()))));
        String gen = liver.getGen();
        TextFormatting textFormatting = TextFormatting.RESET;
        switch (gen){
            case "zero":
                textFormatting = TextFormatting.LIGHT_PURPLE;
                break;
            case "first":
                textFormatting = TextFormatting.YELLOW;
                break;
            case "second":
                textFormatting = TextFormatting.BLUE;
                break;
            case "magicros":
                textFormatting = TextFormatting.GREEN;
                break;
            case "third":
                textFormatting = TextFormatting.DARK_AQUA;
                break;
            case "poi":
                textFormatting = TextFormatting.DARK_RED;
                break;
        }
        if(liver.getName().equals("maria") || liver.getName().equals("mojuko")){
            addHideText(tooltip, new TranslationTextComponent("description_" + gen).mergeStyle(textFormatting).
                    mergeStyle(TextFormatting.BOLD).mergeStyle(TextFormatting.STRIKETHROUGH));
        }else {
            addHideText(tooltip, new TranslationTextComponent("description_" + gen).mergeStyle(textFormatting).mergeStyle(TextFormatting.BOLD));
        }
    }
}
