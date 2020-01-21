package eu.xetoo.spaghetti

import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.*
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.util.math.Box
import net.minecraft.util.math.MathHelper
import org.lwjgl.opengl.GL11.*


object RenderUtils {
    fun drawBox(bb: Box) {
        val buffer = Tessellator.getInstance().buffer
        buffer.begin(GL_LINE_STRIP, VertexFormats.POSITION_COLOR)
        WorldRenderer.drawBox(buffer, bb.x1, bb.y1, bb.z1, bb.x2, bb.y2, bb.z2, 1f, 0f, 0f, 0.5f)
        Tessellator.getInstance().draw()
    }

    fun applyRenderOffset() {
        val camera = BlockEntityRenderDispatcher.INSTANCE.camera
        val camPos = camera.pos
        glRotated(MathHelper.wrapDegrees(camera.pitch).toDouble(), 1.0, 0.0, 0.0)
        glRotated(MathHelper.wrapDegrees(camera.yaw + 180.0), 0.0, 1.0, 0.0)
        glTranslated(-camPos.x, -camPos.y, -camPos.z)
    }
}