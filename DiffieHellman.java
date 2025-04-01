import java.math.BigInteger;
import java.util.Scanner;

public class DiffieHellman {

    // Function to compute base^expo mod p using BigInteger
    private static BigInteger power(BigInteger base, BigInteger expo, BigInteger p) {
        return base.modPow(expo, p);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take the prime number p and primitive root g as input from the user
        System.out.print("Enter the prime number p: ");
        BigInteger p = new BigInteger(scanner.nextLine());

        System.out.print("Enter the primitive root g: ");
        BigInteger g = new BigInteger(scanner.nextLine());

        // Alice's private key
        System.out.print("Enter Alice's private key (a): ");
        BigInteger a = new BigInteger(scanner.nextLine());

        // Bob's private key
        System.out.print("Enter Bob's private key (b): ");
        BigInteger b = new BigInteger(scanner.nextLine());

        // Alice computes her public key A = g^a mod p
        BigInteger A = power(g, a, p);
        System.out.println("Alice's public key A: " + A);

        // Bob computes his public key B = g^b mod p
        BigInteger B = power(g, b, p);
        System.out.println("Bob's public key B: " + B);

        // Alice and Bob exchange public keys
        // Alice computes the shared secret key using Bob's public key B
        BigInteger keyAlice = power(B, a, p);
        System.out.println("Alice's computed shared secret key: " + keyAlice);

        // Bob computes the shared secret key using Alice's public key A
        BigInteger keyBob = power(A, b, p);
        System.out.println("Bob's computed shared secret key: " + keyBob);

        // Verify if both keys are the same
        if (keyAlice.equals(keyBob)) {
            System.out.println("The Diffie-Hellman key exchange was successful. Shared key: " + keyAlice);
        } else {
            System.out.println("Error: The shared keys do not match.");
        }

        scanner.close();
    }
}

