package eu.xetoo.spaghetti

import eu.xetoo.spaghetti.event.handlers.PlayersTickHandler
import net.fabricmc.api.ModInitializer
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// For support join https://discord.gg/v6v4pMv

object SpaghettiMod : ModInitializer {

    const val MOD_ID = "spaghetti"


    override fun onInitialize() {
        PlayersTickHandler().register()
    }
}
