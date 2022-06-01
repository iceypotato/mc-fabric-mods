package com.icey.ligma

import com.icey.ligma.tools.packets.PacketBufUtil
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.fabricmc.fabric.impl.networking.ClientSidePacketRegistryImpl
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.util.Identifier
import net.minecraft.util.math.Vec3d
import net.minecraft.util.registry.Registry
import java.util.*

val PacketID = Identifier(LigmaModMain.MODID, "spawn_packet")

class LigmaClientModInitializer : ClientModInitializer {

    override fun onInitializeClient() {
        EntityRendererRegistry.register(LigmaEntities.ahegaoProjectileEntityType) { context -> FlyingItemEntityRenderer(context) }
        recieveEntityPacket()
    }

    private fun recieveEntityPacket() {
        ClientSidePacketRegistryImpl.INSTANCE.register(PacketID) { ctx, byteBuf ->
            val et: EntityType<*> = Registry.ENTITY_TYPE.get(byteBuf.readVarInt())
            val uuid: UUID = byteBuf.readUuid()
            val entityId: Int = byteBuf.readVarInt()
            val pos: Vec3d = PacketBufUtil.readVec3d(byteBuf)
            val pitch: Float = PacketBufUtil.readAngle(byteBuf)
            val yaw: Float = PacketBufUtil.readAngle(byteBuf)
            ctx.taskQueue.execute {
                if (MinecraftClient.getInstance().world == null) {
                    throw java.lang.IllegalStateException("Tried to spawn entity in a null world!")
                }
                val e: Entity = et.create(MinecraftClient.getInstance().world)
                    ?: throw java.lang.IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!")
                e.updateTrackedPosition(pos)
                e.setPos(pos.x, pos.y, pos.z)
                e.pitch = pitch
                e.yaw = yaw
                e.id = entityId
                e.uuid = uuid
                MinecraftClient.getInstance().world!!.addEntity(entityId, e)
            }
        }
    }
}