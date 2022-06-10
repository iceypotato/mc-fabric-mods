package com.icey.ligma.client.renderers

import com.icey.ligma.LigmaMain
import com.icey.ligma.client.model.JoeclinEntityModel
import com.icey.ligma.entities.mobs.JoeclinEntity
import com.icey.ligma.registries.client.LigmaEntMdlLyrs
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.util.Identifier

class JoeclinRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<JoeclinEntity, JoeclinEntityModel>(context,
    JoeclinEntityModel(context.getPart(LigmaEntMdlLyrs.joeclin)), 0.5f) {

    override fun getTexture(entity: JoeclinEntity?): Identifier {
        return Identifier(LigmaMain.MODID, "textures/entity/joeclin/joeclin.png")
    }

}