package tech.lq0.providencraft.integration;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import tech.lq0.providencraft.integration.vrc.VirtuaRealCraftRegistry;
import tech.lq0.providencraft.group.ModGroup;

public class CompatHandler {
    public static boolean virtuarealcraft;
    public static boolean target;

    static {
        ModList modList = ModList.get();
        virtuarealcraft = modList.isLoaded("virtuarealcraft");
        target = modList.isLoaded("target");
    }

    @SuppressWarnings({"StatementWithEmptyBody", "ConstantConditions"})
    public static void registerCompatItems(IEventBus eventBus) {
        boolean test_flag = true;

        getIntegration();
        if(virtuarealcraft){
            //TODO 把target的内容移至此处
        }
        if(target || test_flag){
            VirtuaRealCraftRegistry.VRC_ITEMS.register(eventBus);
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static void getIntegration(){
        //测试环境下设置为true
        boolean test_flag = true;

        if(virtuarealcraft || target || test_flag){
            ModGroup.initIntegrationGroup();
        }
    }
}
