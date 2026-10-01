package com.mycompany.mainmenu;

// Cipher = performs encryption/decryption operations
import javax.crypto.Cipher;

// SecretKeySpec = used to create an AES key from raw bytes
import javax.crypto.spec.SecretKeySpec;

// Base64 = used to convert binary data to readable text and back
import java.util.Base64;

public class BlockCipherAES {

    // Ensures the key is exactly 16 characters (128-bit for AES)
    public static String fixKey(String key) {

        // If key is too short → pad with '0'
        if (key.length() < 16) {
            while (key.length() < 16) {
                key = key + "0";
            }

        // If key is too long → cut to 16 characters
        } else if (key.length() > 16) {
            key = key.substring(0, 16);
        }

        return key; // return adjusted key
    }

    // Encrypts plain text using AES
    public static String encrypt(String text, String key) throws Exception {

        key = fixKey(key); // make sure key is valid length

        // Create AES key from string bytes
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        // Create cipher object for AES encryption
        Cipher cipher = Cipher.getInstance("AES"); // default: AES/ECB/PKCS5Padding

        // Initialize cipher in ENCRYPT mode with the key
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Convert text to bytes and encrypt it
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());

        // Convert encrypted bytes to Base64 string (readable format)
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        return encryptedText; // return encrypted result
    }

    // Decrypts AES encrypted text
    public static String decrypt(String text, String key) throws Exception {

        key = fixKey(key); // ensure same key format

        // Create AES key
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        // Create cipher for AES decryption
        Cipher cipher = Cipher.getInstance("AES");

        // Initialize cipher in DECRYPT mode
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decode Base64 string back to encrypted bytes
        byte[] decodedBytes = Base64.getDecoder().decode(text);

        // Decrypt bytes back to original data
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);

        // Convert decrypted bytes to string
        return new String(decryptedBytes);
    }
}