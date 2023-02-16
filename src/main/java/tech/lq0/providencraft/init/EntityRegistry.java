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
                            EntityClassification.MISC).size(0.0f, 0.0f).setCustomClientFactory((spawnEntity, world) -> new SeatEntity(world)).build("seat_entity"));
    public static final RegistryObject<EntityType<DaifukuSyrupEntity>> DAIFUKU_SYRUP_ENTITY =
            ENTITY_TYPES.register("daifuku_syrup_entity",
                    () -> EntityType.Builder.<DaifukuSyrupEntity>create(DaifukuSyrupEntity::new, EntityClassification.MISC).size(0.2f, 0.2f).build("daifuku_syrup_entity"));
    public static final RegistryObject<EntityType<FluffBallEntity>> FLUFF_BALL_ENTITY =
            ENTITY_TYPES.register("fluff_ball_entity",
                    () -> EntityType.Builder.<FluffBallEntity>create(FluffBallEntity::new, EntityClassification.MISC).size(0.3f, 0.3f).build("fluff_ball_entity"));
    public static final RegistryObject<EntityType<KurumiBoomerangEntity>> KURUMI_BOOMERANG_ENTITY =
            ENTITY_TYPES.register("kurumi_boomerang_entity",
                    () -> EntityType.Builder.<KurumiBoomerangEntity>create(KurumiBoomerangEntity::new, EntityClassification.MISC).size(1.0f, 0.3f).build("kurumi_boomerang_entity"));
    public static final RegistryObject<EntityType<WhiteAhogeEntity>> WHITE_AHOGE_ENTITY =
            ENTITY_TYPES.register("white_ahoge",
                    () -> EntityType.Builder.<WhiteAhogeEntity>create(WhiteAhogeEntity::new, EntityClassification.MISC).size(0.8f, 0.3f).build("white_ahoge"));
    public static final RegistryObject<EntityType<NiitCarEntity>> NIIT_CAR_ENTITY =
            ENTITY_TYPES.register("niit_car",
                    () -> EntityType.Builder.create(NiitCarEntity::new, EntityClassification.MISC).size(2.0f, 1.7f).build("niit_car"));
    public static final RegistryObject<EntityType<GoodManCardEntity>> GOOD_MAN_CARD_ENTITY =
            ENTITY_TYPES.register("good_man_card",
                    () -> EntityType.Builder.<GoodManCardEntity>create(GoodManCardEntity::new, EntityClassification.MISC).size(0.2f, 0.1f).build("good_man_card"));
    public static final RegistryObject<EntityType<WaterCardEntity>> WATER_CARD_ENTITY =
            ENTITY_TYPES.register("water_card",
                    () -> EntityType.Builder.<WaterCardEntity>create(WaterCardEntity::new, EntityClassification.MISC).size(0.1f, 0.3f).build("water_card"));
    public static final RegistryObject<EntityType<BloodCrystalEntity>> BLOOD_CRYSTAL_ENTITY =
            ENTITY_TYPES.register("blood_crystal",
                    () -> EntityType.Builder.<BloodCrystalEntity>create(BloodCrystalEntity::new, EntityClassification.MISC).size(0.1f, 0.1f).build("blood_crystal"));
    public static final RegistryObject<EntityType<CursedCatDollEntity>> CURSED_CAT_DOLL_ENTITY =
            ENTITY_TYPES.register("cursed_cat_doll",
                    () -> EntityType.Builder.<CursedCatDollEntity>create(CursedCatDollEntity::new, EntityClassification.MISC).size(0.3f,0.3f).build("cursed_cat_doll"));
    public static final RegistryObject<EntityType<TracheliumBulletEntity>> TRACHELIUM_BULLET_ENTITY =
            ENTITY_TYPES.register("trachelium_bullet",
                    () -> EntityType.Builder.<TracheliumBulletEntity>create(TracheliumBulletEntity::new, EntityClassification.MISC).size(0.1f,0.1f).build("trachelium_bullet"));
}
