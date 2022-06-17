package com.icey.ligma.client.renderers

import com.icey.ligma.LigmaMain
import com.icey.ligma.client.model.JustinwEntityModel
import com.icey.ligma.entities.mobs.JustinwEntity
import com.icey.ligma.registries.client.LigmaEntMdlLyrs
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory.Context
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.util.Identifier

class JustinwRenderer(context: Context) : MobEntityRenderer<JustinwEntity, JustinwEntityModel>(context, JustinwEntityModel(context.getPart(LigmaEntMdlLyrs.justinw)), 0.5f) {

    override fun getTexture(entity: JustinwEntity?): Identifier {
        return Identifier(LigmaMain.MODID, "textures/entity/justinw/justinwangus.png")
    }

}