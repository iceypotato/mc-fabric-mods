package com.icey.ligma

import com.icey.ligma.entities.projectiles.AhegaoProjectileEntity
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
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

object LigmaEntities {
    lateinit var ahegaoProjectileEntityType: EntityType<AhegaoProjectileEntity>
}

fun registerEntities() {
    LigmaEntities.ahegaoProjectileEntityType = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(LigmaModMain.MODID, "ahegao_projectile"),
        FabricEntityTypeBuilder.create(SpawnGroup.MISC) { type, world -> AhegaoProjectileEntity(type, world) }
            .dimensions(EntityDimensions.fixed(0.25f, 0.25f)) // dimensions in Minecraft units of the projectile
            .trackRangeBlocks(4)
            .trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
            .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
    )
}