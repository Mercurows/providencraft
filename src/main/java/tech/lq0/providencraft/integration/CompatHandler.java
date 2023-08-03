package tech.lq0.providencraft.integration;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import tech.lq0.providencraft.integration.vrc.VirtuaRealCraftRegistry;
import tech.lq0.providencraft.group.ModGroup;

public class CompatHandler {
    public static boolean virtuarealcraft;

    static {
        ModList modList = ModList.get();
        virtuarealcraft = modList.isLoaded("virtuarealcraft");

        //测试用
        virtuarealcraft = true;
    }

    public static void registerCompatItems(IEventBus eventBus) {
        getIntegration();
        if(virtuarealcraft){
            VirtuaRealCraftRegistry.VRC_ITEMS.register(eventBus);
            VirtuaRealCraftRegistry.ENTITY_TYPES.register(eventBus);
        }
    }

    public static void getIntegration(){
        if(virtuarealcraft){
            ModGroup.initIntegrationGroup();
        }
    }
}
