package com.icey.ligma.client

import com.icey.ligma.LigmaEntities
import com.icey.ligma.LigmaEntities.danielsCanidate
import com.icey.ligma.LigmaModMain
import com.icey.ligma.client.model.DanielsCanidateModel
import com.icey.ligma.client.renderers.DanielsCanidateRenderer
import com.icey.ligma.packets.PacketBufUtil
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.fabricmc.fabric.impl.networking.ClientSidePacketRegistryImpl
import net.minecraft.client.MinecraftClient
import net.minecraft.client.model.Dilation
import net.minecraft.client.model.TexturedModelData
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.model.PlayerEntityModel
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.util.Identifier
import net.minecraft.util.math.Vec3d
import net.minecraft.util.registry.Registry
import java.util.*
import kotlin.coroutines.coroutineContext

val PacketID = Identifier(LigmaModMain.MODID, "spawn_packet")
val modelBipedLayer = EntityModelLayer(Identifier(LigmaModMain.MODID, "danielscanidate"), "main")

class LigmaClientModInitializer : ClientModInitializer {

    override fun onInitializeClient() {
        EntityRendererRegistry.register(LigmaEntities.ahegaoProjectileEntityType) { context -> FlyingItemEntityRenderer(context) }
        EntityRendererRegistry.register(LigmaEntities.cumProjectileEntityType) { context -> FlyingItemEntityRenderer(context) }
        EntityRendererRegistry.register(danielsCanidate) { context -> DanielsCanidateRenderer(context) }

        EntityModelLayerRegistry.registerModelLayer(modelBipedLayer) { DanielsCanidateModel.getTexturedModelData() }
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