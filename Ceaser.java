import java.lang.*;
import java.util.*;

class Ceaser{  // Change class name to Main
    public static StringBuffer encrypt(String text, int s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                // Shift uppercase letters
                ch = (char) (((int) ch + s - 65) % 26 + 65);
            } else if (Character.isLowerCase(ch)) {
                // Shift lowercase letters
                ch = (char) (((int) ch + s - 97) % 26 + 97);
            }
            // Non-alphabetic characters remain unchanged
            result.append(ch);
        }
        return result;
    }

     public static StringBuffer decrypt(String text, int s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = (char) (((int) ch - s - 65 + 26) % 26 + 65); // Add 26 to ensure positive result
            } else if (Character.isLowerCase(ch)) {
                ch = (char) (((int) ch - s - 97 + 26) % 26 + 97); // Add 26 to ensure positive result
            }
            result.append(ch);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String plainText = scanner.nextLine();
        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();
        
        // Ensure the shift value is within the valid range
        shift = shift % 26; // Handle shifts greater than 26
        String cipherText = encrypt(plainText, shift).toString(); // Convert StringBuffer to String
        
        System.out.println("Plain Text: " + plainText);
        System.out.println("Cipher Text: " + cipherText);
         String decryptedText = decrypt(cipherText, shift).toString();
        System.out.println("Decrypted Text: " + decryptedText);
        scanner.close();
    }
}

