import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class acceso {

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        byte[] hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // digest() method called to calculate message digest of an input
            hash = md.digest(input.getBytes(StandardCharsets.UTF_8));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return hash;
    }

    public static String hexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
        // Convert message digest int hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    public static void main(String[] args) {

    }
}
