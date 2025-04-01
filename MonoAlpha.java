import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MonoAlpha {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Map<Character, Character> encryptMap = new HashMap<>();
    private static Map<Character, Character> decryptMap = new HashMap<>();

    public static void main(String[] args) {
        // Generate a random substitution cipher
        generateCipher();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to encrypt:");
        String plaintext = scanner.nextLine().toUpperCase();
        String ciphertext = encrypt(plaintext);
        System.out.println("Encrypted Text: " + ciphertext);

       
        String textToDecrypt = ciphertext; // Removed the extraneous backtick
        String decryptedText = decrypt(textToDecrypt);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }

    private static void generateCipher() {
        String shuffledAlphabet = "QWERTYUIOPASDFGHJKLZXCVBNM"; // Example substitution alphabet

        for (int i = 0; i < ALPHABET.length(); i++) {
            encryptMap.put(ALPHABET.charAt(i), shuffledAlphabet.charAt(i));
            decryptMap.put(shuffledAlphabet.charAt(i), ALPHABET.charAt(i));
        }
    }

    private static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            if (encryptMap.containsKey(ch)) {
                ciphertext.append(encryptMap.get(ch));
            } else {
                ciphertext.append(ch); // Non-alphabet characters remain unchanged
            }
        }
        return ciphertext.toString();
    }

    private static String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (char ch : ciphertext.toCharArray()) {
            if (decryptMap.containsKey(ch)) {
                plaintext.append(decryptMap.get(ch));
            } else {
                plaintext.append(ch); // Non-alphabet characters remain unchanged
            }
        }
        return plaintext.toString();
    }
}
