package com.icey.ligma.entities.renderers

import com.icey.ligma.LigmaModMain
import com.icey.ligma.client.model.DanielsCanidateModel
import com.icey.ligma.client.modelCubeLayer
import com.icey.ligma.entities.mobs.DanielsCanidate
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.util.Identifier

class DanielsCanidateRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<DanielsCanidate, DanielsCanidateModel>(context, DanielsCanidateModel(context.getPart(modelCubeLayer)), 0.5f) {
    override fun getTexture(entity: DanielsCanidate?): Identifier {
        return Identifier(LigmaModMain.MODID, "textures/entity/danielscanidate/danielscanidate.png")
    }
}