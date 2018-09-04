package com.example.common;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


/**
 * @program: realtour-r8-qj-b2b
 * @description: 加解密工具类
 * @author: 周成平
 * @create: 2018-08-27 21:33
 **/
public class EncryptUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String AES_ENCRYPT_PWD = "U2FsdGVkX19lh/5hsMhQrQVkkGxn+93D";
    private static Logger LogTools = LoggerFactory.getLogger(EncryptUtil.class);

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            byte[] byteContent = content.getBytes("utf-8");
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //通过Base64转码返回
            return Base64.encodeBase64String(result);
        } catch (Exception ex) {
            LogTools.error("AES 加密操作报错", ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content 待加密字符串
     * @return 返回解密字符串
     */
    public static String decrypt(String content) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey());
            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            return new String(result, "utf-8");
        } catch (Exception ex) {
            LogTools.error("AES 解密操作报错", ex);
        }
        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return 翻车加密密钥
     */
    private static SecretKeySpec getSecretKey() {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            //AES 要求密钥长度为 128
            kg.init(128, new SecureRandom(AES_ENCRYPT_PWD.getBytes()));
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            LogTools.error("生成加密密钥报错", ex);
        }
        return null;
    }

    /**
     * 对字符串md5加密(小写+字母)
     *
     * @param str 传入要加密的字符串
     * @return MD5加密后的字符串
     */
    public static String getMd5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception ex) {
            LogTools.error("MD5加密报错", ex);
            return null;
        }
    }

    /**
     * 将Body属性内所有内容（包含标签但不包含Body本身）加上请求的Time时间戳（Body+Time）后将合并的字符串后8位倒置至最前，
     * 如abcdefghij，倒置后为cdefghijab，在倒置后的字符串cdefghijab后加密钥（cdefghijabKey）。
     * 对得到前面的字符串的再进行MD5加密（32位小写），得到最终的Sign签名。
     * 待加密字符串示例 body：aaabbbccc   time: 1519961262   key:ttttuuu
     * 则需要MD5加密的字符串为  19961262aaabbbccc15ttttuuu
     * Sign  ae67a4838618e565d5cf2e776a929e52
     *
     * @param str 传入要加密的字符串
     * @return MD5加密后的字符串
     */
    public static String getAPIMd5(String str, String key) {
        try {
            if (str.length() > 8) {
                str = str.substring(str.length() - 8).concat(str.substring(0, str.length() - 8)).concat(key);
            }
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 计算md5函数
            md.update(str.getBytes(StandardCharsets.UTF_8));

            return bytesToHexString(md.digest());
        } catch (Exception ex) {
            LogTools.error("MD5加密报错", ex);
            return null;
        }
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte aSrc : src) {
            int v = aSrc & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
