package com.example.myapplication

import android.R
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.os.Build
import android.os.Handler
import androidx.core.app.NotificationCompat
import com.connectsdk.device.ConnectableDevice
import com.connectsdk.service.capability.MediaControl
import java.nio.channels.Channel


class TVConnectController {
    var connectableDevice: ConnectableDevice? = null
    var connectableDeviceAndroidTV: ConnectableDevice? = null
    var connectableDeviceClick: ConnectableDevice? = null
    private val context: Context? = null
    var mediaControl: MediaControl? = null
    var tvObject: TVObject? = null
    var volume = 0.1f
    var isSound = false
    var clickVipRemote = 0
    var isRewardRemote = false
    var isRewardChannel = false
    var isRewardCast = false
    var isIRMode = false
    private val isScreenStreaming = false
    var needReloadRemote = false
    var isCast = false
    var isContainDevice = false
    var isClickItem = false
    var nameTvContain = ""
    var nameService = ""
    var nameDeviceSave = ""
    private val channelsArray: MutableList<Channel?> = ArrayList<Channel?>()
    var isShowAds = true
    var numberStartCastTier1 = 0
    var numberPremiumSaleStartCastTier1 = 0
    var numberClosePremium = 0
    private val typeTv = 1
    var rokuChanelList: List<Channel?>?
        get() = channelsArray
        set(list) {
            channelsArray.clear()
            channelsArray.addAll(list!!)
        }
    val isConnected: Boolean
        get() {
            val connectableDevice = connectableDevice
            return connectableDevice?.isConnected ?: false
        }

    fun disconnect() {
        val connectableDevice = connectableDevice
        if (connectableDevice != null) {
            connectableDevice.disconnect()
            this.connectableDevice = null
            connectableDeviceAndroidTV = null
        }
    }

    val deviveName: String
        get() {
            val connectableDevice = connectableDevice
            return if (connectableDevice != null) {
                if (connectableDevice.friendlyName != null) {
                    this.connectableDevice!!.friendlyName
                } else this.connectableDevice!!.modelName
            } else "no TV connection"
        }

    fun pushNotifyConnect(context: Context) {
        Handler().postDelayed(Runnable
        // from class: com.connectsdk.TVConnectController.1
        // java.lang.Runnable
        {
            val tVConnectController = this@TVConnectController
            if (tVConnectController.isContainDevice && !tVConnectController.isClickItem) {
                showNotification(context)
                return@Runnable
            }
        }, 180000L
        )
    }

    fun showNotification(context: Context) {
        val str = "Connect to tv " + nameTvContain
        val defaultUri = RingtoneManager.getDefaultUri(2)
        val currentTimeMillis = System.currentTimeMillis()
        if (Build.VERSION.SDK_INT >= 26) {
            val notificationChannel = NotificationChannel("ID_CONNECT", "Remote Roku", NotificationManager.IMPORTANCE_DEFAULT)
            notificationChannel.description = "Cast tv"
            val notificationManager = context.getSystemService(
                NotificationManager::class.java
            ) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("KEY_CLICK_NOTIFY", 1)
            intent.setFlags(268468224)
            notificationManager.notify(
                66,
                NotificationCompat.Builder(context, "ID_CONNECT").setContentTitle(str)
                    .setContentText("We found your TV but it's not connected yet. Click here to connect")
                    .setSound(defaultUri).setAutoCancel(true).setWhen(currentTimeMillis)
                    .setSmallIcon(R.drawable.ic_lock_idle_alarm).setLargeIcon(
                        BitmapFactory.decodeResource(
                            context.resources,
                            R.drawable.ic_lock_idle_alarm
                        )
                    ).setStyle(
                        NotificationCompat.BigTextStyle()
                            .bigText("We found your TV but it's not connected yet. Click here to connect")
                    ).setContentIntent(
                        PendingIntent.getActivity(
                            context,
                            0,
                            intent,
                            PendingIntent.FLAG_MUTABLE
                        )
                    ).build()
            )
            return
        }
        val intent2 = Intent(context, MainActivity::class.java)
        intent2.putExtra("KEY_CLICK_NOTIFY", 2)
        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        (context.getSystemService("android.content.Context.NOTIFICATION_SERVICE") as NotificationManager).notify(
            66,
            NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_lock_idle_alarm).setContentTitle(str)
                .setContentText("We found your TV but it's not connected yet. Click here to connect")
                .setSound(defaultUri).setAutoCancel(true).setWhen(currentTimeMillis)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_lock_idle_alarm))
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText("We found your TV but it's not connected yet. Click here to connect")
                ).setContentIntent(PendingIntent.getActivity(context, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT))
                .build()
        )
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var sTVConnectController: TVConnectController? = null
        val instance: TVConnectController?
            get() {
                if (sTVConnectController == null) {
                    sTVConnectController = TVConnectController()
                }
                return sTVConnectController
            }
    }
}