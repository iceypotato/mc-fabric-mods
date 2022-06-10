package com.icey.ligma.entities.mobs

import com.icey.ligma.LigmaSndEvnts
import com.icey.ligma.registries.client.LigmaEntMdlLyrs
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityData
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.Angerable
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket
import net.minecraft.sound.SoundEvent
import net.minecraft.text.Text
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World
import java.util.*

class DanielsCanidateEntity(entityType: EntityType<out PathAwareEntity>, world: World) : PathAwareEntity(entityType, world), Angerable {

    private var angerTime: Int = 10
    private var angryAt: UUID? = null
    companion object {
        fun createMobAttributes() : DefaultAttributeContainer.Builder {
            return createLivingAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10.0)

        }
    }

    override fun initialize(world: ServerWorldAccess?, difficulty: LocalDifficulty?, spawnReason: SpawnReason?, entityData: EntityData?, entityNbt: NbtCompound?): EntityData? {
        customName = Text.of("Daniel's Canidate")
        // boundingBox = Box(Vec3d(0.0, 0.0, 0.0), Vec3d(12.0, 12.0, 12.0))
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt)
    }

    override fun getHurtSound(source: DamageSource?): SoundEvent {
        return LigmaSndEvnts.moan
    }

    override fun getDeathSound(): SoundEvent {
        return LigmaSndEvnts.moan
    }

    override fun onAttacking(target: Entity?) {
        if (target!!.isPlayer) {
        }
        super.onAttacking(target)
    }

    override fun initGoals() {
        goalSelector.add(1, MeleeAttackGoal(this, 1.0, false))
        goalSelector.add(4, WanderAroundFarGoal(this, 1.0))
        goalSelector.add(5, LookAtEntityGoal(this, PlayerEntity::class.java, 8.0f))
        goalSelector.add(6, LookAroundGoal(this))
        targetSelector.add(1, RevengeGoal(this))
        targetSelector.add(2, ActiveTargetGoal(this, PlayerEntity::class.java, true))
    }

    override fun onSpawnPacket(packet: EntitySpawnS2CPacket?) {
        super.onSpawnPacket(packet)
    }

    override fun getAngerTime(): Int {
        return angerTime
    }

    override fun setAngerTime(angerTime: Int) {
        this.angerTime = angerTime
    }

    override fun getAngryAt(): UUID? {
        return uuid
    }

    override fun setAngryAt(angryAt: UUID?) {
        this.uuid = angryAt
    }

    override fun chooseRandomAngerTime() {

    }

}