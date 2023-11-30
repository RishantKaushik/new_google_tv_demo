package com.example.myapplication

import com.connectsdk.device.ConnectableDevice
import com.connectsdk.service.FireTVService
import com.connectsdk.service.config.ServiceDescription
import java.util.Arrays
import java.util.Locale


/* loaded from: classes2.dex */
object TVType {
/*
    fun isFireTV(connectableDevice: ConnectableDevice?): Boolean {
        return if (connectableDevice != null) {
            getTVType(connectableDevice) == FireTVService.ID
        } else false
    }

    fun isLGTV(connectableDevice: ConnectableDevice?): Boolean {
        return if (connectableDevice != null) {
           // getTVType(connectableDevice) == "LG"
        } else false
    }
*/

    fun checkService(connectableDevice: ConnectableDevice?, str: String): Boolean {
        val str2: String
        return if (connectableDevice == null) {
            false
        } else try {
            var arrayList: MutableList<*> = ArrayList<Any?>()
            if (str.contains(",")) {
                arrayList = Arrays.asList(*str.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray())
            } else {
                arrayList.add(str as Nothing)
            }
            var str3 = ""
            val lowerCase =
                if (connectableDevice.connectedServiceNames != null) connectableDevice.connectedServiceNames.lowercase(
                    Locale.getDefault()
                ) else ""
            val serviceDescription: ServiceDescription? = connectableDevice.serviceDescription
            if (serviceDescription != null) {
                str3 = serviceDescription.getManufacturer()
                str2 = serviceDescription.getModelName()
            } else {
                str2 = ""
            }
            try {
                val serviceId = connectableDevice.serviceId
                for (i in arrayList.indices) {
                    if (lowerCase.contains((arrayList[i] as String).lowercase(Locale.getDefault())) || str3.lowercase(
                            Locale.getDefault()
                        ).contains(
                            (arrayList[i] as CharSequence?)!!
                        ) || str2.lowercase(Locale.getDefault())
                            .contains((arrayList[i] as CharSequence?)!!) || serviceId.lowercase(
                            Locale.getDefault()
                        ).contains(
                            (arrayList[i] as CharSequence?)!!
                        )
                    ) {
                        return true
                    }
                }
            } catch (e2: Exception) {
                e2.printStackTrace()
            }
            false
        } catch (e3: Exception) {
            e3.printStackTrace()
            false
        }
    }

    fun checkName(connectableDevice: ConnectableDevice?, str: String): Boolean {
        if (connectableDevice == null) {
            return false
        }
        var arrayList: MutableList<*> = ArrayList<Any?>()
        if (str.contains(",")) {
            arrayList = Arrays.asList(*str.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray())
        } else {
            arrayList.add(str as Nothing)
        }
        val lowerCase =
            if (connectableDevice.connectedServiceNames != null) connectableDevice.friendlyName.lowercase(
                Locale.getDefault()
            ) else ""
        for (i in arrayList.indices) {
            if (lowerCase.contains((arrayList[i] as String).lowercase(Locale.getDefault()))) {
                return true
            }
        }
        return false
    }

    val isChromecastTV: Boolean
        get() {
            var connectedServiceNames: String
            val connectableDevice: ConnectableDevice? =
                TVConnectController.instance?.connectableDevice
            connectedServiceNames= connectableDevice?.connectedServiceNames.toString()
            return if (connectableDevice == null || connectableDevice.connectedServiceNames.also {
                    connectedServiceNames = it
                } == null) {
                false
            } else connectedServiceNames.toLowerCase().contains("chromecast")

        }
    val isAndroidTV: Boolean
        get() {
            var connectedServiceNames: String

            val connectableDeviceAndroidTV: ConnectableDevice? =
                TVConnectController.instance?.connectableDeviceAndroidTV

            connectedServiceNames= connectableDeviceAndroidTV?.connectedServiceNames.toString()
            return if (connectableDeviceAndroidTV == null || connectableDeviceAndroidTV.connectedServiceNames.also {
                    connectedServiceNames = it
                } == null) {
                false
            } else connectedServiceNames.lowercase(Locale.getDefault())
                .contains("androidtv") || connectedServiceNames.lowercase(
                Locale.getDefault()
            ).contains("androidtv2")
        }
    val isNewAndroidTV: Boolean
        get() {
            var connectedServiceNames: String
            val connectableDeviceAndroidTV: ConnectableDevice? =
                TVConnectController.instance?.connectableDeviceAndroidTV

            connectedServiceNames= connectableDeviceAndroidTV?.connectedServiceNames.toString()
            return if (connectableDeviceAndroidTV == null || connectableDeviceAndroidTV.connectedServiceNames.also {
                    connectedServiceNames = it
                } == null) {
                false
            } else connectedServiceNames.lowercase(Locale.getDefault()).contains("androidtv2")
        }

    /*fun isRokuTV(connectableDevice: ConnectableDevice?): Boolean {
        return if (connectableDevice != null) {
            getTVTypeConnect(connectableDevice) == "RokuTV"
        } else false
    }

    fun isSamsungTV(connectableDevice: ConnectableDevice?): Boolean {
        return if (connectableDevice != null) {
            getTVType(connectableDevice) == "SamsungTV"
        } else false
    }

    fun isSonyTV(connectableDevice: ConnectableDevice?): Boolean {
        return getTVType(connectableDevice) == "SonyTV"
    }
*/
/*    fun getTVTypeConnect(connectableDevice: ConnectableDevice?): String {
        return if (checkService(connectableDevice, "roku")) "RokuTV" else if (checkService(
                connectableDevice,
                "lg,webos,web os"
            )
        ) "LG" else if (checkService(
                connectableDevice,
                "samsung,[tv]"
            )
        ) "SamsungTV" else if (checkService(
                connectableDevice,
                "sony,bravia"
            )
        ) "SonyTV" else if (checkService(
                connectableDevice,
                "AndroidTV,AndroidTV2"
            )
        ) AndroidService.ID else if (checkService(
                connectableDevice,
                "chromecast"
            )
        ) "ChromeCastTV" else if (checkService(
                connectableDevice,
                "tcl"
            )
        ) "TclTV" else if (checkService(
                connectableDevice,
                "firetv,fire tv"
            )
        ) FireTVService.ID else if (checkName(
                connectableDevice,
                "roku"
            )
        ) "RokuTV" else if (checkName(
                connectableDevice,
                "lg,webos,web os"
            )
        ) "LG" else if (checkName(
                connectableDevice,
                "samsung,[tv]"
            )
        ) "SamsungTV" else if (checkName(
                connectableDevice,
                "sony,bravia"
            )
        ) "SonyTV" else if (checkName(
                connectableDevice,
                "AndroidTV,AndroidTV2"
            )
        ) AndroidService.ID else if (checkName(
                connectableDevice,
                "chromecast"
            )
        ) "ChromeCastTV" else if (checkName(connectableDevice, "tcl")) "TclTV" else if (checkName(
                connectableDevice,
                "firetv,fire tv"
            )
        ) FireTVService.ID else "Other"
    }

    fun getTVType(connectableDevice: ConnectableDevice?): String {
        var connectableDevice2: ConnectableDevice? =
            TVConnectController.instance?.connectableDevice
        if (connectableDevice2 == null) {
            connectableDevice2 = TVConnectController.instance?.connectableDeviceClick!!
        }
        return if (checkService(connectableDevice2, "roku")) "RokuTV" else if (checkService(
                connectableDevice2,
                "lg,webos,web os"
            )
        ) "LG" else if (checkService(
                connectableDevice2,
                "samsung,[tv]"
            )
        ) "SamsungTV" else if (checkService(
                connectableDevice2,
                "sony,bravia"
            )
        ) "SonyTV" else if (checkService(
                connectableDevice2,
                "AndroidTV,AndroidTV2"
            )
        ) AndroidService.ID else if (checkService(
                connectableDevice2,
                "chromecast"
            )
        ) "ChromeCastTV" else if (checkService(
                connectableDevice2,
                "tcl"
            )
        ) "TclTV" else if (checkService(
                connectableDevice2,
                "firetv,fire tv"
            )
        ) FireTVService.ID else if (checkName(
                connectableDevice2,
                "roku"
            )
        ) "RokuTV" else if (checkName(
                connectableDevice2,
                "lg,webos,web os"
            )
        ) "LG" else if (checkName(
                connectableDevice2,
                "samsung,[tv]"
            )
        ) "SamsungTV" else if (checkName(
                connectableDevice2,
                "sony,bravia"
            )
        ) "SonyTV" else if (checkName(
                connectableDevice2,
                "AndroidTV,AndroidTV2"
            )
        ) AndroidService.ID else if (checkName(
                connectableDevice2,
                "chromecast"
            )
        ) "ChromeCastTV" else if (checkName(connectableDevice2, "tcl")) "TclTV" else if (checkName(
                connectableDevice2,
                "firetv,fire tv"
            )
        ) FireTVService.ID else "Other"
    }

    fun getTVType(z: Boolean): String {
        var connectableDevice: ConnectableDevice? =
            TVConnectController.instance?.connectableDevice
        return if (checkService(
                connectableDevice,
                "roku"
            )
        ) "RokuTV" else if (checkService(
                connectableDevice,
                "lg,webos,web os"
            )
        ) "LG" else if (checkService(
                connectableDevice,
                "samsung,[tv]"
            )
        ) "SamsungTV" else if (checkService(
                connectableDevice,
                "sony,bravia"
            )
        ) "SonyTV" else if (checkService(connectableDevice, "tcl")) "TclTV" else if (checkService(
                connectableDevice,
                "firetv,fire tv"
            )
        ) FireTVService.ID else if (checkName(
                connectableDevice,
                "roku"
            )
        ) "RokuTV" else if (checkName(
                connectableDevice,
                "lg,webos,web os"
            )
        ) "LG" else if (checkName(
                connectableDevice,
                "samsung,[tv]"
            )
        ) "SamsungTV" else if (checkName(
                connectableDevice,
                "sony,bravia"
            )
        ) "SonyTV" else if (checkName(connectableDevice, "tcl")) "TclTV" else if (checkName(
                connectableDevice,
                "firetv,fire tv"
            )
        ) FireTVService.ID else if (isAndroidTV && z) AndroidService.ID else if (checkService(
                connectableDevice,
                "chromecast"
            )
        ) "ChromeCastTV" else if (checkName(
                connectableDevice,
                "AndroidTV,AndroidTV2"
            )
        ) AndroidService.ID else if (checkName(
                connectableDevice,
                "chromecast"
            )
        ) "ChromeCastTV" else "Other"
    }*/
}