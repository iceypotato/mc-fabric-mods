package com.icey.ligma.entities.mobs

import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.sound.SoundEvent

import net.minecraft.world.World

class JustinwEntity(entityType: EntityType<out PathAwareEntity>, world: World) : PathAwareEntity(entityType, world) {

    companion object {

        fun createMobAttributes() : DefaultAttributeContainer.Builder {
            return createLivingAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.000001)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 100.0)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 3.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0)
        }

    }

    override fun initGoals() {
        super.initGoals()
    }

    override fun getHurtSound(source: DamageSource?): SoundEvent? {
        return super.getHurtSound(source)
    }

    override fun getDeathSound(): SoundEvent? {
        return super.getDeathSound()
    }

}