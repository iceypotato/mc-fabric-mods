package com.icey.ligma.client.renderers

import com.icey.ligma.LigmaMain
import com.icey.ligma.client.model.DanielsCanidateModel
import com.icey.ligma.entities.mobs.DanielsCanidateEntity
import com.icey.ligma.registries.client.LigmaEntMdlLyrs
import net.minecraft.client.render.entity.BipedEntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.util.Identifier

class DanielsCanidateRenderer(context: EntityRendererFactory.Context) :
    BipedEntityRenderer<DanielsCanidateEntity, DanielsCanidateModel>(context, DanielsCanidateModel(context.getPart(
        LigmaEntMdlLyrs.danielsCanidate)), 0.5f) {
    override fun getTexture(entity: DanielsCanidateEntity?): Identifier {
        return Identifier(LigmaMain.MODID, "textures/entity/danielscanidate/girl1.png")
    }
}