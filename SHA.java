import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA {
    public static void main(String[] args) {
        // Accepting dynamic input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text to generate SHA-256 hash: ");
        String input = sc.nextLine();

        try {
            // Creating MessageDigest instance for SHA-256
            MessageDigest hash = MessageDigest.getInstance("SHA-256");

            // Calculating message digest of input
            byte[] messageDigest = hash.digest(input.getBytes());

            // Converting byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Converting message digest into hexadecimal format
            String hashtext = no.toString(16);

            // Padding with leading zeros to make it 64 characters
            while (hashtext.length() < 64) {
                hashtext = "0" + hashtext;
            }

            // Displaying the generated hash code
            System.out.println("Generated SHA-256 Hash: " + hashtext);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}
