package eu.xetoo.spaghetti.mixin;

import eu.xetoo.spaghetti.event.EventHandlerManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Shadow
    public ClientWorld world;

    @Inject(method = "tick()V", at = @At("RETURN"))
    private void onGameTick(CallbackInfo callbackInfo) {
        EventHandlerManager.INSTANCE.everyTick((MinecraftClient) (Object) this);
    }
}
