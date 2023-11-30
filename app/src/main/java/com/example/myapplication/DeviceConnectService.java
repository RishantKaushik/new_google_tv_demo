package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;

import com.connectsdk.discovery.DiscoveryManager;
import com.connectsdk.discovery.provider.CastDiscoveryProvider;
import com.connectsdk.discovery.provider.SSDPDiscoveryProvider;
import com.connectsdk.service.CastService;
import com.connectsdk.service.DLNAService;
import com.connectsdk.service.RokuService;
import com.connectsdk.service.WebOSTVService;

public class DeviceConnectService  extends JobIntentService {
        public static final int JOB_ID = 1;

        @Override // androidx.core.app.JobIntentService, android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // androidx.core.app.JobIntentService
        public void onHandleWork(@NonNull Intent intent) {
        }

        public static void enqueueWork(Context context, Intent intent) {
            JobIntentService.enqueueWork(context, DeviceConnectService.class, 1, intent);
        }

        @Override // androidx.core.app.JobIntentService, android.app.Service
        public void onCreate() {
            super.onCreate();
            if (DiscoveryManager.getInstance() == null) {
                DiscoveryManager.init(getApplicationContext());
            }
            if (DiscoveryManager.getInstance() != null) {
                DiscoveryManager.getInstance().registerDeviceService(CastService.class, CastDiscoveryProvider.class);
                DiscoveryManager.getInstance().registerDeviceService(RokuService.class, SSDPDiscoveryProvider.class);
                DiscoveryManager.getInstance().registerDeviceService(DLNAService.class, SSDPDiscoveryProvider.class);
                DiscoveryManager.getInstance().registerDeviceService(WebOSTVService.class, SSDPDiscoveryProvider.class);
                DiscoveryManager.getInstance().setPairingLevel(DiscoveryManager.PairingLevel.ON);
                DiscoveryManager.getInstance().start();
            }
        }

}
