package com.icey.ligma.client.model

import com.icey.ligma.entities.mobs.DanielsCanidate
import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.util.math.MatrixStack
import org.spongepowered.include.com.google.common.collect.ImmutableList

object TexturedModelDataHelper {

    fun getTexturedModelData() : TexturedModelData {
        var modelData = ModelData()
        var modelPartData = modelData.root
        modelPartData.addChild(EntityModelPartNames.CUBE, ModelPartBuilder.create().
        uv(0,0).cuboid(-6f, 12f, -6f, 12f, 12f, 12f), ModelTransform.pivot(0f, 0f, 0f))
        return TexturedModelData.of(modelData, 64, 64)
    }

}

class DanielsCanidateModel(modelPart: ModelPart) : EntityModel<DanielsCanidate>() {

    var base: ModelPart = modelPart.getChild(EntityModelPartNames.CUBE)

    override fun render(matrices: MatrixStack?, vertices: VertexConsumer?, light: Int, overlay: Int, red: Float, green: Float, blue: Float, alpha: Float) {
        ImmutableList.of(base).forEach {
            it.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        }
    }

    override fun setAngles(entity: DanielsCanidate?, limbAngle: Float, limbDistance: Float, animationProgress: Float, headYaw: Float, headPitch: Float) {
        // TODO("Not yet implemented")
    }

}