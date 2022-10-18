package tech.lq0.providencraft.init;

import com.google.common.collect.Maps;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.advancements.criterion.FillLavaTrigger;

import java.util.Map;

public class CriteriaRegistry {
    public static final Map<ResourceLocation, ICriterionTrigger<?>> REGISTRY = Maps.newHashMap();
    public static final FillLavaTrigger FILL_LAVA = register(new FillLavaTrigger());

    public static <T extends ICriterionTrigger<?>> T register(T criterion) {
        if (REGISTRY.containsKey(criterion.getId())) {
            throw new IllegalArgumentException("Duplicate criterion id " + criterion.getId());
        } else {
            REGISTRY.put(criterion.getId(), criterion);
            return criterion;
        }
    }
}
