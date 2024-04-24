package org.example;

import java.util.Base64;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // Instances of Alice and Bob class
        Alice alice = new Alice();
        Bob bob = new Bob(alice.getAESKey(), alice.getPublicRSAKey());

        // Symmetric encryption and decryption
        String symmetricMessage = "Hello, Bob!";
        String aesEncryptedMessage = alice.encryptWithAES(symmetricMessage);
        System.out.println("AES Encrypted message: " + aesEncryptedMessage);
        String aesDecryptedMessage = bob.decryptWithAES(aesEncryptedMessage);
        System.out.println("AES Decrypted message: " + aesDecryptedMessage);

        // Asymmetric encryption and decryption
        String asymmetricMessage = "Hi! How are you?";
        String rsaEncryptedMessage = alice.encryptWithRSA(asymmetricMessage, bob.getPublicRSAKey());
        System.out.println("RSA Encrypted message: " + rsaEncryptedMessage);
        String rsaDecryptedMessage = bob.decryptWithRSA(rsaEncryptedMessage);
        System.out.println("RSA Decrypted message: " + rsaDecryptedMessage);

        // Message signing and signature verification demonstration
        byte[] messageSignature = alice.sign(symmetricMessage);
        System.out.println("Message Signature (Base64 encoded): " + Base64.getEncoder().encodeToString(messageSignature));
        boolean isSignatureVerified = bob.checkSignature(symmetricMessage, messageSignature, alice.getPublicRSAKey());
        System.out.println("Signature verification result: " + isSignatureVerified);
    }
}
