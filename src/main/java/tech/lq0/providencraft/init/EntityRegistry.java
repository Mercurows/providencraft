package tech.lq0.providencraft.init;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.AhogeBoomerangEntity;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Utils.MOD_ID);

    public static final RegistryObject<EntityType<AhogeBoomerangEntity>> AHOGE_BOOMERANG_ENTITY =
            ENTITY_TYPES.register("ahoge_boomerang",
                    ()->EntityType.Builder.create(AhogeBoomerangEntity::new, EntityClassification.MISC).size(0.5f,0.5f).build("ahoge_boomerang"));
    //public static final  RegistryObject<EntityType<MumuCowEntity>> MUMU_COW =
            //ENTITY_TYPES.register("mumu_cow", ()->EntityType.Builder.<MumuCowEntity>create(MumuCowEntity::new,EntityClassification.MISC).size(0.9f,1.4f).trackingRange(10).build("mumu_cow"));
}
