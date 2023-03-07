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

object LigmaItems {
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
    var notTheVillage = NotTheVillage(Item.Settings().group(ItemGroup.MISC).maxCount(1))
    var genki2 = GenkiTextbook(Item.Settings().group(ItemGroup.MISC).maxCount(1))
}


fun registerItems() {

    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "ahegaoface"), LigmaItems.ahegaoface)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "cum"), LigmaItems.cumItem)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "nickysbabyface"), LigmaItems.nickysBabyFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "tanaysfuckingface"), LigmaItems.tanaysFuckingFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "ethansdumbface"), LigmaItems.ethansDumbFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "evensweirdface"), LigmaItems.evensWeirdFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "deerajssmartassface"), LigmaItems.deerajsSmartassFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "nishanthsinnocientface"), LigmaItems.nishanthsInnocientFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "justinssmugface"), LigmaItems.justinsSmugFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "minhshornyface"), LigmaItems.minhsHornyFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "danielsfunnyface"), LigmaItems.danielsFunnyFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "adalsdeadface"), LigmaItems.adalsDeadFace)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "thevillagee3"), LigmaItems.theVillageE3)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "notthevillage"), LigmaItems.notTheVillage)
    Registry.register(Registry.ITEM, Identifier(LigmaMain.MODID, "genki2"), LigmaItems.genki2)

    //todo initialize projectile first
}