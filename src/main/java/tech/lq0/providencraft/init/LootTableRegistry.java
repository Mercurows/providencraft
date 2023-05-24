package tech.lq0.providencraft.init;

import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;
import tech.lq0.providencraft.Utils;

import java.util.HashMap;
import java.util.Map;

public class LootTableRegistry {
    public static final ResourceLocation PDC_CHEST = new ResourceLocation(Utils.MOD_ID, "chests/pdc_chest");
    public static final ResourceLocation PDC_DISC_CHEST = new ResourceLocation(Utils.MOD_ID, "chests/pdc_disc_chest");
    public static final ResourceLocation PDC_IGLOO_CHEST = new ResourceLocation(Utils.MOD_ID, "chests/pdc_igloo_chest");

    private static LootTableRegistry registry;

    private Map<ResourceLocation, ResourceLocation> lootTables = new HashMap<>();

    private LootTableRegistry(){
        init();
    }

    public void init(){
        lootTables.put(LootTables.CHESTS_SIMPLE_DUNGEON, PDC_CHEST);
        lootTables.put(LootTables.CHESTS_DESERT_PYRAMID, PDC_CHEST);
        lootTables.put(LootTables.CHESTS_ABANDONED_MINESHAFT, PDC_CHEST);
        lootTables.put(LootTables.CHESTS_END_CITY_TREASURE, PDC_DISC_CHEST);
        lootTables.put(LootTables.CHESTS_IGLOO_CHEST, PDC_IGLOO_CHEST);
    }

    public static LootTableRegistry getRegistry(){
        if(registry == null){
            registry = new LootTableRegistry();
        }
        return registry;
    }

    public void loadLootTable(LootTableLoadEvent event){
        if(lootTables.containsKey(event.getName())){
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(lootTables.get(event.getName()))).name(Utils.MOD_ID + ":loot:" + event.getName()).build());
        }
    }
}
