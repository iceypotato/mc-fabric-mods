package com.icey.ligma.entities.projectiles

import com.icey.ligma.LigmaEntities
import com.icey.ligma.client.PacketID
import com.icey.ligma.cumItem
import com.icey.ligma.packets.EntitySpawnPacket
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.network.Packet
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

class CumProjectileEntity : ThrownItemEntity {

    constructor(entityType: EntityType<out ThrownItemEntity>, world: World) : super(entityType, world)

    constructor(entityType: EntityType<out ThrownItemEntity>, owner: LivingEntity?, world: World?) : super(entityType, owner, world)

    constructor(entityType: EntityType<out ThrownItemEntity>, world: World, x: Double, y: Double, z: Double) : super(entityType, x, y, z, world)

    override fun getDefaultItem(): Item {
        return cumItem
    }

    override fun setItem(item: ItemStack?) {
        // if (!item!!.isOf(nishanthsInnocientFace)) {
        //     super.setItem(item)
        // }
        super.setItem(defaultItem.defaultStack)
    }

    override fun onCollision(hitResult: HitResult?) {
        super.onCollision(hitResult)
        if (!this.world.isClient) {
            world.sendEntityStatus(this, 3.toByte())
            this.kill()
        }
    }

    override fun onEntityHit(entityHitResult: EntityHitResult) { // called on entity hit.
        if (!this.world.isClient) {
            world.createExplosion(owner, entityHitResult.entity.x, entityHitResult.entity.y, entityHitResult.entity.z, 1f, Explosion.DestructionType.NONE)
        }
        // entityHitResult.entity.damage(DamageSource.GENERIC, 1f)
    }

    override fun createSpawnPacket(): Packet<*>? {
        super.createSpawnPacket()
        return EntitySpawnPacket.create(this, PacketID)
    }

}