/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainmenu;

/**
 * Implements RSA encryption, decryption, and key pair generation functionalities.
 * 
 * @author Mohda
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSACipher { 

    /**
     * Generates a 2048-bit RSA public and private key pair.
     * 
     * @return A KeyPair object containing both the public and private keys.
     * @throws Exception If the RSA algorithm is unavailable.
     */
    public static KeyPair generateKeyPair() throws Exception { 
        // Instantiate a KeyPairGenerator specifically configured for the RSA algorithm
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA"); 
        
        // Set the key size to 2048 bits for strong encryption
        keyGen.initialize(2048); 
        
        // Generate the key pair and store it in the 'pair' variable
        KeyPair pair = keyGen.generateKeyPair(); 
        
        // Return the generated key pair
        return pair; 
    }

    /**
     * Encrypts a plaintext message using the provided RSA public key.
     * 
     * @param message   The plaintext string to be encrypted.
     * @param publicKey The recipient's RSA public key.
     * @return A Base64 encoded string representing the encrypted data.
     * @throws Exception If an error occurs during the encryption process.
     */
    public static String encrypt(String message, PublicKey publicKey) throws Exception { 
        // Create an instance of the Cipher class configured for the RSA algorithm
        Cipher cipher = Cipher.getInstance("RSA");
        
        // Initialize the cipher into ENCRYPT_MODE and provide the public key to lock the data
        cipher.init(Cipher.ENCRYPT_MODE, publicKey); 

        // Convert the plaintext string into a byte array and execute the encryption
        byte[] encryptedBytes = cipher.doFinal(message.getBytes()); 
        
        // Encode the resulting encrypted byte array into a Base64 string so it can be easily stored or transmitted as text
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes); 

        // Return the Base64 encoded ciphertext
        return encryptedText; 
    }

    /**
     * Decrypts a Base64 encoded encrypted message using the provided RSA private key.
     * 
     * @param encryptedMessage The Base64 encoded ciphertext string.
     * @param privateKey       The recipient's RSA private key.
     * @return The resulting decrypted plaintext string.
     * @throws Exception If an error occurs during decryption.
     */
    public static String decrypt(String encryptedMessage, PrivateKey privateKey) throws Exception { 
        // Create an instance of the Cipher class configured for the RSA algorithm
        Cipher cipher = Cipher.getInstance("RSA"); 
        
        // Initialize the cipher into DECRYPT_MODE and provide the private key to unlock the data
        cipher.init(Cipher.DECRYPT_MODE, privateKey); 

        // Decode the Base64 string back into the raw encrypted byte array
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage); 
        
        // Execute the decryption on the decoded byte array
        byte[] decryptedBytes = cipher.doFinal(decodedBytes); 

        // Convert the decrypted byte array back into a readable string and return it
        return new String(decryptedBytes); 
    }
}