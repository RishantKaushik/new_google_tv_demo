package com.example.myapplication

import com.connectsdk.device.ConnectableDevice


class TVObject(var tvName: String, arrayList: ArrayList<ConnectableDevice>) {
    var arrType: ArrayList<ConnectableDevice>

    init {
        arrType = ArrayList()
        arrType = arrayList
    }
}