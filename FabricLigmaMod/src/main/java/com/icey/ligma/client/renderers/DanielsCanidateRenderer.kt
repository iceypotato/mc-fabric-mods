package com.icey.ligma.client.renderers

import com.icey.ligma.LigmaModMain
import com.icey.ligma.client.model.DanielsCanidateModel
import com.icey.ligma.client.modelBipedLayer
import com.icey.ligma.entities.mobs.DanielsCanidate
import net.minecraft.client.render.entity.BipedEntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.util.Identifier

class DanielsCanidateRenderer(context: EntityRendererFactory.Context) :
    BipedEntityRenderer<DanielsCanidate, DanielsCanidateModel>(context, DanielsCanidateModel(context.getPart(modelBipedLayer)), 0.5f) {
    override fun getTexture(entity: DanielsCanidate?): Identifier {
        return Identifier(LigmaModMain.MODID, "textures/entity/danielscanidate/rem.png")
    }
}