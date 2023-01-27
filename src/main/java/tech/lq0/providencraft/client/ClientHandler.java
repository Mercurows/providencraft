package tech.lq0.providencraft.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, value = Dist.CLIENT)
public class ClientHandler {
    public static void init(){
        MinecraftForge.EVENT_BUS.register(TracheliumHandler.getInstance());
    }
}
