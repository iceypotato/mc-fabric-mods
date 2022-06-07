package com.icey.ligma.items

import com.icey.ligma.LigmaModMain
import com.icey.ligma.entities.mobs.DanielsCanidate
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import javax.swing.text.html.parser.Entity

class DanielsFunnyFace(settings: Settings) : Item(settings) {

    override fun useOnEntity(stack: ItemStack?, user: PlayerEntity?, entity: LivingEntity?, hand: Hand?): ActionResult {
        entity!!.kill()
        var danielsCanidate: DanielsCanidate = EntityType.get("ligma:danielscanidate").get().create(user!!.world) as DanielsCanidate
        danielsCanidate.updatePosition(entity.x + 0.5, entity.y + 0.5, entity.z + 0.5)
        user.world.spawnEntity(danielsCanidate)
        return ActionResult.SUCCESS
    }

    // override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
    //     var danielsCanidate: DanielsCanidate = EntityType.get("ligma:danielscanidate").get().create(world) as DanielsCanidate
    //     danielsCanidate.updatePosition(user!!.x + 0.5, user.y + 0.5, user.z + 0.5)
    //     world!!.spawnEntity(danielsCanidate)
    //     return super.use(world, user, hand)
    // }

}