package com.icey.ligma

import com.icey.ligma.items.AhegaoFace
import com.icey.ligma.items.EthansDumbFace
import com.icey.ligma.items.NishanthsInnocientFace
import com.icey.ligma.toolmaterials.ligmaToolMaterial
import com.icey.ligma.tools.TanayTool
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// You have to register the items that you create instances of.

//var ligma = Item(Item.Settings().group(ItemGroup.MISC))
var tanayTool = TanayTool(ligmaToolMaterial, Int.MAX_VALUE, 100F, Item.Settings().group(ItemGroup.MISC))
var ethansDumbFace = EthansDumbFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var nishanthsInnocientFace = NishanthsInnocientFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var ahegaoface = AhegaoFace(Item.Settings().group(ItemGroup.SEARCH).maxCount(64))

fun registerItems() {

    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "tanay"), tanayTool)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "ethansdumbface"), ethansDumbFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "nishanthsinnocientface"), nishanthsInnocientFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "ahegaoface"), ahegaoface)
    //todo initialize projectilie first
}