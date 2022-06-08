package com.icey.ligma.items.tools

import com.icey.ligma.LigmaMain
import com.icey.ligma.LigmaSndEvnts
import com.icey.ligma.toolmaterials.LigmaToolMaterial
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.MiningToolItem
import net.minecraft.sound.SoundCategory
import net.minecraft.tag.TagKey
import net.minecraft.util.Hand
import net.minecraft.util.Identifier
import net.minecraft.util.TypedActionResult
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

class TheVillageE3(settings: Settings) : MiningToolItem(LigmaToolMaterial.attackDamage, LigmaToolMaterial.attackDamage, LigmaToolMaterial,
    TagKey.of(Registry.BLOCK_KEY, Identifier(LigmaMain.MODID, "thevillage")), settings) {

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world!!.playSound(user, user!!.blockPos, LigmaSndEvnts.chugjug, SoundCategory.MASTER, 1f, 1f)
        return super.use(world, user, hand)
    }

}