package dev.allay.moody

import dev.allay.moody.config.MoodyType
import dev.allay.moody.player.HandleType
import dev.allay.moody.player.MoodyPlayer
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture

class Moody<Player : MoodyPlayer<*, Item>, Item>(file: File) {

    private val storage = MoodyStorage(file)
    private val executor = Executors.newSingleThreadScheduledExecutor()
    private val playerMoody = mutableMapOf<Player, ScheduledFuture<*>>()

    val cachedItemTypes = mutableMapOf<MoodyType, Item>()

    fun enable() {
        storage.createConfig()
        storage.loadConfig()
    }

    fun disable() {
        playerMoody.forEach { (player, task) ->
            player.handle(null, HandleType.DISARM)
            task.cancel(true)
        }
    }

    fun handleMessage(message: String, player: Player) {
        val (enabled, delay, types) = storage.config
        if (enabled.not() or hasMoody(player)) {
            return
        }
        val moodyTypes = types.filter {
            val result = it.regex.find(message) ?: return@filter false
            return@filter it.symbols.contains(result.value)
        }
        if (moodyTypes.isEmpty()) {
            return
        }
        val moodyType = moodyTypes.random()

        player.handle(moodyType, HandleType.EQUIP)
        playerMoody[player] = executor.schedule({
            player.handle(moodyType, HandleType.DISARM)
            playerMoody.remove(player)
        }, delay.time, delay.unit)
    }

    private fun hasMoody(player: Player) =
        playerMoody.keys.any { it.uniqueId == player.uniqueId }

}