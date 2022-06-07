package com.icey.ligma.entities.mobs

import com.icey.ligma.moanSoundEvent
import net.minecraft.entity.EntityType
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket
import net.minecraft.sound.SoundEvent
import net.minecraft.util.math.Box
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World

class DanielsCanidate(entityType: EntityType<out PathAwareEntity>, world: World) : PathAwareEntity(entityType, world) {

    init {
        boundingBox = Box(Vec3d(0.0, 0.0, 0.0), Vec3d(12.0, 12.0, 12.0))
    }

    override fun playHurtSound(source: DamageSource?) {
        playSound(moanSoundEvent, 1f, 1f)
    }

    override fun getDeathSound(): SoundEvent {
        return moanSoundEvent
    }

    override fun saveNbt(nbt: NbtCompound?): Boolean {
        nbt!!.put("display", NbtCompound())
        return super.saveNbt(nbt)
    }

    override fun onSpawnPacket(packet: EntitySpawnS2CPacket?) {
        super.onSpawnPacket(packet)
    }

}