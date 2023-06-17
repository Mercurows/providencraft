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

    public static void addDevelopingText(List<ITextComponent> tooltip) {
        tooltip.add(new StringTextComponent("本物品还在开发中，[海芭拉_别急]").mergeStyle(TextFormatting.BOLD).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#ADDBFF"))));
    }

    public static void addLiverInfo(List<ITextComponent> tooltip, Livers liver) {
        addHideText(tooltip, new StringTextComponent(""));
        addHideText(tooltip, new TranslationTextComponent("liver.providencraft.liver").mergeStyle(TextFormatting.WHITE));
        addHideText(tooltip, new TranslationTextComponent("liver.providencraft." + liver.getName()).mergeStyle(Style.EMPTY.setColor(Color.fromHex(liver.getColor()))));
        String gen = liver.getGen();
        String bgColor = "#FFFFFF";
        switch (gen) {
            case "zero":
                bgColor = "#FF63A7";
                break;
            case "first":
                bgColor = "#D44448";
                break;
            case "second":
                bgColor = "#6CBE96";
                break;
            case "magicros":
                bgColor = "#B4DDFF";
                break;
            case "third":
                bgColor = "#0076FE";
                break;
            case "poi":
                bgColor = "#F9F0D8";
                break;
            case "connections":
                bgColor = "#B2453F";
                break;
        }
        if (liver.getName().equals("maria") || liver.getName().equals("mojuko") || liver.getName().equals("shirako")) {
            addHideText(tooltip, new TranslationTextComponent("des.providencraft.group." + gen).mergeStyle(Style.EMPTY.setColor(Color.fromHex(bgColor))).
                    mergeStyle(TextFormatting.BOLD).mergeStyle(TextFormatting.STRIKETHROUGH));
        } else {
            addHideText(tooltip, new TranslationTextComponent("des.providencraft.group." + gen).mergeStyle(Style.EMPTY.setColor(Color.fromHex(bgColor))).mergeStyle(TextFormatting.BOLD));
        }
    }

    public static void addChaosInfo(List<ITextComponent> tooltip, int chaos) {
        TextFormatting textFormatting;
        StringBuilder builder = new StringBuilder();
        if(chaos > 0){
            textFormatting = TextFormatting.BLUE;
            builder.append("+").append(chaos).append(" ").append(new TranslationTextComponent("des.providencraft.chaos").getString());
        }else if(chaos < 0){
            textFormatting = TextFormatting.GREEN;
            builder.append("-").append(Math.abs(chaos)).append(" ").append(new TranslationTextComponent("des.providencraft.chaos").getString());
        }else {
            return;
        }
        addHideText(tooltip, new StringTextComponent(""));
        addHideText(tooltip, new TranslationTextComponent("des.providencraft.chaos.eaten").mergeStyle(TextFormatting.GRAY));
        addHideText(tooltip, new StringTextComponent(builder.toString()).mergeStyle(textFormatting));
    }
}
