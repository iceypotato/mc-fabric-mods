package com.icey.ligma.entities.mobs

import net.minecraft.entity.EntityType
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.world.World

class Cube(entityType: EntityType<out PathAwareEntity>, world: World) : PathAwareEntity(entityType, world) {

}