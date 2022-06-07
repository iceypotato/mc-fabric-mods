package com.icey.ligma

import com.icey.ligma.items.*
import com.icey.ligma.toolmaterials.tanayToolMaterial
import com.icey.ligma.items.tools.TanaysFuckingFace
import com.icey.ligma.items.tools.TheVillageE3
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// You have to register the items that you create instances of.

//var ligma = Item(Item.Settings().group(ItemGroup.MISC))
var ahegaoface = AhegaoFace(Item.Settings().group(ItemGroup.SEARCH).maxCount(64))
var cumItem = CumItem(Item.Settings().group(ItemGroup.SEARCH).maxCount(64))

var nickysBabyFace = NickysBabyFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var tanaysFuckingFace = TanaysFuckingFace(tanayToolMaterial, Int.MAX_VALUE, 100F, Item.Settings().group(ItemGroup.MISC))
var evensWeirdFace = EvensWeirdFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var deerajsSmartassFace = DeerajsSmartassFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var ethansDumbFace = EthansDumbFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var nishanthsInnocientFace = NishanthsInnocientFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var justinsSmugFace = JustinsSmugFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var minhsHornyFace = MinhsHornyFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var danielsFunnyFace = DanielsFunnyFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var adalsDeadFace = AdalsDeadFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
var theVillageE3 = TheVillageE3(Item.Settings().group(ItemGroup.MISC))

fun registerItems() {

    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "ahegaoface"), ahegaoface)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "cum"), cumItem)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "nickysbabyface"), nickysBabyFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "tanaysfuckingface"), tanaysFuckingFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "ethansdumbface"), ethansDumbFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "evensweirdface"), evensWeirdFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "deerajssmartassface"), deerajsSmartassFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "nishanthsinnocientface"), nishanthsInnocientFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "justinssmugface"), justinsSmugFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "minhshornyface"), minhsHornyFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "danielsfunnyface"), danielsFunnyFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "adalsdeadface"), adalsDeadFace)
    Registry.register(Registry.ITEM, Identifier(LigmaModMain.MODID, "thevillagee3"), theVillageE3)

    //todo initialize projectilie first
}