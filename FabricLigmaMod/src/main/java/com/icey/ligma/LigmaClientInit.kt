package com.icey.ligma

import com.icey.ligma.registries.client.registerEntityModelLayers
import com.icey.ligma.registries.client.registerPacketRecievers
import com.icey.ligma.registries.client.registerEntityRenderers
import net.fabricmc.api.ClientModInitializer

class LigmaClientInit : ClientModInitializer {

    override fun onInitializeClient() {
        registerEntityRenderers()
        registerEntityModelLayers()
        registerPacketRecievers()
    }

}