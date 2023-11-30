package com.example.myapplication.Keystore;

import android.content.Context;
import android.os.AsyncTask;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public abstract class AsyncKeystore extends AsyncTask<Context, Void, KeyStoreManager> {
    public static KeyStoreManager keyStoreManager;

    @Override // android.os.AsyncTask
    public KeyStoreManager doInBackground(Context... contextArr) {
        if (keyStoreManager == null) {
            KeyStoreManager keyStoreManager2 = new KeyStoreManager(contextArr[0]);
            keyStoreManager = keyStoreManager2;
            if (!keyStoreManager2.hasServerIdentityAlias()) {
                keyStoreManager.initializeKeyStore();
            }
        }
        return keyStoreManager;
    }
}