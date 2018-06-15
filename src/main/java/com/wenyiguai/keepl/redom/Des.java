package com.wenyiguai.keepl.redom;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.wenyiguai.keepl.util.HttpUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * Create by FirsTree on 2018-5-31
 */
public class Des {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    public static void main(String[] args) {
        String appId = "DgS75lfYu3ZGAKjT";
        String url = "http://36.110.189.107:8088/myh/v1/usr/sysuser";
        String timeStampUrl = "http://36.110.189.107:8088/myh/v1/usrmne/currenttime/info";
        if (true) {
            String postStr = "{\"opType\":\"U\",\"usrid\":\"hcn^03^01^f467f9ad-f4f1-46d6-9ac3-a3fad4529350\",\"phone\":\"15200000012\",\"pname\":\"卫高俊\",\"idType\":\"01\",\"idNum\":\"220523198201244933\",\"gender\":\"2\",\"birth\":\"1990-06-14\",\"country\":\"01\",\"addrProv\":\"\",\"addrCity\":\"\",\"addrCounty\":\"\",\"addrFull\":\"\",\"authStatus\":\"0\"}";
            String timestamp = System.currentTimeMillis() + "";
            String key = "ajYD4s8w284CXDbu";
            try {
                String param1 = appId;
                String param2 = new String(Base64.encode(encrypt(timestamp.getBytes(UTF_8), key.getBytes())).getBytes(UTF_8), UTF_8);
                String param3 = new String(Base64.encode(encrypt(postStr.getBytes(UTF_8),key.getBytes())).getBytes(UTF_8),UTF_8);
                String param4 = new String(Base64.encode(encrypt((timestamp + postStr).getBytes(UTF_8), key.getBytes())).getBytes(UTF_8),UTF_8);

                String apiUrl = url + "/" + "synchpersInfo"
                        + "?appKey=" + appId
                        + "&acl={\"param1\":\"" +param1 +"\",\"param2\":\""+param2 + "\",\"param3\":\""+param3 +"\",\"param4\":\""+param4+"\"}";
                long startTime = System.currentTimeMillis();
                String res = HttpUtils.post(apiUrl, param3);
                long endTime = System.currentTimeMillis();
                System.out.println(res);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(data);
    }
}
