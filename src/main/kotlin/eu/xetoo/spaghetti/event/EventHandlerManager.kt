package eu.xetoo.spaghetti.event

import net.minecraft.client.MinecraftClient

object EventHandlerManager {
    val eventHandlers = mutableMapOf<Event, EventHandler>()

    fun everyTick(mc: MinecraftClient) {
        eventHandlers.forEach { if (it.key == Event.worldTick) it.value.run(mc) }
    }
}