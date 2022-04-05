package tech.lq0.providencraft.init;

import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;

public class AttributeRegistry {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, Utils.MOD_ID);

    public static final RegistryObject<Attribute> ATTACK_COW = ATTRIBUTES.register("attack_cow",
            () -> (new RangedAttribute("attribute.attack_cow", 0.0D, 0.0D, 200.0D)).setShouldWatch(true));
    public static final RegistryObject<Attribute> ATTACK_COPPER = ATTRIBUTES.register("attack_copper",
            () -> (new RangedAttribute("attribute.attack_copper", 0.0D, 0.0D, 200.0D)).setShouldWatch(true));
}
