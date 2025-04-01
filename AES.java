import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class AES {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Generate an AES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            
            keyGenerator.init(128); // AES-128 bit key
            SecretKey secretKey = keyGenerator.generateKey();

            // Create a Cipher for AES encryption and decryption
            Cipher cipher = Cipher.getInstance("AES");

            // Take user input
            System.out.print("Enter text to encrypt: ");
            String plainText = scanner.nextLine();

            // Encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            String decryptedText = new String(decryptedBytes);
            System.out.println("Decrypted Text: " + decryptedText);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}