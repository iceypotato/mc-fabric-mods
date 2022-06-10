package com.icey.ligma.items

import com.icey.ligma.LigmaSndEvnts
import com.icey.ligma.entities.projectiles.CumProjectileEntity
import com.icey.ligma.registries.main.LigmaEnts
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.stat.Stats
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class MinhsHornyFace(settings: Settings) : Item(settings) {

    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        if (target!!.health <= 0) {
            attacker!!.world.playSound(null, attacker.blockPos, LigmaSndEvnts.minhBad, SoundCategory.AMBIENT, 1f, 1f)
        }
        return super.postHit(stack, target, attacker)
    }

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world!!.playSound(user, user!!.blockPos, LigmaSndEvnts.squirt, SoundCategory.AMBIENT, 1f, 1f)
        val itemStack = user.getStackInHand(hand) // creates a new ItemStack instance of the user's itemStack in-hand

        // user.getItemCooldownManager().set(this, 5);
        // Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.
        //
        // user.getItemCooldownManager().set(this, 5);
        // Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.

        if (!world.isClient) {
            val cumEntity = CumProjectileEntity(LigmaEnts.cumProjectile, user, world)
            cumEntity.setItem(itemStack)
            cumEntity.setVelocity(user, user.pitch, user.yaw, 0f, 1.5f, 1f)
            // snowballEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            // In 1.17,we will use setProperties instead of setVelocity.
            world.spawnEntity(cumEntity) // spawns entity
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this))
        if (!user.abilities.creativeMode) {
            itemStack.decrement(1) // decrements itemStack if user is not in creative mode
        }
        return TypedActionResult.success(itemStack, world.isClient)
    }

}