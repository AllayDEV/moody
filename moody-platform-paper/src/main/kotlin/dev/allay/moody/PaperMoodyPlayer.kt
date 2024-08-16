package dev.allay.moody

import dev.allay.moody.config.MoodyType
import dev.allay.moody.player.HandleType
import dev.allay.moody.player.MoodyPlayer
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import java.net.URI
import java.util.*

class PaperMoodyPlayer(
    override val player: Player,
    override val moody: Moody<out MoodyPlayer<Player, ItemStack>, ItemStack>,
) : MoodyPlayer<Player, ItemStack> {

    override val uniqueId: UUID = player.uniqueId
    override var currentHeadItem: ItemStack? = null

    override fun createItem(moodyType: MoodyType): ItemStack {
        if (moody.cachedItemTypes.containsKey(moodyType)) {
            return moody.cachedItemTypes[moodyType]!!
        }
        val itemStack = ItemStack(Material.PLAYER_HEAD)
        val skullMeta = itemStack.itemMeta as SkullMeta
        skullMeta.displayName(Component.space())

        val rawUrl = "https://textures.minecraft.net/texture/${moodyType.texture}"
        val profile = Bukkit.createProfile(UUID.randomUUID())
        val textures = profile.textures
        textures.skin = URI(rawUrl).toURL()
        profile.setTextures(textures)

        skullMeta.playerProfile = profile
        itemStack.itemMeta = skullMeta

        moody.cachedItemTypes[moodyType] = itemStack
        return itemStack
    }

    override fun handle(
        moodyType: MoodyType?,
        handleType: HandleType,
    ) {
        when (handleType) {
            HandleType.EQUIP -> {
                currentHeadItem = player.inventory.helmet
                player.inventory.helmet = createItem(moodyType!!)
            }
            HandleType.DISARM -> {
                player.inventory.helmet = currentHeadItem
            }
        }
    }

}