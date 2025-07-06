import java.util.Scanner;

public class CaesarCipher {

    // Encrypt method
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) ((c - 'A' + shift) % 26 + 'A');
                encrypted.append(shifted);
            } else {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    // Decrypt method
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter the Message: ");
        String message = scanner.nextLine();

        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();

        // Encrypt and Decrypt
        String encrypted = encrypt(message, shift);
        String decrypted = decrypt(encrypted, shift);

        // Display results
        System.out.println("\nEncrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);

        scanner.close();
    }
}
