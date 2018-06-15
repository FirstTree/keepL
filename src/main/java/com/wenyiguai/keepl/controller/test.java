package com.wenyiguai.keepl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;

/**
 * Create by FirsTree on 2018-5-29
 */
@Controller
public class test {

    @ResponseBody
    @RequestMapping("/test")
    public String ddd(String idcard, String name){
        String appKey = "9432de1c1d520d821aee2d009ae0a38c";
        System.out.println(idcard.getBytes());
        System.out.println(name.getBytes());
        String a = a(idcard + name + appKey);
        return a;
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
