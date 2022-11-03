package tech.lq0.providencraft.register;

import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.entity.NiitCarEntity;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class NiitCarEvent {
    public NiitCarEvent() {

    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        GameSettings settings = minecraft.gameSettings;
        PlayerEntity player = minecraft.player;

        if (player == null) {
            return;
        }

        Entity riding = player.getRidingEntity();

        if (!(riding instanceof NiitCarEntity)) {
            return;
        }

        NiitCarEntity car = (NiitCarEntity) riding;

        if (player.equals(car.getControllingPassenger())) {
            car.updateInputs(settings.keyBindLeft.isKeyDown(), settings.keyBindRight.isKeyDown(),
                    settings.keyBindForward.isKeyDown(), settings.keyBindBack.isKeyDown());
        }
    }
}
