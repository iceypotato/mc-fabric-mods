package com.icey.ligma.entities.projectiles

import com.icey.ligma.LigmaEntities
import com.icey.ligma.client.PacketID
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

class CumProjectileEntity : ThrownItemEntity {

    constructor(entityType: EntityType<out ThrownItemEntity>, world: World) : super(entityType, world) {

    }

    constructor(owner: LivingEntity?, world: World?) : super(LigmaEntities.ahegaoProjectileEntityType, owner, world) {

    }

    constructor(world: World, x: Double, y: Double, z: Double) : super(LigmaEntities.ahegaoProjectileEntityType, x, y, z, world) {

    }

    override fun getDefaultItem(): Item {
        TODO("Not yet implemented")
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
        entityHitResult.entity.damage(DamageSource.GENERIC, 1f)
    }

    override fun createSpawnPacket(): Packet<*>? {
        super.createSpawnPacket()
        return EntitySpawnPacket.create(this, PacketID)
    }

}