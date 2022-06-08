package com.icey.ligma.registries.client

import com.icey.ligma.LigmaMain
import com.icey.ligma.client.model.CubeEntityModel
import com.icey.ligma.client.model.DanielsCanidateModel
import com.icey.ligma.client.model.JoeclinEntityModel
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier

object LigmaEntMdlLyrs {
    val danielsCanidate = EntityModelLayer(Identifier(LigmaMain.MODID, "danielscanidate"), "danielscanidate")
    val joeclin = EntityModelLayer(Identifier(LigmaMain.MODID, "joeclinhead"), "joeclin")
    val cube = EntityModelLayer(Identifier(LigmaMain.MODID, "cube"), "cube")
}

fun registerEntityModelLayers() {
    EntityModelLayerRegistry.registerModelLayer(LigmaEntMdlLyrs.danielsCanidate) { DanielsCanidateModel.getTexturedModelData() }
    EntityModelLayerRegistry.registerModelLayer(LigmaEntMdlLyrs.joeclin) { JoeclinEntityModel.getTexturedModelData() }
    EntityModelLayerRegistry.registerModelLayer(LigmaEntMdlLyrs.cube) { CubeEntityModel.getTexturedModelData() }
}