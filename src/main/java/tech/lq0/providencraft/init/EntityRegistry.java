package tech.lq0.providencraft.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.AhogeBoomerangEntity;
import tech.lq0.providencraft.entity.PlungerEntity;
import tech.lq0.providencraft.entity.SeatEntity;

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
}
