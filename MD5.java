import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to generate MD5 hash: ");
        String input = scanner.nextLine();

        try {
            // Create MD5 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Generate MD5 digest for the input string
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert the byte array into a BigInteger
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert the BigInteger to hex format
            String hashtext = no.toString(16);

            // Pad with leading zeros to ensure 32-character length
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            System.out.println("Generated MD5 hash: " + hashtext);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        scanner.close();
    }
}
