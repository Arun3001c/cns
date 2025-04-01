import java.lang.*;
import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Scanner;

public class DSS{
    public static void main(String[] args) throws Exception {
       
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text to sign: ");
        String msg = sc.nextLine();

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privKey = pair.getPrivate();
        PublicKey pubKey = pair.getPublic();

        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privKey);
        sign.update(msg.getBytes());

        byte[] signature = sign.sign();
        System.out.println("\nGenerated Digital Signature:");
        for (byte b : signature) {
            System.out.printf("%02x", b);
        }
        System.out.println();

       
        sign.initVerify(pubKey);
        sign.update(msg.getBytes());
        boolean isValid = sign.verify(signature);
        System.out.println(isValid ? "\nSignature verified successfully." : "\nSignature verification failed.");

        sc.close();
    }
}