Java Cryptography Toolkit
A Java command-line cryptography project that demonstrates both classical and modern encryption techniques through a single interactive menu.
The application includes implementations of Caesar Cipher, Shift Cipher, Affine Cipher, AES, Diffie–Hellman key exchange, and RSA encryption/decryption. It is designed as an educational project for learning core cryptography concepts and practicing Java programming.
Features
- Caesar Cipher encryption and decryption
- Shift Cipher with a user-defined key
- Affine Cipher with key validation
- AES symmetric encryption and decryption
- Diffie–Hellman shared-key exchange demonstration
- RSA public-key encryption and private-key decryption
- Base64 encoding for AES and RSA ciphertext
- Interactive command-line menu
- Maven-based Java project structure
Cryptography Methods
Method	Type	Purpose
Caesar Cipher	Classical substitution cipher	Shifts letters by a fixed value of 3
Shift Cipher	Classical substitution cipher	Shifts letters using a user-supplied key
Affine Cipher	Classical substitution cipher	Uses the affine function E(x) = (ax + b) mod 26
AES	Symmetric block cipher	Encrypts and decrypts data using the same secret key
Diffie–Hellman	Key exchange	Demonstrates how two parties can derive the same shared secret
RSA	Asymmetric cryptography	Encrypts with a public key and decrypts with a private key


Project Structure
MainMenu/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── mycompany/
                    └── mainmenu/
                        ├── MainMenu.java
                        ├── CaesarCipher.java
                        ├── ShiftCipher.java
                        ├── AffineCipher.java
                        ├── BlockCipherAES.java
                        ├── DiffieHellmanDemo.java
                        └── RSACipher.java
Main Menu
When the application starts, the following menu is displayed:
===== Cryptography Project Menu =====
1. Caesar Cipher
2. Shift Cipher
3. Affine Cipher
4. Block Cipher (AES)
5. Diffie-Hellman Key Exchange
6. RSA Encryption/Decryption
7. Exit
Cipher Implementations
Caesar Cipher
The Caesar Cipher shifts every alphabetical character by 3 positions.
Encryption:
HELLO → KHOOR
Decryption reverses the same shift.
Uppercase and lowercase letters are handled separately, while non-alphabetic characters remain unchanged.
Shift Cipher
The Shift Cipher is a generalized Caesar Cipher where the user selects the shift key.
For example, using a key of 5:
HELLO → MJQQT
The program supports both encryption and decryption and preserves non-letter characters.
Affine Cipher
The Affine Cipher uses the encryption formula:
E(x) = (a × x + b) mod 26
Decryption uses:
D(y) = a⁻¹ × (y - b) mod 26
For decryption to work, a must be coprime with 26. The program validates this condition using the Euclidean algorithm and calculates the modular inverse of a.
AES Encryption
The project uses Java's javax.crypto.Cipher API to demonstrate AES symmetric encryption.
The supplied key is adjusted to 16 characters, producing a 128-bit AES key. Encrypted binary data is converted into Base64 so it can be displayed as text.
Flow:
Plaintext
   ↓
Secret Key
   ↓
AES Encryption
   ↓
Encrypted Bytes
   ↓
Base64 Ciphertext
The same key must be used for decryption.
Diffie–Hellman Key Exchange
The Diffie–Hellman module demonstrates how two parties, represented as Alice and Bob, can independently calculate the same shared secret.
The user provides:
- A public prime number p
- A generator g
The program then:
1. Validates that p is prime.
2. Generates private keys for Alice and Bob.
3. Calculates their public keys.
4. Exchanges the public values mathematically.
5. Calculates a shared secret for each party.
6. Verifies that both shared secrets match.
The implementation uses fast modular exponentiation to calculate values efficiently.
RSA Encryption
The RSA module generates a 2048-bit RSA key pair when the program starts.
It demonstrates asymmetric encryption using:
- Public key → encryption
- Private key → decryption
Encrypted RSA data is encoded using Base64 before being displayed.
Requirements
- Java 24
- Apache Maven
The Maven configuration uses:
<maven.compiler.release>24</maven.compiler.release>
Running the Project
Clone the repository:
git clone <your-repository-url>
cd MainMenu
Compile the project:
mvn compile
Run the application with Maven:
mvn exec:java
The configured main class is:
com.mycompany.mainmenu.MainMenu
You can also run MainMenu.java directly from an IDE such as IntelliJ IDEA, Apache NetBeans, or Eclipse.
Example Workflow
1. Start the application.
2. Select a cryptography algorithm from the main menu.
3. Choose encryption or decryption when applicable.
4. Enter the required key or parameters.
5. Enter your message.
6. View the resulting plaintext, ciphertext, or generated shared secret.
For example:
===== Cryptography Project Menu =====
1. Caesar Cipher
2. Shift Cipher
3. Affine Cipher
4. Block Cipher (AES)
5. Diffie-Hellman Key Exchange
6. RSA Encryption/Decryption
7. Exit

Enter your choice: 1

--- Caesar Cipher ---
1. Encrypt
2. Decrypt
Enter your choice: 1
Enter message: Hello World
Encrypted message: Khoor Zruog
Concepts Demonstrated
This project demonstrates several important computer science and cybersecurity concepts:
- Classical cryptography
- Symmetric encryption
- Asymmetric encryption
- Public-key cryptography
- Key exchange
- Modular arithmetic
- Modular inverses
- Greatest Common Divisor (GCD)
- Prime number validation
- Fast modular exponentiation
- Base64 encoding
- Java Cryptography Architecture
- Object-oriented programming
- Exception handling
- Console-based application design
- Maven project management
Security Notice
This project is intended for educational and demonstration purposes.
Some implementation choices are intentionally simplified. For example, the AES implementation uses Java's default AES transformation, which commonly resolves to ECB mode with PKCS#5 padding, and user-provided AES keys are padded or truncated to 16 characters. The Diffie–Hellman demonstration also uses small user-supplied numeric values and java.util.Random.
These approaches are useful for learning cryptographic concepts but should not be used to protect sensitive real-world data. Production cryptographic software should use established protocols, secure key derivation, authenticated encryption modes such as AES-GCM, cryptographically secure randomness, appropriate parameter sizes, and professionally reviewed libraries.
Possible Improvements
Future versions could include:
- AES-GCM authenticated encryption
- PBKDF2 or Argon2 password-based key derivation
- Secure random key generation
- Persistent RSA key storage
- Digital signatures
- SHA-256 / SHA-3 hashing demonstrations
- Message authentication codes (HMAC)
- File encryption and decryption
- Graphical user interface
- Automated unit tests
- Better user-input validation
- Secure Diffie–Hellman parameter generation
License
This project is intended for educational and portfolio purposes.
An open-source license such as the MIT License can be added if the repository will be publicly distributed or reused.
