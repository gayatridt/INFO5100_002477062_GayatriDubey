package org.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class Alice
{
    //region properties
    private SecretKey encryptionKey;
    private KeyPair rsaKeyPair;
    //endregion

    //region constructor
    public Alice() throws Exception
    {
        createAESKey();
        createRSAKeys();
    }
    //endregion

    //region methods
    private void createAESKey() throws Exception
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        encryptionKey = keyGenerator.generateKey();
    }

    private void createRSAKeys() throws Exception
    {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        rsaKeyPair = keyPairGenerator.generateKeyPair();
    }

    public String encryptWithAES(String message) throws Exception
    {
        // cipher instance AES/GCM/NoPadding
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        // random 12-byte IV (Initialization Vector)
        byte[] iv = new byte[12];
        new SecureRandom().nextBytes(iv);

        cipher.init(Cipher.ENCRYPT_MODE, encryptionKey, new GCMParameterSpec(128, iv));

        // Encrypting message and encoding IV and ciphertext to Base64
        byte[] encryptedMessage = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(iv) + ":" + Base64.getEncoder().encodeToString(encryptedMessage);
    }

    public String encryptWithRSA(String message, PublicKey bobPublicKey) throws Exception
    {
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, bobPublicKey);
        byte[] encryptedMessage = rsaCipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }

    public byte[] sign(String message) throws Exception
    {
        Signature signatureAlgorithm = Signature.getInstance("SHA256withRSA");
        signatureAlgorithm.initSign(rsaKeyPair.getPrivate());
        signatureAlgorithm.update(message.getBytes(StandardCharsets.UTF_8));
        return signatureAlgorithm.sign();
    }

    public SecretKey getAESKey()
    {
        return encryptionKey;
    }

    public PublicKey getPublicRSAKey()
    {
        return rsaKeyPair.getPublic();
    }

    public PrivateKey getPrivateRSAKey()
    {
        return rsaKeyPair.getPrivate();
    }
    //endregion
}
