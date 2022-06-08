package com.icey.ligma

import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object LigmaSndIds {

    var moan = Identifier(LigmaMain.MODID, "animemoan")
    var chugjug = Identifier(LigmaMain.MODID,"chugjug")
    var senpai = Identifier(LigmaMain.MODID, "senpai")
    var vineBoom = Identifier(LigmaMain.MODID, "vineboom")
    var bitchWtf = Identifier(LigmaMain.MODID, "bitchwtf")
    var hellothere = Identifier(LigmaMain.MODID, "hellothere")
    var squirt = Identifier(LigmaMain.MODID, "squirt")
    var sussyrance = Identifier(LigmaMain.MODID, "sussyrance")
    var orgasmearrape = Identifier(LigmaMain.MODID, "orgasmearrape")
    var manScreaming = Identifier(LigmaMain.MODID, "manscream")
    var minhBad = Identifier(LigmaMain.MODID, "minhbad")
    var takepantsoff = Identifier(LigmaMain.MODID, "takeyourpantsoff")

}
object LigmaSndEvnts {

    var moan = SoundEvent(LigmaSndIds.moan)
    var chugjug = SoundEvent(LigmaSndIds.chugjug)
    var senpai = SoundEvent(LigmaSndIds.senpai)
    var vineBoom = SoundEvent(LigmaSndIds.vineBoom)
    var bitchWtf = SoundEvent(LigmaSndIds.bitchWtf)
    var helloThere = SoundEvent(LigmaSndIds.hellothere)
    var squirt = SoundEvent(LigmaSndIds.squirt)
    var sussyrance = SoundEvent(LigmaSndIds.sussyrance)
    var orgasmearrape = SoundEvent(LigmaSndIds.orgasmearrape)
    var manScreaming = SoundEvent(LigmaSndIds.manScreaming)
    var minhBad = SoundEvent(LigmaSndIds.minhBad)
    var takepantsoff = SoundEvent(LigmaSndIds.takepantsoff)

}
fun registerSounds() {
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.moan, LigmaSndEvnts.moan)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.chugjug, LigmaSndEvnts.chugjug)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.senpai, LigmaSndEvnts.senpai)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.vineBoom, LigmaSndEvnts.vineBoom)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.bitchWtf, LigmaSndEvnts.bitchWtf)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.hellothere, LigmaSndEvnts.helloThere)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.squirt, LigmaSndEvnts.squirt)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.sussyrance, LigmaSndEvnts.sussyrance)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.orgasmearrape, LigmaSndEvnts.orgasmearrape)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.manScreaming, LigmaSndEvnts.manScreaming)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.minhBad, LigmaSndEvnts.minhBad)
    Registry.register(Registry.SOUND_EVENT, LigmaSndIds.takepantsoff, LigmaSndEvnts.takepantsoff)
}