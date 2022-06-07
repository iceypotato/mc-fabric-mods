package com.icey.ligma.items

import com.icey.ligma.helloThereSoundEvent
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class EvensWeirdFace(settings: Settings) : Item(settings) {

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world!!.playSound(user, user!!.blockPos, helloThereSoundEvent, SoundCategory.MASTER, 1f, 1f)
        return super.use(world, user, hand)
    }

}