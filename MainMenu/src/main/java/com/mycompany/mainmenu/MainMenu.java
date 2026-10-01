package com.mycompany.mainmenu;

import java.util.Scanner;
import java.security.KeyPair;

public class MainMenu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        KeyPair pair = null;

        try {
            pair = RSACipher.generateKeyPair();
        } catch (Exception e) {
            System.out.println("RSA key generation failed: " + e.getMessage());
        }

        do {
            System.out.println("\n===== Cryptography Project Menu =====");
            System.out.println("1. Caesar Cipher");
            System.out.println("2. Shift Cipher");
            System.out.println("3. Affine Cipher");
            System.out.println("4. Block Cipher (AES)");
            System.out.println("5. Diffie-Hellman Key Exchange");
            System.out.println("6. RSA Encryption/Decryption");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                int action;
                System.out.println("\n--- Caesar Cipher ---");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");
                System.out.print("Enter your choice: ");
                action = input.nextInt();
                input.nextLine();

                System.out.print("Enter message: ");
                String message = input.nextLine();

                if (action == 1) {
                    String encrypted = CaesarCipher.encrypt(message);
                    System.out.println("Encrypted message: " + encrypted);
                } else if (action == 2) {
                    String decrypted = CaesarCipher.decrypt(message);
                    System.out.println("Decrypted message: " + decrypted);
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            else if (choice == 2) {
                int action;
                System.out.println("\n--- Shift Cipher ---");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");
                System.out.print("Enter your choice: ");
                action = input.nextInt();

                System.out.print("Enter key (0-25): ");
                int key = input.nextInt();
                input.nextLine();

                System.out.print("Enter message: ");
                String message = input.nextLine();

                if (action == 1) {
                    String encrypted = ShiftCipher.encrypt(message, key);
                    System.out.println("Encrypted message: " + encrypted);
                } else if (action == 2) {
                    String decrypted = ShiftCipher.decrypt(message, key);
                    System.out.println("Decrypted message: " + decrypted);
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            else if (choice == 3) {
                int action;
                int a;
                int b;

                System.out.println("\n--- Affine Cipher ---");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");
                System.out.print("Enter your choice: ");
                action = input.nextInt();

                do {
                    System.out.print("Enter key a: ");
                    a = input.nextInt();

                    if (!AffineCipher.isValidA(a)) {
                        System.out.println("Error: a must be coprime with 26.");
                    }

                } while (!AffineCipher.isValidA(a));

                System.out.print("Enter key b: ");
                b = input.nextInt();
                input.nextLine();

                System.out.print("Enter message: ");
                String message = input.nextLine();

                if (action == 1) {
                    String encrypted = AffineCipher.encrypt(message, a, b);
                    System.out.println("Encrypted message: " + encrypted);
                } else if (action == 2) {
                    String decrypted = AffineCipher.decrypt(message, a, b);
                    System.out.println("Decrypted message: " + decrypted);
                } else {
                    System.out.println("Invalid choice.");
                }
            }

            else if (choice == 4) {
                int action;
                System.out.println("\n--- Block Cipher (AES) ---");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");
                System.out.print("Enter your choice: ");
                action = input.nextInt();
                input.nextLine();

                try {
                    System.out.print("Enter secret key: ");
                    String key = input.nextLine();

                    System.out.print("Enter message: ");
                    String message = input.nextLine();

                    if (action == 1) {
                        String encrypted = BlockCipherAES.encrypt(message, key);
                        System.out.println("Encrypted message: " + encrypted);
                    } else if (action == 2) {
                        String decrypted = BlockCipherAES.decrypt(message, key);
                        System.out.println("Decrypted message: " + decrypted);
                    } else {
                        System.out.println("Invalid choice.");
                    }

                } catch (Exception e) {
                    System.out.println("Error in AES: " + e.getMessage());
                }
            }

            else if (choice == 5) {
    System.out.println("\n--- Diffie-Hellman Key Exchange ---");

    System.out.print("Enter public prime p: ");
    long p = input.nextLong();

    System.out.print("Enter generator g: ");
    long g = input.nextLong();
    input.nextLine();

    DiffieHellmanDemo.runDemo(p, g);
}

            else if (choice == 6) {
                int action;
                System.out.println("\n--- RSA Encryption/Decryption ---");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");
                System.out.print("Enter your choice: ");
                action = input.nextInt();
                input.nextLine();

                try {
                    if (action == 1) {
                        System.out.print("Enter message: ");
                        String message = input.nextLine();

                        String encrypted = RSACipher.encrypt(message, pair.getPublic());
                        System.out.println("Encrypted message: " + encrypted);

                    } else if (action == 2) {
                        System.out.print("Enter encrypted message: ");
                        String encryptedMessage = input.nextLine();

                        String decrypted = RSACipher.decrypt(encryptedMessage, pair.getPrivate());
                        System.out.println("Decrypted message: " + decrypted);

                    } else {
                        System.out.println("Invalid choice.");
                    }

                } catch (Exception e) {
                    System.out.println("Error in RSA: " + e.getMessage());
                }
            }

            else if (choice == 7) {
                System.out.println("Program ended.");
            }

            else {
                System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        input.close();
    }
}