package eu.xetoo.spaghetti

import net.minecraft.client.MinecraftClient
import net.minecraft.entity.Entity
import net.minecraft.util.math.Box
import org.lwjgl.opengl.GL11


object PropESP {
    
    var runs = false

    var playerBox = 0

    fun toogle() {
        runs = runs.not()
        if (runs) {
            playerBox = GL11.glGenLists(1)
            GL11.glNewList(playerBox, GL11.GL_COMPILE)
            val bb = Box(-0.5, 0.0, -0.5, 0.5, 1.0, 0.5)
            RenderUtils.drawBox(bb)
            GL11.glEndList()
        } else {
            GL11.glDeleteLists(playerBox, 1);
            playerBox = 0;
        }
    }

    fun render(partialTicks: Double) {
        if (!runs) return
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glLineWidth(2f);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);

        GL11.glPushMatrix();
        RenderUtils.applyRenderOffset();

        MinecraftClient.getInstance()
            .world?.entities?.filter { it.isLiving && it != MinecraftClient.getInstance().player }?.forEach {
            GL11.glPushMatrix()

            GL11.glTranslated(
                it.prevX + (it.getX() - it.prevX) * partialTicks,
                it.prevY + (it.getY() - it.prevY) * partialTicks,
                it.prevZ + (it.getZ() - it.prevZ) * partialTicks
            )

            GL11.glScaled(
                it.getWidth() + 0.1, it.getHeight() + 0.1,
                it.getWidth() + 0.1
            )

            val f: Float = MinecraftClient.getInstance().player?.distanceTo(it)?.div(20f) ?: 0f
            GL11.glColor4f(2 - f, f, 0f, 0.5f)

            GL11.glCallList(playerBox)

            GL11.glPopMatrix()
        }



        GL11.glPopMatrix();

        // GL resets
        GL11.glColor4f(1f, 1f, 1f, 1f);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        // draw boxes

    }

}

