package dev.allay.moody.events

import dev.allay.moody.PaperMoody
import dev.allay.moody.PaperMoodyPlayer
import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.TextComponent
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener

class MoodyChatEvents(
    private val plugin: PaperMoody,
) : Listener {

    @EventHandler(
        priority = EventPriority.MONITOR,
        ignoreCancelled = true,
    )
    fun asyncChatEvent(event: AsyncChatEvent) {
        val textComponent = event.originalMessage() as TextComponent
        val moodyPlayer = PaperMoodyPlayer(event.player, plugin.moody)
        plugin.moody.handleMessage(textComponent.content(), moodyPlayer)
    }

}