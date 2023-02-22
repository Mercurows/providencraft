package tech.lq0.providencraft;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;
import tech.lq0.providencraft.client.ClientHandler;
import tech.lq0.providencraft.init.*;
import tech.lq0.providencraft.loot.LootTableHandler;

@Mod("providencraft")
public class Utils {
    public static final String MOD_ID = "providencraft";

    public Utils() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GeckoLib.initialize();

        ItemRegistry.ITEMS.register(eventBus);
        EffectRegistry.EFFECTS.register(eventBus);
        PotionRegistry.POTION_TYPES.register(eventBus);
        EnchantRegistry.ENCHANTMENTS.register(eventBus);
        SoundRegistry.SOUNDS.register(eventBus);
        EntityRegistry.ENTITY_TYPES.register(eventBus);
        VillagerInit.POINTS_OF_INTEREST.register(eventBus);
        VillagerInit.PROFESSIONS.register(eventBus);
        BlockRegistry.BLOCKS.register(eventBus);
        AttributeRegistry.ATTRIBUTES.register(eventBus);
        ParticleRegistry.PARTICLE_TYPES.register(eventBus);
        TileEntityRegistry.TILE_ENTITY_TYPES.register(eventBus);
        LootTableHandler.init(eventBus);

        eventBus.addListener(this::onClientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    public void onClientSetup(FMLClientSetupEvent event){
        ClientHandler.init();
    }

    @SubscribeEvent
    public void loadLootTable(LootTableLoadEvent event){
        LootTableRegistry.getRegistry().loadLootTable(event);
    }
}
