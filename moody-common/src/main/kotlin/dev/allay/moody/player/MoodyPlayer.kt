package dev.allay.moody.player

import dev.allay.moody.Moody
import dev.allay.moody.config.MoodyType
import java.util.UUID

interface MoodyPlayer<Player, Item> {
    val player: Player
    val moody: Moody<out MoodyPlayer<Player, Item>, Item>

    val uniqueId: UUID
    var currentHeadItem: Item?

    fun createItem(moodyType: MoodyType): Item
    fun handle(moodyType: MoodyType?, handleType: HandleType)
}