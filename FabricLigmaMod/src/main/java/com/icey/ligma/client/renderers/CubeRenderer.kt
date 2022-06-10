package com.icey.ligma.client.renderers

import com.icey.ligma.LigmaMain
import com.icey.ligma.client.model.CubeEntityModel
import com.icey.ligma.entities.mobs.CubeEntity
import com.icey.ligma.registries.client.LigmaEntMdlLyrs
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.util.Identifier

class CubeRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<CubeEntity, CubeEntityModel>(context, CubeEntityModel(context.getPart(LigmaEntMdlLyrs.cube)), 0.5f) {

    override fun getTexture(entity: CubeEntity?): Identifier {
        return Identifier(LigmaMain.MODID, "textures/entity/cube.png")
    }

}