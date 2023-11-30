package com.example.myapplication.Auth;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class PacketParser {
    public static int readExactly(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        int i4 = i2;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i4);
            if (read < 0) {
                return -5;
            }
            i3 += read;
            i4 -= read;
        }
        return i3;
    }

    public static int readPacket(InputStream inputStream, byte[] bArr) throws IOException {
        if (bArr.length < 4) {
            return -2;
        }
        boolean z = false;
        if (-5 == readExactly(inputStream, bArr, 0, 4)) {
            return -5;
        }
        short s = (short) (((bArr[2] & (-1)) << 8) | (bArr[3] & (-1)));
        int i = s + 4;
        if (bArr.length < i) {
            z = true;
            bArr = new byte[i];
        }
        if (-5 == readExactly(inputStream, bArr, 4, s)) {
            return -5;
        }
        if (z) {
            return -2;
        }
        return i;
    }
}