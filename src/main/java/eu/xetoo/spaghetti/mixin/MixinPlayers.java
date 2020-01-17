package eu.xetoo.spaghetti.mixin;

import net.minecraft.client.network.OtherClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OtherClientPlayerEntity.class)
public class MixinPlayers {

    @Inject(method = "tickMovement()V", at = @At("RETURN"))
    public void otherPlayerTick(CallbackInfo ci) {
        OtherClientPlayerEntity e = (OtherClientPlayerEntity) (Object) this;
        System.out.println(e.getPos().x);
        System.out.println(e.getPos().y);
        System.out.println(e.getPos().z);
    }
}
