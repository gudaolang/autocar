package com.util;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;
import sun.misc.BASE64Encoder;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 * @author lee
 */
public class Md5Util {

    private static Logger logger = Logger.getLogger(Md5Util.class);

    public final static String getMd5(String sourceStr) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.info(e.getMessage());
        }
        if (md != null) {
            md.update(sourceStr.getBytes(StandardCharsets.UTF_8));
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString();
        }
        return null;
    }

    public static final String getBaseMd5(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.info(e.getMessage());
        }
        if (md5 != null) {
            BASE64Encoder base64en = new BASE64Encoder();
            return base64en.encode(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
        }
        return null;
    }

    /**
     * pbkdf2 算法
     *
     * @param pwd
     * @param salt
     * @return
     */
    public static String PBKDF2(String pwd, String salt) {
        try {
            KeySpec spec = new PBEKeySpec(pwd.toCharArray(), salt.getBytes(StandardCharsets.UTF_8), 4096, 256 * 8);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            return new String(factory.generateSecret(spec).getEncoded());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        Long mills = System.currentTimeMillis();
        System.out.println(mills);
        System.out.println(getMd5("admin" + mills));
    }

    public static String md5Hash(Object source, Object salt) {
        return md5Hash(source, salt, 2);
    }

    public static String md5Hash(Object source, Object salt, int hashIterations) {
        return new Md5Hash(source, salt, hashIterations).toString();
    }

}
