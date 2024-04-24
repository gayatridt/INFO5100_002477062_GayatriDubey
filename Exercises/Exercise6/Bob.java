package org.example;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class Bob
{
    //region properties
    private final SecretKey secretKey;
    private final KeyPair rsaKeys;
    //endregion

    //region constructor
    public Bob(SecretKey aesKey, PublicKey alicePublicKey) throws Exception
    {
        this.secretKey = aesKey;

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        rsaKeys = keyPairGenerator.generateKeyPair();
    }
    //endregion

    //region methods
    public String decryptWithAES(String encryptedMessage) throws Exception
    {
        // encrypted message splitting into IV and ciphertext
        String[] parts = encryptedMessage.split(":");
        byte[] iv = Base64.getDecoder().decode(parts[0]);
        byte[] ciphertext = Base64.getDecoder().decode(parts[1]);

        // cipher instance for decryption
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(128, iv));

        byte[] decryptedData = cipher.doFinal(ciphertext);
        return new String(decryptedData, StandardCharsets.UTF_8);
    }

    public String decryptWithRSA(String encryptedMessage) throws Exception
    {
        byte[] encryptedData = Base64.getDecoder().decode(encryptedMessage);
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.DECRYPT_MODE, rsaKeys.getPrivate());

        return new String(rsaCipher.doFinal(encryptedData), StandardCharsets.UTF_8);
    }

    public boolean checkSignature(String message, byte[] signature, PublicKey alicePublicKey) throws Exception
    {
        Signature signChecker = Signature.getInstance("SHA256withRSA");
        signChecker.initVerify(alicePublicKey);
        signChecker.update(message.getBytes(StandardCharsets.UTF_8));
        return signChecker.verify(signature);
    }

    public PublicKey getPublicRSAKey()
    {
        return rsaKeys.getPublic();
    }

    public PrivateKey getPrivateRSAKey()
    {
        return rsaKeys.getPrivate();
    }
    //region methods
}
