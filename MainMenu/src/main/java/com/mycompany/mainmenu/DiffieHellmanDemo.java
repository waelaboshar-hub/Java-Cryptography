package com.mycompany.mainmenu;

import java.util.Random;

public class DiffieHellmanDemo {
// Check if a number is prime
    public static boolean isPrime(long n) {
        if (n < 2) return false;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
// Fast modular exponentiation: (base^exponent) mod
    public static long powerMod(long base, long exponent, long mod) {
        long result = 1;
        base = base % mod;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }

            exponent = exponent / 2;
            base = (base * base) % mod;
        }

        return result;
    }

    public static void runDemo(long p, long g) {
// p must be prime, g must be in valid range
        if (!isPrime(p)) {
            System.out.println("Error: p must be a prime number.");
            return;
        }

        if (g <= 1 || g >= p) {
            System.out.println("Error: g must be between 1 and p.");
            return;
        }

        Random rand = new Random();

     // Generate random private keys for Alice and Bob
        long alicePrivate = rand.nextInt((int)(p - 2)) + 2;
        long bobPrivate = rand.nextInt((int)(p - 2)) + 2;
    // Public keys: g^private mod p
        long alicePublic = powerMod(g, alicePrivate, p);
        long bobPublic = powerMod(g, bobPrivate, p);
 // Shared secret: each side raises the other's public key to their private key
        long aliceSecret = powerMod(bobPublic, alicePrivate, p);
        long bobSecret = powerMod(alicePublic, bobPrivate, p);

        System.out.println("\n--- Diffie-Hellman Key Exchange ---");
        System.out.println("Public prime (p): " + p);
        System.out.println("Generator (g): " + g);

        System.out.println("\n[Private Keys]");
        System.out.println("Alice private key: " + alicePrivate);
        System.out.println("Bob private key: " + bobPrivate);

        System.out.println("\n[Public Keys]");
        System.out.println("Alice public key: " + alicePublic);
        System.out.println("Bob public key: " + bobPublic);

        System.out.println("\n[Shared Secret]");
        System.out.println("Alice shared secret: " + aliceSecret);
        System.out.println("Bob shared secret: " + bobSecret);
  // Both shared secrets should always match if the math is correct
        if (aliceSecret == bobSecret) {
            System.out.println("Success! Both parties have the same shared secret.");
        } else {
            System.out.println("Error! Shared secrets are not the same.");
        }
    }
}