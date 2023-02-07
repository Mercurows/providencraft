package tech.lq0.providencraft.init;

import net.minecraft.loot.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LootTableRegistry {
    public static final ResourceLocation PDC_CHEST = new ResourceLocation(Utils.MOD_ID, "chests/simple_dungeon");

//    @SubscribeEvent
//    public static void loadLootTable(final LootTableLoadEvent event){
//        if(event.getName().equals(PDC_CHEST)){
//            LootTableLoadEvent newEvent = new LootTableLoadEvent(LootTables.CHESTS_SIMPLE_DUNGEON, event.getTable(), event.getLootTableManager());
//            if (!MinecraftForge.EVENT_BUS.post(newEvent) && newEvent.getTable() != null) {
//                event.setTable(newEvent.getTable());
//            }
//        }
//    }
}
