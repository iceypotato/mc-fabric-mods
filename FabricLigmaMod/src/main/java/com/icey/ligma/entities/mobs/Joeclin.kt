package com.icey.ligma.entities.mobs

import net.minecraft.entity.EntityType
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.sound.SoundEvent
import net.minecraft.world.World

class Joeclin(entityType: EntityType<out PathAwareEntity>?, world: World) : PathAwareEntity(entityType, world) {

    override fun getHurtSound(source: DamageSource?): SoundEvent? {
        return super.getHurtSound(source)
    }

}