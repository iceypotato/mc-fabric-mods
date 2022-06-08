package com.icey.ligma.registries.main

import com.icey.ligma.LigmaMain
import com.icey.ligma.items.*
import com.icey.ligma.items.tools.TanaysFuckingFace
import com.icey.ligma.items.tools.TheVillageE3
import com.icey.ligma.toolmaterials.TanayToolMaterial
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// You have to register the items that you create instances of.

//var ligma = Item(Item.Settings().group(ItemGroup.MISC))

object LigmaItms {
    var ahegaoface = AhegaoFace(Item.Settings().group(ItemGroup.SEARCH).maxCount(64))
    var cumItem = CumItem(Item.Settings().group(ItemGroup.SEARCH).maxCount(64))

    var nickysBabyFace = NickysBabyFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var tanaysFuckingFace = TanaysFuckingFace(TanayToolMaterial, Int.MAX_VALUE, 100F, Item.Settings().group(ItemGroup.MISC))
    var evensWeirdFace = EvensWeirdFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var deerajsSmartassFace = DeerajsSmartassFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var ethansDumbFace = EthansDumbFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var nishanthsInnocientFace = NishanthsInnocientFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var justinsSmugFace = JustinsSmugFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var minhsHornyFace = MinhsHornyFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var danielsFunnyFace = DanielsFunnyFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var adalsDeadFace = AdalsDeadFace(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var theVillageE3 = TheVillageE3(Item.Settings().group(ItemGroup.MISC))
}


fun registerItems() {

    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "ahegaoface"), LigmaItms.ahegaoface)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "cum"), LigmaItms.cumItem)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "nickysbabyface"), LigmaItms.nickysBabyFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "tanaysfuckingface"), LigmaItms.tanaysFuckingFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "ethansdumbface"), LigmaItms.ethansDumbFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "evensweirdface"), LigmaItms.evensWeirdFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "deerajssmartassface"), LigmaItms.deerajsSmartassFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "nishanthsinnocientface"), LigmaItms.nishanthsInnocientFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "justinssmugface"), LigmaItms.justinsSmugFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "minhshornyface"), LigmaItms.minhsHornyFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "danielsfunnyface"), LigmaItms.danielsFunnyFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "adalsdeadface"), LigmaItms.adalsDeadFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "thevillagee3"), LigmaItms.theVillageE3)

    //todo initialize projectile first
}