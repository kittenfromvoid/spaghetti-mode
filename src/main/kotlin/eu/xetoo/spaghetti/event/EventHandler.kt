package eu.xetoo.spaghetti.event

import net.minecraft.client.MinecraftClient

interface EventHandler {
    val type: Event

    fun run(minecraftClient: MinecraftClient)
}