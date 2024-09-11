package org.glimmer.utils;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;

public class SM4Utils {

    /**
     * SM4是对称加密，需要设置一个加解密秘钥
     * <p>
     * System.out.println(Arrays.toString("@Jhx2024#$%^&*!+".getBytes(StandardCharsets.UTF_8)));
     * 特别注意字符串key的长度需要16位
     */
    private static final byte[] keys = new byte[]{64, 74, 104, 120, 50, 48, 50, 52, 35, 36, 37, 94, 38, 42, 33, 43};

    /**
     * 创建一个SM4加解密对象
     */
    private static final SM4 sm4 = SmUtil.sm4(keys);

    /**
     * 设置一个标识符，标识@SM4@- 开头的字符串是经过SM4加密的需要解密
     */
    public static final String SM4_PREFIX = "@SM4@-";


    /**
     * 对字符串进行加密
     *
     * @param value
     * @return
     */
    public static String encryptStr(String value) {
        // 对加密的字符串添加前缀，方便标识这是一个加密以后的字符串
        return SM4_PREFIX + sm4.encryptBase64(value);
    }

    /**
     * 对字符串进行解密
     *
     * @param encryptValue
     * @return
     */
    public static String decryptStr(String encryptValue) {
        // 解密时，需要去除加密标识符
        return encryptValue.startsWith(SM4_PREFIX) ? sm4.decryptStr(encryptValue.substring(SM4_PREFIX.length())) : encryptValue;
    }
}

