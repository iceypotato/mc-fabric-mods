package com.icey.ligma.items

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

class NotTheVillage(settings: Settings) : Item(settings) {

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world!!.createExplosion(null, user!!.x, user.y, user.z, 100f, Explosion.DestructionType.NONE)
        return super.use(world, user, hand)
    }

}