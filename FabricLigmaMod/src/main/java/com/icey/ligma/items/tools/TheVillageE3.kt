package com.icey.ligma.items.tools

import com.icey.ligma.chugjugSoundEvent
import com.icey.ligma.toolmaterials.ligmaToolMaterial
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.PickaxeItem
import net.minecraft.sound.SoundCategory
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class TheVillageE3(settings: Settings) : PickaxeItem(ligmaToolMaterial, Int.MAX_VALUE, 100F, settings) {

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world!!.playSound(user, user!!.blockPos, chugjugSoundEvent, SoundCategory.MASTER, 1f, 1f)
        return super.use(world, user, hand)
    }

}