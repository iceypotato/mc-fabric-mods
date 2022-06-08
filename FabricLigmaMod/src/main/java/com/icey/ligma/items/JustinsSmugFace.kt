package com.icey.ligma.items

import com.icey.ligma.LigmaSndEvnts
import net.minecraft.block.BlockState
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.mob.SpiderEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class JustinsSmugFace(settings: Settings) : Item(settings) {

    override fun postMine(stack: ItemStack?, world: World?, state: BlockState?, pos: BlockPos?, miner: LivingEntity?): Boolean {
        val spooder: SpiderEntity = EntityType.get("minecraft:spider").get().create(world) as SpiderEntity
        spooder.updatePosition(pos!!.x.toDouble() + 0.5, pos.y.toDouble() + 0.5, pos.z.toDouble() + 0.5)
        world!!.spawnEntity(spooder)
        return super.postMine(stack, world, state, pos, miner)
    }

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world!!.playSound(null, user!!.blockPos, LigmaSndEvnts.bitchWtf, SoundCategory.MASTER, 1f, 1f)
        return super.use(world, user, hand)
    }

}