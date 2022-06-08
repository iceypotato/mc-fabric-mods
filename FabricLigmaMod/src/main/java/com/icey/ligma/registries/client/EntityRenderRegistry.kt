package com.icey.ligma.registries.client

import com.icey.ligma.client.renderers.CubeRenderer
import com.icey.ligma.client.renderers.DanielsCanidateRenderer
import com.icey.ligma.client.renderers.JoeclinRenderer
import com.icey.ligma.registries.main.LigmaEnts
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.render.entity.FlyingItemEntityRenderer

fun registerEntityRenderers() {
    EntityRendererRegistry.register(LigmaEnts.ahegaoProjectile) { context -> FlyingItemEntityRenderer(context) }
    EntityRendererRegistry.register(LigmaEnts.cumProjectile) { context -> FlyingItemEntityRenderer(context) }
    EntityRendererRegistry.register(LigmaEnts.danielsCanidate) { context -> DanielsCanidateRenderer(context) }
    EntityRendererRegistry.register(LigmaEnts.joeclin) { context -> JoeclinRenderer(context) }
    EntityRendererRegistry.register(LigmaEnts.cube) { context -> CubeRenderer(context) }
}