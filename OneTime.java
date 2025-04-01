import java.util.Scanner;

public class OneTime{

    public static String stringEncryption(String text, String key) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            char currentKeyChar = key.charAt(i % key.length());

            // Encrypt only alphabetic characters
            if (Character.isLetter(currentChar)) {
                // Normalize to uppercase for calculations
                char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                char baseKey = Character.isUpperCase(currentKeyChar) ? 'A' : 'a';

                // Encrypt
                char encryptedChar = (char) (((currentChar - base + (currentKeyChar - baseKey)) % 26) + base);
                cipherText.append(encryptedChar);
            } else {
                // Keep non-alphabetic characters unchanged
                cipherText.append(currentChar);
            }
        }

        return cipherText.toString();
    }
    

    public static String stringDecryption(String cipherText, String key) {
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char currentChar = cipherText.charAt(i);
            char currentKeyChar = key.charAt(i % key.length());

            // Decrypt only alphabetic characters
            if (Character.isLetter(currentChar)) {
                // Normalize to uppercase for calculations
                char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                char baseKey = Character.isUpperCase(currentKeyChar) ? 'A' : 'a';

                // Decrypt
                char decryptedChar = (char) (((currentChar - base - (currentKeyChar - baseKey) + 26) % 26) + base);
                plainText.append(decryptedChar);
            } else {
                // Keep non-alphabetic characters unchanged
                plainText.append(currentChar);
            }
        }

        return plainText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String plainText = scanner.nextLine();
        System.out.print("Enter key (same length as text): ");
        String key = scanner.nextLine();

        // Ensure the key length matches the plaintext length
        if (key.length() < plainText.length()) {
            System.out.println("Error: Key must be at least as long as the plain text.");
            return;
        }

        String encryptedText = stringEncryption(plainText, key);
        System.out.println("Cipher Text: " + encryptedText);

        String decryptedText = stringDecryption(encryptedText, key);
        System.out.println("Decrypted Text: " + decryptedText);
        
        scanner.close();
    }
}

