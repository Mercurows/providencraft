package tech.lq0.providencraft.integration.vrc;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.integration.vrc.item.chiharu.LittleSpringRoll;
import tech.lq0.providencraft.integration.vrc.item.koxia.Kuya;
import tech.lq0.providencraft.integration.vrc.item.koxia.KuyaEntity;
import tech.lq0.providencraft.integration.vrc.item.sui.SuimashedCookie;

public class VirtuaRealCraftRegistry {
    public static final DeferredRegister<Item> VRC_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> SUIMASHED_COOKIE = VRC_ITEMS.register("suimashed_cookie", SuimashedCookie::new);
    public static final RegistryObject<Item> KUYA = VRC_ITEMS.register("kuya", Kuya::new);
    public static final RegistryObject<Item> LITTLE_SPRING_ROLL = VRC_ITEMS.register("little_spring_roll", LittleSpringRoll::new);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Utils.MOD_ID);
    public static final RegistryObject<EntityType<KuyaEntity>> KUYA_ENTITY =
            ENTITY_TYPES.register("kuya",
                    () -> EntityType.Builder.<KuyaEntity>create(KuyaEntity::new, EntityClassification.MISC).size(0.3f,0.3f).build("kuya"));

}
