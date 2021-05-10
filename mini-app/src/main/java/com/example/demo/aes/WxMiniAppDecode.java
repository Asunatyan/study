package com.example.demo.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Base64;

/**
 * Description:
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
        String sessionKey = "tiihtNczf5v6AKRyjwEUhQ==";
        String encryptedData =
                "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZM" +
                        "QmRzooG2xrDcvSnxIMXFufNstNGTyaGS" +
                        "9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+" +
                        "3hVbJSRgv+4lGOETKUQz6OYStslQ142d" +
                        "NCuabNPGBzlooOmB231qMM85d2/fV6Ch" +
                        "evvXvQP8Hkue1poOFtnEtpyxVLW1zAo6" +
                        "/1Xx1COxFvrc2d7UL/lmHInNlxuacJXw" +
                        "u0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn" +
                        "/Hz7saL8xz+W//FRAUid1OksQaQx4CMs" +
                        "8LOddcQhULW4ucetDf96JcR3g0gfRK4P" +
                        "C7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB" +
                        "6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns" +
                        "/8wR2SiRS7MNACwTyrGvt9ts8p12PKFd" +
                        "lqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYV" +
                        "oKlaRv85IfVunYzO0IKXsyl7JCUjCpoG" +
                        "20f0a04COwfneQAGGwd5oa+T8yO5hzuy" +
                        "Db/XcxxmK01EpqOyuxINew==";
        String iv = "r7BXXKkLb8qrSNn05n0qiA==";


        //Cipher cipher = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            //cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(Base64.getDecoder().decode(sessionKey), "AES");

            AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
            params.init(new IvParameterSpec(Base64.getDecoder().decode(iv)));

            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, params);// 初始化
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            System.out.println(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
