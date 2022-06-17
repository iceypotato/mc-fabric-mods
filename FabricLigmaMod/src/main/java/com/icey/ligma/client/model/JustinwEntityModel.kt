package com.icey.ligma.client.model

import com.icey.ligma.entities.mobs.JustinwEntity
import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.util.math.MatrixStack
import org.spongepowered.include.com.google.common.collect.ImmutableList

class JustinwEntityModel(modelPart: ModelPart) : EntityModel<JustinwEntity>() {

    var base = modelPart.getChild(EntityModelPartNames.CUBE)

    companion object {

        fun getTexturedModelData() : TexturedModelData {
            var modelData = ModelData()
            var modelPartData = modelData.root
            modelPartData.addChild(EntityModelPartNames.CUBE, ModelPartBuilder.create().uv(0,0).cuboid(-180.5f, -172.5f, -180.5f, 361f, 361f, 361f, Dilation(-164.5f)), ModelTransform.pivot(0F, 0F, 0F))
            return TexturedModelData.of(modelData, 1444, 722)
        }

    }

    override fun render(matrices: MatrixStack?, vertices: VertexConsumer?, light: Int, overlay: Int, red: Float, green: Float, blue: Float, alpha: Float) {
        ImmutableList.of(base).forEach { modelRenderer ->
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        }
    }

    override fun setAngles(entity: JustinwEntity?, limbAngle: Float, limbDistance: Float, animationProgress: Float, headYaw: Float, headPitch: Float) {

    }
}