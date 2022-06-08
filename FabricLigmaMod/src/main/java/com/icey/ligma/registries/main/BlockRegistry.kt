package com.icey.ligma.registries.main

import com.icey.ligma.LigmaMain
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


object LigmaBlocks {
    val anime = Block(FabricBlockSettings.of(Material.WOOL).strength(4.0f))
}

fun registerBlocks() {
    Registry.register(Registry.BLOCK, Identifier(LigmaMain.MODID, "animeblock"), LigmaBlocks.anime)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "animeblock"), BlockItem(LigmaBlocks.anime, FabricItemSettings().group(ItemGroup.MISC)))
}