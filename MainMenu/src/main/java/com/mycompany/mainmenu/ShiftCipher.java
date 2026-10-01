/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainmenu;

/**
 * Implements a basic Shift Cipher for encrypting and decrypting text.
 * 
 * @author Mohda
 */
public class ShiftCipher { 

    /**
     * Encrypts the provided text using a shift cipher with the specified key.
     * 
     * @param text The plaintext string to encrypt.
     * @param key  The number of positions to shift each letter forward.
     * @return The resulting encrypted ciphertext string.
     */
    public static String encrypt(String text, int key) { 
        // Initialize an empty string to build the resulting ciphertext
        String result = ""; 

        // Loop through every character in the provided input text
        for (int i = 0; i < text.length(); i++) { 
            // Extract the character at the current index
            char ch = text.charAt(i); 

            // Check if the character is an uppercase letter (A-Z)
            if (ch >= 'A' && ch <= 'Z') { 
                // Shift the character by the key, wrap around using modulo 26, and map back to uppercase ASCII
                ch = (char) ((ch - 'A' + key) % 26 + 'A'); 
            } 
            // Check if the character is a lowercase letter (a-z)
            else if (ch >= 'a' && ch <= 'z') { 
                // Shift the character by the key, wrap around using modulo 26, and map back to lowercase ASCII
                ch = (char) ((ch - 'a' + key) % 26 + 'a'); 
            }

            // Append the processed character (shifted if a letter, unchanged otherwise) to the result string
            result = result + ch; 
        }

        // Return the final encrypted string
        return result; 
    }

    /**
     * Decrypts the provided ciphertext using a shift cipher with the specified key.
     * 
     * @param text The ciphertext string to decrypt.
     * @param key  The number of positions the text was originally shifted by.
     * @return The resulting decrypted plaintext string.
     */
    public static String decrypt(String text, int key) { 
        // Initialize an empty string to build the resulting plaintext
        String result = ""; 

        // Loop through every character in the provided encrypted text
        for (int i = 0; i < text.length(); i++) { 
            // Extract the character at the current index
            char ch = text.charAt(i); 

            // Check if the character is an uppercase letter (A-Z)
            if (ch >= 'A' && ch <= 'Z') { 
                // Reverse the shift by subtracting the key. 
                // Adding 26 before the modulo ensures we don't get negative values during wrap-around.
                ch = (char) ((ch - 'A' - key + 26) % 26 + 'A'); 
            } 
            // Check if the character is a lowercase letter (a-z)
            else if (ch >= 'a' && ch <= 'z') { 
                // Reverse the shift for lowercase letters using the same logic to prevent negative modulo results
                ch = (char) ((ch - 'a' - key + 26) % 26 + 'a'); 
            }

            // Append the deciphered character to the result string
            result = result + ch; 
        }

        // Return the final decrypted string
        return result; 
    }
}