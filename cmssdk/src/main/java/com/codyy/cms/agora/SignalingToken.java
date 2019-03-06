package com.codyy.cms.agora;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignalingToken {
    public static String getToken(String appId, String certificate, String account, int expiredTsInSeconds) throws NoSuchAlgorithmException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((account + appId + certificate + expiredTsInSeconds).getBytes());
        byte[] output = md5.digest();
        String token = hexlify(output);
        return "1" + ":" + appId + ":" + expiredTsInSeconds + ":" + token;
    }

    public static String getOneDayToken(String appId, String certificate, String account) throws NoSuchAlgorithmException {
        return getToken(appId, certificate, account, 3600 * 24);
    }

    public static String hexlify(byte[] data) {

        char[] toDigits = new char[]{'0', '1', '2', '3', '4', '5',
                '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int l = data.length;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return String.valueOf(out);
    }
}
