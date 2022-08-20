package tech.lq0.providencraft.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.*;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Utils.MOD_ID);

    public static final RegistryObject<EntityType<AhogeBoomerangEntity>> AHOGE_BOOMERANG_ENTITY =
            ENTITY_TYPES.register("ahoge_boomerang",
                    () -> EntityType.Builder.<AhogeBoomerangEntity>create(AhogeBoomerangEntity::new, EntityClassification.MISC).size(0.8f, 0.3f).build("ahoge_boomerang"));
    public static final RegistryObject<EntityType<PlungerEntity>> PLUNGER_ENTITY =
            ENTITY_TYPES.register("plunger_entity",
                    () -> EntityType.Builder.<PlungerEntity>create(PlungerEntity::new, EntityClassification.MISC).size(0.3f, 0.3f).build("plunger_entity"));
    public static final RegistryObject<EntityType<SeatEntity>> SEAT_ENTITY =
            ENTITY_TYPES.register("seat_entity",
                    () -> EntityType.Builder.<SeatEntity>create((type, world) -> new SeatEntity(world),
                            EntityClassification.MISC).size(0.0f,0.0f).setCustomClientFactory((spawnEntity, world) -> new SeatEntity(world)).build("seat_entity"));
    public static final RegistryObject<EntityType<DaifukuSyrupEntity>> DAIFUKU_SYRUP_ENTITY =
            ENTITY_TYPES.register("daifuku_syrup_entity",
                    () -> EntityType.Builder.<DaifukuSyrupEntity>create(DaifukuSyrupEntity::new, EntityClassification.MISC).size(0.2f, 0.2f).build("daifuku_syrup_entity"));
    public static final RegistryObject<EntityType<FluffBallEntity>> FLUFF_BALL_ENTITY =
            ENTITY_TYPES.register("fluff_ball_entity",
                    () -> EntityType.Builder.<FluffBallEntity>create(FluffBallEntity::new, EntityClassification.MISC).size(0.3f,0.3f).build("fluff_ball_entity"));
    public static final RegistryObject<EntityType<KurumiBoomerangEntity>> KURUMI_BOOMERANG_ENTITY =
            ENTITY_TYPES.register("kurumi_boomerang_entity",
                    () -> EntityType.Builder.<KurumiBoomerangEntity>create(KurumiBoomerangEntity::new, EntityClassification.MISC).size(1.0f, 0.3f).build("kurumi_boomerang_entity"));
}
