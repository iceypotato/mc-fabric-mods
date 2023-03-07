package com.icey.ligma.entities.projectiles

// import com.icey.ligma.packets.create
import com.icey.ligma.*
import com.icey.ligma.packets.EntitySpawnPacket
import com.icey.ligma.registries.client.LigmaPkts
import com.icey.ligma.registries.main.LigmaItems
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.network.Packet
import net.minecraft.sound.SoundCategory
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

class AhegaoProjectileEntity : ThrownItemEntity {

    constructor(entityType: EntityType<out ThrownItemEntity>, world: World) : super(entityType, world)

    constructor(entityType: EntityType<out ThrownItemEntity>, owner: LivingEntity?, world: World?) : super(entityType, owner, world)

    constructor(entityType: EntityType<out ThrownItemEntity>, world: World, x: Double, y: Double, z: Double) : super(entityType, x, y, z, world)

    override fun getDefaultItem(): Item {
        return LigmaItems.ahegaoface
    }

    override fun setItem(item: ItemStack?) {
        // if (!item!!.isOf(nishanthsInnocientFace)) {
        //     super.setItem(item)
        // }
        super.setItem(defaultItem.defaultStack)
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
            var dumerTmTsk = DumberTmTask(x, y, z, world)
            ServerTickEvents.END_SERVER_TICK.register(dumerTmTsk.tickthing)
            world!!.playSound(null, blockHitResult!!.blockPos, LigmaSndEvnts.senpai, SoundCategory.NEUTRAL, 1f, 1f)
        }
    }

    override fun onCollision(hitResult: HitResult?) {
        super.onCollision(hitResult)
        if (!this.world.isClient) {
            var dumerTmTsk = DumberTmTask(x, y, z, world)
            ServerTickEvents.END_SERVER_TICK.register(dumerTmTsk.tickthing)
            world!!.playSound(null, BlockPos(hitResult!!.pos), LigmaSndEvnts.senpai, SoundCategory.NEUTRAL, 1f, 1f)
            world.sendEntityStatus(this, 3.toByte())
            this.kill()
        }
    }

    override fun onEntityHit(entityHitResult: EntityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult)
    }

    override fun createSpawnPacket(): Packet<*>? {
        super.createSpawnPacket()
        return EntitySpawnPacket.create(this, LigmaPkts.packet)
    }

    override fun tick() {
        super.tick()
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
            world!!.playSound(null, x, y, z, LigmaSndEvnts.vineBoom, SoundCategory.NEUTRAL, 3f, 1f)

        }
        if (i <= 4*20) i++
    }

}