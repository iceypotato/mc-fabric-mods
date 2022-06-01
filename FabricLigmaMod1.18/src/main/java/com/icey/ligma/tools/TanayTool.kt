package com.icey.ligma.tools

import com.icey.ligma.moanSoundEvent
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial
import net.minecraft.sound.SoundCategory
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class TanayTool(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) : PickaxeItem(material, attackDamage, attackSpeed, settings) {

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world!!.playSound(null, user!!.blockPos, moanSoundEvent, SoundCategory.MASTER, 1f, 1f)
        return super.use(world, user, hand)
    }

}