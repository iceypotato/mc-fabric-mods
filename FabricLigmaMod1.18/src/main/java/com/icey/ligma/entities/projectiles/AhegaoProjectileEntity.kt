package com.icey.ligma.entities.projectiles

// import com.icey.ligma.packets.create
import com.icey.ligma.*
import com.icey.ligma.client.PacketID
import com.icey.ligma.items.NishanthsInnocientFace
import com.icey.ligma.packets.EntitySpawnPacket
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.network.Packet
import net.minecraft.particle.ItemStackParticleEffect
import net.minecraft.particle.ParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.MinecraftServer
import net.minecraft.sound.SoundCategory
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion
import java.util.*

private class DumbTmTask(var x: Double, var y: Double, var z: Double, var world: World?) : TimerTask() {
    var i = 0
    override fun run() {
        if (i >= 4) {
            world!!.createExplosion(null, x, y, z, 20F, Explosion.DestructionType.BREAK)
            world!!.playSound(null, x, y, z, vineBoomSoundEvent, SoundCategory.MASTER, 10f, 1f)
            this.cancel()
        }
        i++
    }
}

private class DumberTmTask(var x: Double, var y: Double, var z: Double, var world: World?) {

    var i = 0

    var tickthing = ServerTickEvents.EndTick {
        run()
    }

    fun run() {
        if (i == 4 * 20) {
            world!!.createExplosion(null, x, y, z, 20F, Explosion.DestructionType.BREAK)
            world!!.playSound(null, x, y, z, vineBoomSoundEvent, SoundCategory.MASTER, 3f, 1f)

        }
        if (i <= 4*20) i++
    }

}


class AhegaoProjectileEntity : ThrownItemEntity {

    constructor(entityType: EntityType<out ThrownItemEntity>, world: World) : super(entityType, world) {

    }

    constructor(owner: LivingEntity?, world: World?) : super(LigmaEntities.ahegaoProjectileEntityType, owner, world) {

    }

    constructor(world: World, x: Double, y: Double, z: Double) : super(LigmaEntities.ahegaoProjectileEntityType, x, y, z, world) {

    }

    override fun getDefaultItem(): Item {
        return ahegaoface
    }

    override fun setItem(item: ItemStack?) {
        if (!item!!.isOf(nishanthsInnocientFace)) {
            super.setItem(item)
        }
    }

    // @Environment(EnvType.CLIENT)
    // private fun getParticleParameters() : ParticleEffect {
    //     var itemStack = item
    //     return if (itemStack.isEmpty) ParticleTypes.ITEM_SNOWBALL else ItemStackParticleEffect(ParticleTypes.ITEM, itemStack)
    // }
    //
    // @Environment(EnvType.CLIENT)
    // override fun handleStatus(status: Byte) { // Also not entirely sure, but probably also has to do with the particles. This method (as well as the previous one) are optional, so if you don't understand, don't include this one.
    //     if (status.toInt() == 3) {
    //         val particleEffect = getParticleParameters()
    //         for (i in 0..7) {
    //             world.addParticle(particleEffect, this.x, this.y, this.z, 0.0, 0.0, 0.0)
    //         }
    //     }
    // }

    override fun onBlockHit(blockHitResult: BlockHitResult?) {
        super.onBlockHit(blockHitResult)
        if (!this.world.isClient) {
            // var timer = Timer()
            // var tmTsk = DumbTmTask(x, y, z, world)
            var dumerTmTsk = DumberTmTask(x, y, z, world)
            // world.createExplosion(null, this.x, this.y, this.z, 10F, Explosion.DestructionType.BREAK)
            ServerTickEvents.END_SERVER_TICK.register(dumerTmTsk.tickthing)
            // timer.scheduleAtFixedRate(tmTsk, 0, 1000)
            world!!.playSound(null, blockHitResult!!.blockPos, senpaiSoundEvent, SoundCategory.MASTER, 1f, 1f)
        }
    }

    override fun onCollision(hitResult: HitResult?) {
        super.onCollision(hitResult)
        if (!this.world.isClient) {
            world.sendEntityStatus(this, 3.toByte())
            this.kill()
        }
    }

    override fun onEntityHit(entityHitResult: EntityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult)
    }

    override fun createSpawnPacket(): Packet<*>? {
        super.createSpawnPacket()
        return EntitySpawnPacket.create(this, PacketID)
    }
}