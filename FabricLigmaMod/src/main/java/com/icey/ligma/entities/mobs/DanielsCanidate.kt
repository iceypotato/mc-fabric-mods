package com.icey.ligma.entities.mobs

import com.icey.ligma.LigmaSndEvnts
import net.minecraft.entity.EntityData
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement
import net.minecraft.nbt.NbtString
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket
import net.minecraft.sound.SoundEvent
import net.minecraft.text.Text
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World

class DanielsCanidate(entityType: EntityType<out PathAwareEntity>, world: World) : PathAwareEntity(entityType, world) {

    override fun initialize(world: ServerWorldAccess?, difficulty: LocalDifficulty?, spawnReason: SpawnReason?, entityData: EntityData?, entityNbt: NbtCompound?): EntityData? {
        customName = Text.of("Daniel's Canidate")
        // boundingBox = Box(Vec3d(0.0, 0.0, 0.0), Vec3d(12.0, 12.0, 12.0))
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt)
    }

    override fun playHurtSound(source: DamageSource?) {
        playSound(LigmaSndEvnts.moan, 1f, 1f)
    }

    override fun getDeathSound(): SoundEvent {
        return LigmaSndEvnts.moan
    }

    override fun writeNbt(nbt: NbtCompound?): NbtCompound {
        nbt!!.put("CustomName", NbtString.of("Daniel's Canidate"))
        return super.writeNbt(nbt)
    }

    override fun saveNbt(nbt: NbtCompound?): Boolean {
        return super.saveNbt(nbt)
    }

    override fun onSpawnPacket(packet: EntitySpawnS2CPacket?) {
        super.onSpawnPacket(packet)
    }

}