package tech.lq0.providencraft.entity.boundingbox;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

//Forked from MrCrayfish and TaC
public class BoundingBoxManager {
    private static Map<EntityType<?>, IHeadBox<?>> headshotBoxes = new HashMap<>();
    private static WeakHashMap<PlayerEntity, LinkedList<AxisAlignedBB>> playerBoxes = new WeakHashMap<>();

    static {
        registerHeadshotBox(EntityType.PLAYER, (entity) -> {
            AxisAlignedBB headBox = new AxisAlignedBB(-4 * 0.0625, 0, -4 * 0.0625, 4 * 0.0625, 8 * 0.0625, 4 * 0.0625);
            double scale = 30.0 / 32.0;
            if(entity.isSwimming()) {
                headBox = headBox.offset(0, 3 * 0.0625, 0);
                Vector3d pos = Vector3d.fromPitchYaw(entity.rotationPitch, entity.renderYawOffset).normalize().scale(0.8);
                headBox = headBox.offset(pos);
            }
            else {
                headBox = headBox.offset(0, entity.isSneaking() ? 20 * 0.0625 : 24 * 0.0625, 0);
            }
            return new AxisAlignedBB(headBox.minX * scale, headBox.minY * scale, headBox.minZ * scale, headBox.maxX * scale, headBox.maxY * scale, headBox.maxZ * scale);
        });

        registerHeadshotBox(EntityType.ZOMBIE, new SmallHeadBox<>(8.0, 24.0, 0.75, 0.5));
        registerHeadshotBox(EntityType.ZOMBIFIED_PIGLIN, new SmallHeadBox<>(8.0, 24.0, 0.75, 0.5));
        registerHeadshotBox(EntityType.HUSK, new SmallHeadBox<>(8.0, 24.0, 0.75, 0.5));
        registerHeadshotBox(EntityType.SKELETON, new HeadshotBox<>(8.0, 24.0));
        registerHeadshotBox(EntityType.STRAY, new HeadshotBox<>(8.0, 24.0));
        registerHeadshotBox(EntityType.CREEPER, new HeadshotBox<>(8.0, 18.0));
        registerHeadshotBox(EntityType.SPIDER, new RotatedHeadBox<>(8.0, 5.0, 7.0, false, true));
        registerHeadshotBox(EntityType.DROWNED, new HeadshotBox<>(8.0, 24.0));
        registerHeadshotBox(EntityType.VILLAGER, new NoChildHeadshotBox<>(8.0, 9.0, 23.0));
        registerHeadshotBox(EntityType.ZOMBIE_VILLAGER, new NoChildHeadshotBox<>(8.0, 9.0, 23.0));
        registerHeadshotBox(EntityType.VINDICATOR, new NoChildHeadshotBox<>(8.0, 9.0, 23.0));
        registerHeadshotBox(EntityType.EVOKER, new HeadshotBox<>(8.0, 9.0, 23.0));
        registerHeadshotBox(EntityType.PILLAGER, new HeadshotBox<>(8.0, 9.0, 23.0));
        registerHeadshotBox(EntityType.ILLUSIONER, new HeadshotBox<>(8.0, 9.0, 23.0));
        registerHeadshotBox(EntityType.WANDERING_TRADER, new HeadshotBox<>(8.0, 9.0, 23.0));
        registerHeadshotBox(EntityType.WITCH, new HeadshotBox<>(8.0, 9.0, 23.0));
        registerHeadshotBox(EntityType.SHEEP, new RotatedHeadBox<>(7.5, 8.0, 15.0, 9.5, false, true));
        registerHeadshotBox(EntityType.CHICKEN, new NoChildRotatedHeadBox<>(4.0, 6.0, 9.0, 5.0, false, true));
        registerHeadshotBox(EntityType.COW, new NoChildRotatedHeadBox<>(7.5, 8.0, 16.0, 10.5, false, true));
        registerHeadshotBox(EntityType.MOOSHROOM, new NoChildRotatedHeadBox<>(7.5, 8.0, 16.0, 10.5, false, true));
        registerHeadshotBox(EntityType.PIG, new NoChildRotatedHeadBox<>(8.0, 8.0, 10, false, true));
        registerHeadshotBox(EntityType.HORSE, new RotatedHeadBox<>(10.0, 26.0, 16.0, false, true));
        registerHeadshotBox(EntityType.SKELETON_HORSE, new RotatedHeadBox<>(10.0, 26.0, 16.0, false, true));
        registerHeadshotBox(EntityType.DONKEY, new RotatedHeadBox<>(7.5, 8.0, 20.0, 13.0, false, true));
        registerHeadshotBox(EntityType.MULE, new RotatedHeadBox<>(7.5, 8.0, 21.0, 14.0, false, true));
        registerHeadshotBox(EntityType.LLAMA, new RotatedHeadBox<>(8.0, 26.0, 10.0, false, true));
        registerHeadshotBox(EntityType.TRADER_LLAMA, new RotatedHeadBox<>(8.0, 26.0, 10.0, false, true));
        registerHeadshotBox(EntityType.POLAR_BEAR, new RotatedHeadBox<>(9.0, 12.0, 20.0, false, true));
        registerHeadshotBox(EntityType.SNOW_GOLEM, new HeadshotBox<>(10.0, 20.5));
        registerHeadshotBox(EntityType.TURTLE, new RotatedHeadBox<>(6.0, 5.0, 1.0, 10.0, false, true));
        registerHeadshotBox(EntityType.IRON_GOLEM, new RotatedHeadBox<>(8.0, 10.0, 33.0, 3.5, false, true));
        registerHeadshotBox(EntityType.PHANTOM, new RotatedHeadBox<>(6.0, 3.0, 1.5, 6.5, true, true));
        registerHeadshotBox(EntityType.HOGLIN, new RotatedHeadBox<>(14.0, 16.0, 7.0, 19.0, false, true));
        registerHeadshotBox(EntityType.ZOGLIN, new RotatedHeadBox<>(14.0, 16.0, 7.0, 19.0, false, true));
        registerHeadshotBox(EntityType.PIGLIN, new SmallHeadBox<>(8.0, 24.0, 0.75, 0.5));
    }

    public static <T extends LivingEntity> void registerHeadshotBox(EntityType<T> type, IHeadBox<T> headshotBox) {
        headshotBoxes.putIfAbsent(type, headshotBox);
    }

    @Nullable
    public static <T extends Entity> IHeadBox<T> getHeadshotBoxes(EntityType<T> type) {
        return (IHeadBox<T>) headshotBoxes.get(type);
    }

    @SubscribeEvent(receiveCanceled = true)
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER && event.phase == TickEvent.Phase.END) {
            if(event.player.isSpectator()) {
                playerBoxes.remove(event.player);
                return;
            }
            LinkedList<AxisAlignedBB> boxes = playerBoxes.computeIfAbsent(event.player, player -> new LinkedList<>());
            boxes.addFirst(event.player.getBoundingBox());
            if(boxes.size() > 20) {
                boxes.removeLast();
            }
        }
    }

    @SubscribeEvent(receiveCanceled = true)
    public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        playerBoxes.remove(event.getPlayer());
    }

    public static AxisAlignedBB getBoundingBox(PlayerEntity entity, int ping) {
        if(playerBoxes.containsKey(entity)) {
            LinkedList<AxisAlignedBB> boxes = playerBoxes.get(entity);
            int index = MathHelper.clamp(ping, 0, boxes.size() - 1);
            return boxes.get(index);
        }
        return entity.getBoundingBox();
    }
}
