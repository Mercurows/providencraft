package tech.lq0.providencraft;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tech.lq0.providencraft.integration.CompatHandler;
import tech.lq0.providencraft.init.*;
import tech.lq0.providencraft.loot.LootTableHandler;
import tech.lq0.providencraft.world.biome.BlueDesertBiome;
import tech.lq0.providencraft.world.biome.HaranoPlainsBiome;

import java.util.Objects;

@Mod("providencraft")
public class Utils {
    public static final String MOD_ID = "providencraft";

    public Utils() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

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
        CompatHandler.registerCompatItems(eventBus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(BlueDesertBiome.blueDesertBiome))), BiomeDictionary.Type.DRY);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT,
                new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(BlueDesertBiome.blueDesertBiome))), 5));
        BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(HaranoPlainsBiome.haranoPlainsBiome))), BiomeDictionary.Type.DRY);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT,
                new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(HaranoPlainsBiome.haranoPlainsBiome))), 5));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @SubscribeEvent
    public void loadLootTable(LootTableLoadEvent event){
        LootTableRegistry.getRegistry().loadLootTable(event);
    }
}
