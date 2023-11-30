package com.example.myapplication;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.connectsdk.discovery.DiscoveryManager;




public class REmoteAPplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize Connect SDK
     ///   new Thread(()->{
            DiscoveryManager.init(getApplicationContext());
            DiscoveryManager.getInstance().start();
            DeviceConnectService.enqueueWork(getApplicationContext(), new Intent());
            Log.d("application level","sfsdfsdf");
      //  }).start();


    }
}
