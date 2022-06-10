package com.icey.ligma.client.model

import com.icey.ligma.entities.mobs.JoeclinEntity
import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.util.math.MatrixStack
import org.spongepowered.include.com.google.common.collect.ImmutableList

class JoeclinEntityModel(modelPart: ModelPart) : EntityModel<JoeclinEntity>() {

    var base = modelPart.getChild(EntityModelPartNames.CUBE)

    companion object {

        fun getTexturedModelData() : TexturedModelData {
            var modelData = ModelData()
            var modelPartData = modelData.root
            modelPartData.addChild(EntityModelPartNames.CUBE, ModelPartBuilder.create().uv(0,0).cuboid(-128f, -110f, -128f, 256f, 256f, 256f, Dilation(-122f)), ModelTransform.pivot(0F, 0F, 0F))
            return TexturedModelData.of(modelData, 1024, 1024)
        }

    }

    override fun render(matrices: MatrixStack?, vertices: VertexConsumer?, light: Int, overlay: Int, red: Float, green: Float, blue: Float, alpha: Float) {
        ImmutableList.of(base).forEach { modelRenderer ->
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        }
    }

    override fun setAngles(entity: JoeclinEntity?, limbAngle: Float, limbDistance: Float, animationProgress: Float, headYaw: Float, headPitch: Float) {

    }
}