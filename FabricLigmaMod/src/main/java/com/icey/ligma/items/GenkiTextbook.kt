package com.icey.ligma.items

import com.icey.ligma.LigmaSndEvnts
import net.minecraft.block.AbstractBlock.Settings
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.text.LiteralText
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class GenkiTextbook(settings: Settings) : Item(settings) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        user.sendMessage(LiteralText("jouzued"), true)
        world.playSound(user, user.blockPos, LigmaSndEvnts.jouzu, SoundCategory.NEUTRAL, 1.0f, 1.0f)
        user.kill()
        return super.use(world, user, hand)
    }
}