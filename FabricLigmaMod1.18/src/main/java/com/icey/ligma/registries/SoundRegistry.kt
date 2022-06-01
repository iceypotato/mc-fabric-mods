package com.icey.ligma

import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

var moanSoundIdentifier = Identifier("ligma:anime")
var moanSoundEvent = SoundEvent(moanSoundIdentifier)

var chugjugSoundIdentifier = Identifier("ligma:chugjug")
var chugjugSoundEvent = SoundEvent(chugjugSoundIdentifier)

var senpaiSoundIdentifier = Identifier("ligma:senpai")
var senpaiSoundEvent = SoundEvent(senpaiSoundIdentifier)

var vineBoomSoundIdentifier = Identifier(LigmaModMain.MODID, "vineboom")
var vineBoomSoundEvent = SoundEvent(vineBoomSoundIdentifier)

fun registerSounds() {
    Registry.register(Registry.SOUND_EVENT, moanSoundIdentifier, moanSoundEvent)
    Registry.register(Registry.SOUND_EVENT, chugjugSoundIdentifier, chugjugSoundEvent)
    Registry.register(Registry.SOUND_EVENT, senpaiSoundIdentifier, senpaiSoundEvent)
    Registry.register(Registry.SOUND_EVENT, vineBoomSoundIdentifier, vineBoomSoundEvent)
}