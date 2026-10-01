package com.mycompany.mainmenu;

public class CaesarCipher {

    // Encrypt method: shifts each letter forward by 3
    public static String encrypt(String text) {
        String result = ""; // stores the final encrypted text

        // Loop through each character in the input
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i); // get current character

            // If uppercase letter (A–Z)
            if (ch >= 'A' && ch <= 'Z') {
                // Convert to 0–25 range, shift +3, wrap with %26, convert back
                ch = (char) ((ch - 'A' + 3) % 26 + 'A');

            // If lowercase letter (a–z)
            } else if (ch >= 'a' && ch <= 'z') {
                // Same logic but for lowercase
                ch = (char) ((ch - 'a' + 3) % 26 + 'a');
            }

            // Add the processed character to result
            result = result + ch;
        }

        return result; // return encrypted text
    }

    // Decrypt method: shifts each letter backward by 3
    public static String decrypt(String text) {
        String result = ""; // stores the final decrypted text

        // Loop through each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i); // get current character

            // If uppercase letter (A–Z)
            if (ch >= 'A' && ch <= 'Z') {
                // Shift -3, +26 to avoid negative, then wrap
                ch = (char) ((ch - 'A' - 3 + 26) % 26 + 'A');

            // If lowercase letter (a–z)
            } else if (ch >= 'a' && ch <= 'z') {
                // Same logic for lowercase
                ch = (char) ((ch - 'a' - 3 + 26) % 26 + 'a');
            }

            // Add to result
            result = result + ch;
        }

        return result; // return decrypted text
    }
}