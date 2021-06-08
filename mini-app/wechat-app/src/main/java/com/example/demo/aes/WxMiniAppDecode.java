package com.example.demo.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Base64;

/**
 * Description: 微信小测序的用户信息解密类
 * date: 2021/5/6 下午 03:27
 *
 * @author dqk
 */
public class WxMiniAppDecode {
    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }
    public static void main(String[] args) {
        String appIdappId = "wx4f4bc4dec97d474b";
        String sessionKey = "Ot6L76Jb0g2Dlu0CknFThQ==";
        String encryptedData = "S+Jd46t7Kq92VhSm0UxB0NPvU2r8L37GmyrEd2A6Hu5LZlAHsVICDfQTxh9NuFHYSAEWWM+PCZ6r5QNAyEyT9UCls7sm4mxy3GrAVNE9wsQPqswRAI+vvgBwUeTeSmFTQbEr08sgmNrJjh28KsIjDCMbOkCDrzkJ5RmZVAnr7bk4MxgCviHNyXtq/sO2nYfFUpCJnZoL4UzFAnedijgh+w==";
        String iv = "Syp15RgNIQY636C4/LAHmA==";


        //Cipher cipher = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            //cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(Base64.getDecoder().decode(sessionKey), "AES");

            AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
            params.init(new IvParameterSpec(Base64.getDecoder().decode(iv)));

            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, params);// 初始化
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            System.out.println(new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
