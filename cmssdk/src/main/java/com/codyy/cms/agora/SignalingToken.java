package com.codyy.cms.agora;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * appId             = "C5D15F8FD394285DA5227B533302A518" //App ID
 * appCertificate    = "fe1a0437bf217bdd34cd65053fb0fe1d" //App Certificate
 * expiredTime       = "1546271999" // 授权时间戳
 * account           = "test@agora.io" //客户端定义的用户 ID
 * @see <a href="https://docs.agora.io/cn/2.4/addons/Signaling/Agora%20Platform/key_signaling#signaling-key">密钥说明</a>
 * use server generated token value instead of
 */
@Deprecated
public class SignalingToken {
    /**
     * token       = "1:appId:expiredTime:md5(account + appId + appCertificate + expiredTime)"
     * = "1:C5D15F8FD394285DA5227B533302A518:1546271999:md5(test@agora.ioC5D15F8FD394285DA5227B533302A518fe1a0437bf217bdd34cd65053fb0fe1d1546271999)"
     * = "1:C5D15F8FD394285DA5227B533302A518:1546271999:2d572d6e3a75ebde5a06626f40fe9684"
     */
    public static String getToken(String appId, String certificate, String account, int expiredTsInSeconds) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((account + appId + certificate + expiredTsInSeconds).getBytes());
        byte[] output = md5.digest();
        String token = hexlify(output);
        return "1" + ":" + appId + ":" + expiredTsInSeconds + ":" + token;
    }

    /**
     * 获取一天的token
     *
     * @param appId
     * @param certificate
     * @param account
     * @return
     * @throws NoSuchAlgorithmException
     */
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
