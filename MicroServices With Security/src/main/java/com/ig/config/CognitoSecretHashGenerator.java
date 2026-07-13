package com.ig.config;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CognitoSecretHashGenerator
{
         public static String generateSecretHash(
            String username,
            String clientId,
            String clientSecret) {

        try {
            String message = username + clientId;

            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey =
                    new SecretKeySpec(clientSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

            mac.init(secretKey);

            byte[] hash = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(hash);

        } catch (Exception e) {
            throw new RuntimeException("Error generating secret hash", e);
        }
    }
}