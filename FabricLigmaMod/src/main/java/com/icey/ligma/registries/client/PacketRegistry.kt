package com.icey.ligma.registries.client

import com.icey.ligma.LigmaMain
import com.icey.ligma.packets.PacketBufUtil
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.minecraft.client.MinecraftClient
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.util.Identifier
import net.minecraft.util.math.Vec3d
import net.minecraft.util.registry.Registry
import java.util.*

object LigmaPkts {
    val packet = Identifier(LigmaMain.MODID, "spawn_packet")
}


fun registerPacketRecievers() {
    ClientPlayNetworking.registerGlobalReceiver(LigmaPkts.packet) { client, handler, packetByteBuf, responseSender ->
        val et: EntityType<*> = Registry.ENTITY_TYPE.get(packetByteBuf.readVarInt())
        val uuid: UUID = packetByteBuf.readUuid()
        val entityId: Int = packetByteBuf.readVarInt()
        val pos: Vec3d = PacketBufUtil.readVec3d(packetByteBuf)
        val pitch: Float = PacketBufUtil.readAngle(packetByteBuf)
        val yaw: Float = PacketBufUtil.readAngle(packetByteBuf)
        client.execute {
            if (MinecraftClient.getInstance().world == null) {
                throw java.lang.IllegalStateException("Tried to spawn entity in a null world!")
            }
            val e: Entity = et.create(MinecraftClient.getInstance().world)
                ?: throw java.lang.IllegalStateException(
                    "Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(
                        et
                    ) + "\"!"
                )
            e.updateTrackedPosition(pos.x, pos.y, pos.z)
            e.setPos(pos.x, pos.y, pos.z)
            e.pitch = pitch
            e.yaw = yaw
            e.id = entityId
            e.uuid = uuid
            MinecraftClient.getInstance().world!!.addEntity(entityId, e)
        }
    }
}