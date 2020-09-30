package com.shaoshao.util;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/29 10:54
 */
public class MD5Utils {
    public static String code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buffer = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                   i+=256;
                if (i<26)
                    buffer.append("0");
                buffer.append(Integer.toHexString(i));
            }
            //32位加密
            return buffer.toString();
            //16位加密
            //return buffer.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(code("hxl158120"));
    }

}
