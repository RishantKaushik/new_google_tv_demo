package com.example.myapplication

import com.connectsdk.discovery.DiscoveryFilter
import com.connectsdk.service.DeviceService
import com.connectsdk.service.config.ServiceConfig
import com.connectsdk.service.config.ServiceDescription


/* loaded from: classes3.dex */
class NewAndroidService(serviceDescription: ServiceDescription?, serviceConfig: ServiceConfig?) :
    DeviceService(serviceDescription, serviceConfig) {
    // com.connectsdk.service.DeviceService
    override fun isConnectable(): Boolean {
        return true
    }

    // com.connectsdk.service.DeviceService
    override fun isConnected(): Boolean {
        return connected
    }

    // com.connectsdk.service.DeviceService
    override fun connect() {
        connected = true
        reportConnected(true)
    }

    // com.connectsdk.service.DeviceService
    override fun disconnect() {
        connected = false
    }

    companion object {
        const val ID = "AndroidTV2"
        fun discoveryFilter(): DiscoveryFilter {
            return DiscoveryFilter(ID, "_androidtvremote2._tcp.local.")
        }
    }
}