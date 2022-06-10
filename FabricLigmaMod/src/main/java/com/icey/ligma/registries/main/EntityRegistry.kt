package com.icey.ligma.registries.main

import com.icey.ligma.LigmaMain
import com.icey.ligma.entities.mobs.CubeEntity
import com.icey.ligma.entities.mobs.DanielsCanidateEntity
import com.icey.ligma.entities.mobs.JoeclinEntity
import com.icey.ligma.entities.mobs.JustinwEntity
import com.icey.ligma.entities.projectiles.AhegaoProjectileEntity
import com.icey.ligma.entities.projectiles.CumProjectileEntity
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/*
FabricEntityTypeBuilder.create(SpawnGroup.MISC,
    object : EntityType.EntityFactory<Thing> {
        override fun create(EntityType<Thing> type, World world) {
            return CoolProjectile(type, world)
        }
    }
*/

object LigmaEnts {
    lateinit var ahegaoProjectile: EntityType<AhegaoProjectileEntity>
    lateinit var danielsCanidate: EntityType<DanielsCanidateEntity>
    lateinit var cumProjectile: EntityType<CumProjectileEntity>
    lateinit var joeclin: EntityType<JoeclinEntity>
    lateinit var justinw: EntityType<JustinwEntity>
    lateinit var cube: EntityType<CubeEntity>
}

fun registerEntities() {
    LigmaEnts.ahegaoProjectile = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(LigmaMain.MODID, "ahegao_projectile"),
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type, world -> AhegaoProjectileEntity(type, world) }
            .dimensions(EntityDimensions.fixed(0.25f, 0.25f)) // dimensions in Minecraft units of the projectile
            .trackRangeBlocks(4)
            .trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
            .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
    )
    LigmaEnts.cumProjectile = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(LigmaMain.MODID, "cum"),
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type, world -> CumProjectileEntity(type, world) }
            .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
            .trackRangeBlocks(4)
            .trackedUpdateRate(10)
            .build()
    )
    LigmaEnts.danielsCanidate = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(LigmaMain.MODID, "danielscanidate"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE) { type, world -> DanielsCanidateEntity(type, world) }
            .dimensions(EntityDimensions.fixed(0.6f, 1.8f))
            .build()
    )
    FabricDefaultAttributeRegistry.register(LigmaEnts.danielsCanidate, DanielsCanidateEntity.createMobAttributes())

    LigmaEnts.joeclin = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(LigmaMain.MODID, "joeclin"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE) { type, world -> JoeclinEntity(type, world) }
            .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
            .build()
    )
    FabricDefaultAttributeRegistry.register(LigmaEnts.joeclin, JoeclinEntity.createMobAttributes())

    LigmaEnts.cube = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(LigmaMain.MODID, "cube"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE) { type, world -> CubeEntity(type, world) }
            .dimensions(EntityDimensions.fixed(2f, 2f))
            .build()
    )
    FabricDefaultAttributeRegistry.register(LigmaEnts.cube, CubeEntity.createMobAttributes())

    LigmaEnts.justinw = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(LigmaMain.MODID, "justinwangus"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE) { type, world -> JustinwEntity(type, world) }
            .dimensions(EntityDimensions.fixed(2f, 2f))
            .build()
    )
    FabricDefaultAttributeRegistry.register(LigmaEnts.justinw, JustinwEntity.createMobAttributes())

}