/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainmenu;

/**
 *
 * @author Mohda
 */
public class AffineCipher {
   // a must be coprime with 26 to allow decryption
    public static boolean isValidA(int a) {
        if (gcd(a, 26) == 1) {
            return true;
        } else {
            return false;
        }
    }
 // E(x) = (a*x + b) mod 26
    public static String encrypt(String text, int a, int b) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int x = ch - 'A';
                int y = (a * x + b) % 26;
                ch = (char) (y + 'A');
            } else if (ch >= 'a' && ch <= 'z') {
                int x = ch - 'a';
                int y = (a * x + b) % 26;
                ch = (char) (y + 'a');
            }

            result = result + ch;
        }

        return result;
    }
// D(y) = a_inverse * (y - b) mod 26
    public static String decrypt(String text, int a, int b) {
        String result = "";
        int aInverse = modInverse(a, 26);

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int y = ch - 'A';   
                int x = (aInverse * (y - b + 26)) % 26; // +26 to avoid negative mod
                ch = (char) (x + 'A');
            } else if (ch >= 'a' && ch <= 'z') {
                int y = ch - 'a';
                int x = (aInverse * (y - b + 26)) % 26; // +26 to avoid negative mod
                ch = (char) (x + 'a');
            }

            result = result + ch;
        }

        return result;
    }
   // Euclidean algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
 // Brute force modular inverse, works fine for mod 26
    public static int modInverse(int a, int m) {
        a = a % m;

        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }

        return -1;  // invalid a, shouldn't reach here if isValidA() was checked
    }
}
