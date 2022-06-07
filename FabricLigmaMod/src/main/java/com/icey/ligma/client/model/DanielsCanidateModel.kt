package com.icey.ligma.client.model

import com.icey.ligma.entities.mobs.DanielsCanidate
import net.minecraft.client.model.*
import net.minecraft.client.render.entity.model.BipedEntityModel
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.render.entity.model.PlayerEntityModel

class DanielsCanidateModel(modelPart: ModelPart) : PlayerEntityModel<DanielsCanidate>(modelPart, true) {

    companion object {

        fun getTexturedModelData() : TexturedModelData {
            var dilation = Dilation(0f)
            return TexturedModelData.of(getTexturedModelData(dilation, true), 64, 64)
        }

    }

}