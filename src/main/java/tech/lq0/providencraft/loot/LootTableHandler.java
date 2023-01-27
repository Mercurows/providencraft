package tech.lq0.providencraft.loot;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tech.lq0.providencraft.Utils;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

/**
 * from vanilla-boom mod
 */
public class LootTableHandler {
    private static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, Utils.MOD_ID);

    private static final RegistryObject<FishLootModifier.Serializer> FISH = LOOT.register("fish", FishLootModifier.Serializer::new);

    public static void init(IEventBus modEventBus) {
        LOOT.register(modEventBus);
    }

    public static class FishLootModifier extends LootModifier {
        protected final TableLootEntry table;
        protected final float chance;
        private static final Field LOOT_FIELD = ObfuscationReflectionHelper.findField(LootContext.class, "field_186504_g");

        public FishLootModifier(ILootCondition[] conditions, TableLootEntry lootTable, float replaceChance) {
            super(conditions);
            table = lootTable;
            chance = replaceChance;
        }

        @Nonnull
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
            try {
                Set<LootTable> set = (Set<LootTable>) LOOT_FIELD.get(context);

                if (set.isEmpty() && context.getRandom().nextFloat() <= chance) {
                    List<ItemStack> loot = Lists.newArrayList();
                    table.func_216154_a(loot::add, context);

                    return loot;
                }
                else {
                    return generatedLoot;
                }
            }
            catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException("Could not access lootTables", e);
            }
        }

        public static class Serializer extends GlobalLootModifierSerializer<FishLootModifier> {
            @Override
            public FishLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] lootConditions) {
                String resLoc = JSONUtils.getString(object, "table");
                TableLootEntry table = (TableLootEntry) TableLootEntry.builder(new ResourceLocation(resLoc)).build();
                float chance = JSONUtils.getFloat(object, "chance");

                return new FishLootModifier(lootConditions, table, chance);
            }

            @Override
            public JsonObject write(FishLootModifier instance) {
                JsonObject json = makeConditions(instance.conditions);
                json.addProperty("table", instance.table.table.toString());
                json.addProperty("chance", instance.chance);
                return json;
            }
        }
    }
}
