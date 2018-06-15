package com.wenyiguai.keepl.redom;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * Create by FirsTree on 2018-5-28
 */
public class Md5 {

    public static void main(String[] args) {
        String idCard="330127199406101235";
        String name = "叶茂";
        String appKey = "9432de1c1d520d821aee2d009ae0a38c";
        String sign = a(idCard + name + appKey);
        System.out.println(sign);
//        String iso8859 = null;
//        try {
//            iso8859 = new String(idCard.getBytes("iso8859-1"));
//            String gbk = new String(idCard.getBytes("gbk"));
//            String utf8 = new String(idCard.getBytes("utf-8"));
//            if(iso8859.equals(idCard)){
//                System.out.println("iso8859");
//            }else  if(gbk.equals(idCard)){
//                System.out.println("gbk");
//            }else  if(utf8.equals(idCard)){
//                System.out.println("utf8");
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("----"+idCard.getBytes());
//        System.out.println(name.getBytes());
    }

    public static final String a(String var0) {
        char[] var1 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            byte[] var2 = var0.getBytes();
            MessageDigest var3 = MessageDigest.getInstance("MD5");
            var3.update(var2);
            byte[] var4 = var3.digest();
            int var5 = var4.length;
            char[] var6 = new char[var5 * 2];
            int var7 = 0;

            for(int var8 = 0; var8 < var5; ++var8) {
                byte var9 = var4[var8];
                var6[var7++] = var1[var9 >>> 4 & 15];
                var6[var7++] = var1[var9 & 15];
            }

            return new String(var6);
        } catch (Exception var10) {
            var10.printStackTrace();
            return null;
        }
    }
}
