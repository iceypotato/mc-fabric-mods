package com.icey.ligma.client.model

import com.icey.ligma.entities.mobs.DanielsCanidateEntity
import net.minecraft.client.model.*
import net.minecraft.client.render.entity.model.PlayerEntityModel

class DanielsCanidateModel(modelPart: ModelPart) : PlayerEntityModel<DanielsCanidateEntity>(modelPart, true) {

    companion object {

        fun getTexturedModelData() : TexturedModelData {
            var dilation = Dilation(0f)
            return TexturedModelData.of(getTexturedModelData(dilation, true), 64, 64)
        }

    }

}