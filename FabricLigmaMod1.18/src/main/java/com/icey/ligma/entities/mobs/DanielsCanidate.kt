package com.icey.ligma.entities.mobs

import com.icey.ligma.moanSoundEvent
import net.minecraft.entity.EntityType
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.text.BaseText
import net.minecraft.text.Text
import net.minecraft.world.World

class DanielsCanidate(entityType: EntityType<out PathAwareEntity>, world: World) : PathAwareEntity(entityType, world) {

    init {
        this.customName = object : BaseText() {
            override fun copy(): BaseText {
                return this
            }
        }
    }

    override fun playHurtSound(source: DamageSource?) {
        playSound(moanSoundEvent, 1f, 1f)
    }

}