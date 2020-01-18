package eu.xetoo.spaghetti.event.handlers

import eu.xetoo.spaghetti.event.Event
import eu.xetoo.spaghetti.event.EventHandler
import net.minecraft.client.MinecraftClient

class PlayersTickHandler : EventHandler {
    override val type: Event = Event.worldTick

    override fun run(minecraftClient: MinecraftClient) {
        MinecraftClient.getInstance().world?.entities?.forEach {
            println(it.entityName)
        }
    }
}