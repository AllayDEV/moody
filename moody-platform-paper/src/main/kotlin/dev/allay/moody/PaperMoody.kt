package dev.allay.moody

import dev.allay.moody.events.MoodyChatEvents
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class PaperMoody : JavaPlugin() {

    private val moodyFile = File("./plugins/Moody/config.json")
    val moody = Moody<PaperMoodyPlayer, ItemStack>(moodyFile)

    override fun onEnable() {
        moody.enable()
        registerEvents()
    }

    override fun onDisable() {
        moody.disable()
    }

    private fun registerEvents() {
        val pluginManager = server.pluginManager
        pluginManager.registerEvents(MoodyChatEvents(this), this)
    }

}