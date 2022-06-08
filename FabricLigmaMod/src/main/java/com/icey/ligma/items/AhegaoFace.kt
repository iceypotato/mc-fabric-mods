package com.icey.ligma.items

import com.icey.ligma.entities.projectiles.AhegaoProjectileEntity
import com.icey.ligma.registries.main.LigmaEnts
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.stat.Stats
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World


class AhegaoFace(settings: Settings?) : Item(settings) {

    override fun use(world: World, user: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack>? {
        val itemStack = user.getStackInHand(hand) // creates a new ItemStack instance of the user's itemStack in-hand
        // world.playSound(null, user.x, user.y, user.z, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 1f) // plays a globalSoundEvent
        /*
		user.getItemCooldownManager().set(this, 5);
		Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.
		*/
        if (!world.isClient) {
            val ahegaoProjectileEntity = AhegaoProjectileEntity(LigmaEnts.ahegaoProjectile, user, world)
            ahegaoProjectileEntity.setItem(itemStack)
            ahegaoProjectileEntity.setVelocity(user, user.pitch, user.yaw, 0.0f, 1.5f, 0f)
            /*
            snowballEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            In 1.17,we will use setProperties instead of setVelocity.
            */
            world.spawnEntity(ahegaoProjectileEntity) // spawns entity
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this))
        if (!user.abilities.creativeMode) {
            itemStack.decrement(1) // decrements itemStack if user is not in creative mode
        }
        return TypedActionResult.success(itemStack, world.isClient())
    }

}