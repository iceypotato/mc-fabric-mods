package com.icey.ligma

import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

var moanSoundIdentifier = Identifier(LigmaModMain.MODID, "animemoan")
var moanSoundEvent = SoundEvent(moanSoundIdentifier)

var chugjugSoundIdentifier = Identifier(LigmaModMain.MODID,"chugjug")
var chugjugSoundEvent = SoundEvent(chugjugSoundIdentifier)

var senpaiSoundIdentifier = Identifier(LigmaModMain.MODID, "senpai")
var senpaiSoundEvent = SoundEvent(senpaiSoundIdentifier)

var vineBoomSoundIdentifier = Identifier(LigmaModMain.MODID, "vineboom")
var vineBoomSoundEvent = SoundEvent(vineBoomSoundIdentifier)

var bitchWtfSoundIdentifier = Identifier(LigmaModMain.MODID, "bitchwtf")
var bitchWtfSoundEvent = SoundEvent(bitchWtfSoundIdentifier)

var hellothereSoundIdentifier = Identifier(LigmaModMain.MODID, "hellothere")
var helloThereSoundEvent = SoundEvent(hellothereSoundIdentifier)

var squirtSoundIdentifier = Identifier(LigmaModMain.MODID, "squirt")
var squirtSoundEvent = SoundEvent(squirtSoundIdentifier)

var sussyranceSoundIdentifier = Identifier(LigmaModMain.MODID, "sussyrance")
var sussyranceSoundEvent = SoundEvent(sussyranceSoundIdentifier)

var orgasmearrapeSoundIdentifier = Identifier(LigmaModMain.MODID, "orgasmearrape")
var orgasmearrapeSoundEvent = SoundEvent(orgasmearrapeSoundIdentifier)
fun registerSounds() {
    Registry.register(Registry.SOUND_EVENT, moanSoundIdentifier, moanSoundEvent)
    Registry.register(Registry.SOUND_EVENT, chugjugSoundIdentifier, chugjugSoundEvent)
    Registry.register(Registry.SOUND_EVENT, senpaiSoundIdentifier, senpaiSoundEvent)
    Registry.register(Registry.SOUND_EVENT, vineBoomSoundIdentifier, vineBoomSoundEvent)
    Registry.register(Registry.SOUND_EVENT, bitchWtfSoundIdentifier, bitchWtfSoundEvent)
    Registry.register(Registry.SOUND_EVENT, hellothereSoundIdentifier, helloThereSoundEvent)
    Registry.register(Registry.SOUND_EVENT, squirtSoundIdentifier, squirtSoundEvent)
    Registry.register(Registry.SOUND_EVENT, sussyranceSoundIdentifier, sussyranceSoundEvent)
    Registry.register(Registry.SOUND_EVENT, orgasmearrapeSoundIdentifier, orgasmearrapeSoundEvent)
}