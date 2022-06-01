package com.icey.ligma.items

import com.icey.ligma.entities.projectiles.AhegaoProjectileEntity
import net.minecraft.block.BlockState
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.mob.CaveSpiderEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.StackReference
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.screen.slot.Slot
import net.minecraft.stat.Stats
import net.minecraft.util.ClickType
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class NishanthsInnocientFace(settings: Settings?) : Item(settings) {

    override fun onClicked(
        stack: ItemStack?,
        otherStack: ItemStack?,
        slot: Slot?,
        clickType: ClickType?,
        player: PlayerEntity?,
        cursorStackReference: StackReference?
    ): Boolean {
        return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference)
    }

    override fun postMine(stack: ItemStack, world: World, state: BlockState, pos: BlockPos, miner: LivingEntity): Boolean {
        val spooder: CaveSpiderEntity = EntityType.get("minecraft:cave_spider").get().create(world) as CaveSpiderEntity
        spooder.updatePosition(pos.x.toDouble() + 0.5, pos.y.toDouble() + 0.5, pos.z.toDouble() + 0.5)
        world.spawnEntity(spooder)
        return false;
    }

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {

        val itemStack = user!!.getStackInHand(hand) // creates a new ItemStack instance of the user's itemStack in-hand

		// user.getItemCooldownManager().set(this, 5);
		// Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.
        //
		// user.getItemCooldownManager().set(this, 5);
		// Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.

        if (!world!!.isClient) {
            val ahegaoEntity = AhegaoProjectileEntity(user, world)
            ahegaoEntity.setItem(itemStack)
            ahegaoEntity.setVelocity(user, user.pitch, user.yaw, 0f, 1.5f, 1f)
            // snowballEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            // In 1.17,we will use setProperties instead of setVelocity.
            world.spawnEntity(ahegaoEntity) // spawns entity
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this))
        if (!user.abilities.creativeMode) {
            itemStack.decrement(1) // decrements itemStack if user is not in creative mode
        }
        return TypedActionResult.success(itemStack, world.isClient)
    }

}