package tech.lq0.providencraft.advancements.criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.Utils;

public class FillLavaTrigger extends AbstractCriterionTrigger<FillLavaTrigger.Instance> {
    private static final ResourceLocation ID = new ResourceLocation(Utils.MOD_ID, "fill_lava");

    @Override
    protected Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
        ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
        return new Instance(entityPredicate, itempredicate);
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    public void test(ServerPlayerEntity player, ItemStack stack) {
        this.triggerListeners(player, (instance) -> instance.test(stack));
    }

    public static class Instance extends CriterionInstance{
        private final ItemPredicate itemPredicate;

        public Instance(EntityPredicate.AndPredicate entityCondition, ItemPredicate itemCondition){
            super(FillLavaTrigger.ID, entityCondition);
            this.itemPredicate = itemCondition;
        }

        public static FillLavaTrigger.Instance createNewInstance(ItemPredicate.Builder itemConditionBuilder) {
            return new FillLavaTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, itemConditionBuilder.build());
        }

        public boolean test(ItemStack stack) {
            return this.itemPredicate.test(stack);
        }

        public JsonObject serialize(ConditionArraySerializer conditions) {
            JsonObject jsonobject = super.serialize(conditions);

            jsonobject.add("item", this.itemPredicate.serialize());
            return jsonobject;
        }
    }
}
