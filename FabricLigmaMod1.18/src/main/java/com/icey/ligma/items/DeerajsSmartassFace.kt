package com.icey.ligma.items

import com.icey.ligma.orgasmearrapeSoundEvent
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class DeerajsSmartassFace(settings: Settings) : Item(settings) {

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world!!.playSound(user, user!!.blockPos, orgasmearrapeSoundEvent, SoundCategory.MASTER, 0.5f, 1f)
        return super.use(world, user, hand)
    }

}