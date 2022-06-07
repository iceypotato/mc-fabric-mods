package com.icey.ligma.items

import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.mob.CaveSpiderEntity
import net.minecraft.entity.mob.MobEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.stat.Stat
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import kotlin.math.cos
import kotlin.math.sin

class EthansDumbFace(settings: Settings?) : Item(settings) {

    override fun useOnEntity(stack: ItemStack?, user: PlayerEntity?, entity: LivingEntity?, hand: Hand?): ActionResult {
        entity!!.sleep(BlockPos(entity.x, entity.y, entity.z))
        user!!.sendMessage(Text.of("You gave it some weed, it is stoned as hell."), false)
        if (entity is MobEntity) entity.isAiDisabled = true
        return super.useOnEntity(stack, user, entity, hand)
    }

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        user!!.addStatusEffect(StatusEffectInstance(StatusEffects.NAUSEA, 60*20, 1, false, false))
        user.addStatusEffect(StatusEffectInstance(StatusEffects.LEVITATION, 3*20, 1, false, false))
        user.addStatusEffect(StatusEffectInstance(StatusEffects.HUNGER, 30*20, 1, false, false))
        user.addStatusEffect(StatusEffectInstance(StatusEffects.SLOWNESS, 30*20, 2, false, false))
        user.addStatusEffect(StatusEffectInstance(StatusEffects.ABSORPTION, 60*20, 4, false, false))
        var angle = 0.0
        while (angle <= 2 * Math.PI) {
            val zombie = EntityType.get("minecraft:zombie").get().create(user.getWorld())
            zombie!!.updatePosition(user.pos.x + cos(angle) * 8, user.pos.y, user.pos.z + sin(angle) * 8)
            user.getWorld().spawnEntity(zombie)
            angle += Math.PI/6.0
        }
        if (!user.abilities.creativeMode) {
            user.getStackInHand(hand).decrement(1)
        }
        return super.use(world, user, hand)
    }
}