package tech.lq0.providencraft.compat;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import tech.lq0.providencraft.compat.vrc.VirtuaRealCraftRegistry;
import tech.lq0.providencraft.group.ModGroup;

public class CompatHandler {
    public static boolean virtuarealcraft;
    public static boolean target;

    static {
        ModList modList = ModList.get();
        virtuarealcraft = modList.isLoaded("virtuarealcraft");
        target = modList.isLoaded("target");
    }

    public static void registerCompatItems(IEventBus eventBus) {
        getIntegration();
        if(virtuarealcraft){
            //TODO 把target的内容移至此处
        }
        if(target){
            VirtuaRealCraftRegistry.VRC_ITEMS.register(eventBus);
        }
    }

    public static void getIntegration(){
        if(virtuarealcraft || target){
            ModGroup.initIntegrationGroup();
        }
    }
}
