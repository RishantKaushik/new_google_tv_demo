package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.connectsdk.device.ConnectableDevice
import com.connectsdk.device.ConnectableDeviceListener
import com.connectsdk.device.DevicePicker
import com.connectsdk.discovery.DiscoveryManager
import com.connectsdk.discovery.DiscoveryManagerListener
import com.connectsdk.service.DeviceService
import com.connectsdk.service.command.ServiceCommandError
import com.example.myapplication.TVType.isNewAndroidTV


class MainActivity : Activity() ,DiscoveryManagerListener {

    private lateinit var devices : Map<String ,ConnectableDevice>
    private lateinit var devicePicker: DevicePicker
    private lateinit var listView: ListView

    val TAG = "MainActivity"

    val connectableDeviceListener = object : ConnectableDeviceListener {
        override fun onDeviceReady(connectableDevice: ConnectableDevice) {
            connectDeviceReady(connectableDevice)
            Log.d("lalit ","onDeviceconnected: ")
        }

        override fun onDeviceDisconnected(connectableDevice: ConnectableDevice) {
            val sb = StringBuilder()
            sb.append("onDeviceDisconnected: ")
            Log.d("lalit ","onDeviceDisconnected: ")
            sb.append(connectableDevice.modelName)
        }

        override fun onPairingRequired(
            connectableDevice: ConnectableDevice,
            deviceService: DeviceService,
            pairingType: DeviceService.PairingType
        ) {
            val sb = StringBuilder()
            sb.append("onPairingRequired: ")
            sb.append(connectableDevice.modelName)

            when (pairingType) {
                DeviceService.PairingType.PIN_CODE -> {
                    try {
                       /* if (pairingAlertDialog != null) {
                            pairingAlertDialog.show()
                        }*/
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                DeviceService.PairingType.FIRST_SCREEN, DeviceService.PairingType.MIXED -> {
                    try {
                        Handler().postDelayed({
                            try {
                                if (!isDestroyed && !isFinishing) {
                                   /* llConnected?.visibility = View.GONE
                                    pinCodeDialog?.show()*/
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }, 1000L)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

                else -> {

                }
            }
        }

        override fun onCapabilityUpdated(
            connectableDevice: ConnectableDevice,
            list: List<String>,
            list2: List<String>
        ) {
            val sb = StringBuilder()
            sb.append("onCapabilityUpdated: ")
            sb.append(connectableDevice.modelName)
        }

        override fun onConnectionFailed(
            connectableDevice: ConnectableDevice,
            serviceCommandError: ServiceCommandError
        ) {
            val sb = StringBuilder()
            sb.append("onConnectionFailed: ")
            sb.append(connectableDevice.modelName)
          //  connectFailed(connectableDevice)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DiscoveryManager.getInstance().addListener(this);

        // Start device discovery

       // CoroutineScope(Dispatchers.IO).launch {
          //  delay(2000) // Simulated delay, replace with your actual background task


            /*val c: ConnectableDevice
            c.setPairingType(DeviceService.PairingType.PIN_CODE)
            c.connect()
*/
         //   withContext( Dispatchers.Main){


          //  }
            // Update UI on the main thread
       // }

        // Create a DevicePicker instance
        devicePicker = DevicePicker(this)

        findViewById<TextView>(R.id.titleTextView).setOnClickListener {
            Log.d(TAG, "in show"+"${devicePicker.listView}")

        }
        // Get the ListView from layout
        listView = findViewById(R.id.deviceListView)

//        showDeviceList()
    }

    private fun showDeviceList() {
        // Create a list of device names
        val deviceNames = ArrayList<String>()

        for (device in devices.values) {
            Log.d(TAG, "in for loop")
            deviceNames.add(device.friendlyName)
        }

        // Create an ArrayAdapter to display the device names in the ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, deviceNames)

        // Set up a click listener for the ListView items
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedDevice = devices.values.elementAt(position)
Log.d("lalit  :--",selectedDevice.modelName)
            TVConnectController.instance?.connectableDeviceAndroidTV =selectedDevice
            TVConnectController.instance?.connectableDeviceClick=selectedDevice

            val sb = StringBuilder()
            sb.append("connectToDevice: ")
            sb.append(selectedDevice.modelName) // Assuming 'modelName' is the property to get the model name
            selectedDevice.addListener(connectableDeviceListener)
            selectedDevice.setPairingType(DeviceService.PairingType.PIN_CODE)
            selectedDevice.connect()
            selectedDevice.sendPairingKey("LALIT");

        }

        // Set up a long click listener for the ListView items (for disconnecting or additional actions)
        listView.setOnItemLongClickListener { parent, view, position, id ->
            // Handle long click action (e.g., show a context menu)
            true
        }

        // Set the ArrayAdapter on the ListView
        listView.adapter = adapter
    }


    override fun onDestroy() {
        super.onDestroy()

        // Stop device discovery when the activity is destroyed
     //   DiscoveryManager.getInstance().stop()
    }

    override fun onDeviceAdded(manager: DiscoveryManager?, device: ConnectableDevice?) {

        devices = DiscoveryManager.getInstance().compatibleDevices
        showDeviceList()
    }

    override fun onDeviceUpdated(manager: DiscoveryManager?, device: ConnectableDevice?) {
        Log.d("ss"," mila kuch bhi")
        showDeviceList()
    }

    override fun onDeviceRemoved(manager: DiscoveryManager?, device: ConnectableDevice?) {
        Log.d("ss","na remove kuch bhi")
    }

    override fun onDiscoveryFailed(manager: DiscoveryManager?, error: ServiceCommandError?) {
      Log.d("ss","na mila kuch bhi")
    }

    fun connectDeviceReady(connectableDevice: ConnectableDevice?) {
        runOnUiThread(Runnable
        // from class: com.begamob.global.remote.roku.ui.screen.connect.ConnectActivity.14
        // java.lang.Runnable
        {
            try {
                Log.d("sfd",connectableDevice?.ipAddress.toString())
                TVConnectController.instance?.connectableDevice=connectableDevice
                TVConnectController.instance?.isIRMode ?:  false
                connectToAndroidTv()
              /*  if (connectableDevice != null && TVType.getTVType(connectableDevice)
                        .equals("RokuTV")
                ) {
                   // SharedPrefsUtil.getInstance().put("USER_ROKU", Boolean.TRUE)

                }
                if (TVType.getTVType(connectableDevice).equals("ChromeCastTV")) {
                    connectToAndroidTv()
                } else if (TVType.isFireTV(connectableDevice)) {
                //   processDataFireTV(connectableDevice)
                    return@Runnable
                } else {
                 // checkConnected()
                }*/
           /*     try {
                    val checkKeySamsungDialog: CheckKeySamsungDialog =
                        dialogCheck
                    if (checkKeySamsungDialog == null || !checkKeySamsungDialog.isShowing()) {
                        return@Runnable
                    }
                    .dialogCheck.dismiss()
                } catch (e2: java.lang.Exception) {
                    e2.printStackTrace()
                }*/
            } catch (e3: java.lang.Exception) {
                e3.printStackTrace()
            }
        })
    }

    fun connectToAndroidTv() {
        val port: Int?
        Log.d("testing","calling")

        val connectableDeviceAndroidTV: ConnectableDevice? =
            TVConnectController.instance?.connectableDeviceAndroidTV
      /*  if (!isNewAndroidTV) {
            Log.d("testing","sdfgsdfport")
            Log.d("testing","$connectableDeviceAndroidTV")
            Log.d("testing","${connectableDeviceAndroidTV?.getServiceByName(AndroidService.ID)}")
            Log.d("testing","${connectableDeviceAndroidTV?.getServiceByName(AndroidService.ID)?.serviceDescription}")
            port = connectableDeviceAndroidTV?.getServiceByName(AndroidService.ID)?.serviceDescription?.port
            Log.d("testing",port.toString()+"sdfgsdf")
        } else {
            port = connectableDeviceAndroidTV?.getServiceByName(NewAndroidService.ID)?.getServiceDescription()?.getPort()!!
            Log.d("testing",port.toString()+"sdafasfasfsafasfasfasfgsdf")

        }*/


            AndroidTVManager.getInstance(this)?.connect(connectableDeviceAndroidTV?.ipAddress,8008 , isNewAndroidTV)

        Log.d("testing","sdfqwertyuiytrewertyuiuytre3rtyuioiuytregsdf")

            AndroidTVManager.getInstance(this)?.setListener(object :
                AndroidTVManager.ConnectionListener {
                override fun onPinRequested() {
                    showAndroidPairingCode()
                }

                // com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.ConnectionListener
                override fun onConnected() {
                    checkConnected()
                }

                // com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.ConnectionListener
                override fun onConnectionFailed() {
                checkConnected()
                }
            })
    }
    fun checkConnected() {
        if (isDestroyed) {
            return
        }
    }
    fun showAndroidPairingCode() {
        runOnUiThread(Runnable
        // from class: com.begamob.global.remote.roku.ui.screen.connect.ConnectActivity.19
        // java.lang.Runnable
        {
         /*   val pinCodeDialog =
                PinCodeDialog(this@MainActivity, true, object : DialogListener() {
                    // from class: com.begamob.global.remote.roku.ui.screen.connect.ConnectActivity.19.1
                    // com.begamob.global.remote.roku.ui.screen.dialog.PinCodeDialog.DialogListener
                    fun onCancel() {
                        val connectActivity: MainActivity = this@MainActivity
                        Toast.makeText(
                            connectActivity,
                            "enter pin code",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    // com.begamob.global.remote.roku.ui.screen.dialog.PinCodeDialog.DialogListener
                    fun onOk(str: String?) {*/
                        try {
                         //   AndroidTVManager.getInstance(this@MainActivity).setSecret("LALIT")
                        } catch (e2: java.lang.Exception) {
                            e2.printStackTrace()
                        }
                 /*   }
                })*/
            if (this@MainActivity.isDestroyed()) {
                return@Runnable
            }
         //   pinCodeDialog.show()
        })
    }


}
