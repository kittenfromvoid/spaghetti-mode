package eu.xetoo.spaghetti.mixin;

import eu.xetoo.spaghetti.PropESP;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class MixinGameRenderer {
    @Inject(method = "renderWorld(FJLnet/minecraft/client/util/math/MatrixStack;)V", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/render/GameRenderer;renderHand:Z"
    ))
    private void onRenderWorldLast(float partialTicks, long finishTimeNano, MatrixStack matrixStack, CallbackInfo ci) {
        PropESP.INSTANCE.render(partialTicks);
    }
}
