package tech.lq0.providencraft.capability;

//public class ChaosHelper {
//    private static final UUID CHAOS_MODIFIER_UUID =  new UUID(AttributeRegistry.CHAOS.hashCode(), 0);
//
//    public static void updateChaosAttribute(PlayerEntity player, double amount) {
//        if(player.world.isRemote){
//            return;
//        }
//
//        double base = player.getAttribute(AttributeRegistry.CHAOS.get()).getValue();
//
//        AttributeModifier modifier = new AttributeModifier(CHAOS_MODIFIER_UUID, "Chaos Modifier",
//                base + amount, AttributeModifier.Operation.ADDITION);
//        updateChaosAttributeModifier(player, modifier);
//    }
//
//    private static void updateChaosAttributeModifier(PlayerEntity player, AttributeModifier modifier) {
//        ModifiableAttributeInstance instance = getChaosAttribute(player);
//        instance.removeModifier(modifier);
//        instance.applyPersistentModifier(modifier);
//    }
//
//    private static ModifiableAttributeInstance getChaosAttribute(PlayerEntity player) {
//        return player.getAttribute(AttributeRegistry.CHAOS.get());
//    }
//}
