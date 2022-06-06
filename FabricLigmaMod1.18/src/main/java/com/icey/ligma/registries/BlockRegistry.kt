package com.icey.ligma.registries

import com.icey.ligma.LigmaModMain
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


val animeBlock = Block(FabricBlockSettings.of(Material.WOOL).strength(4.0f))

fun registerBlocks() {
    Registry.register(Registry.BLOCK, Identifier(LigmaModMain.MODID, "animeblock"), animeBlock)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "animeblock"), BlockItem(animeBlock, FabricItemSettings().group(ItemGroup.MISC)))
}