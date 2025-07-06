package start;

import java.util.Scanner;

public class PasswordChecker {

    // Method to check the strength of the password
    public static String checkStrength(String password) {
        // Flags to check if password contains required character types
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Check length first
        if (password.length() < 8) {
            return "Weak - Password must be at least 8 characters long.";
        }

        // Check each character in the password
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if ("!@#$%^&*()-_=+[]{}|;:'\",.<>?/\\`~".contains(String.valueOf(ch))) {
                hasSpecial = true;
            }
        }

        // Count how many conditions are met
        int score = 0;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        // Determine strength level based on score
        String strength;
        switch (score) {
            case 4:
                strength = "Very Strong";
                break;
            case 3:
                strength = "Strong";
                break;
            case 2:
                strength = "Medium";
                break;
            default:
                strength = "Weak";
                break;
        }

        return "Password Strength: " + strength;
    }

    // Main method: entry point of the program
    public static void main(String[] args) {
        // Create a Scanner object to read input from user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password to check strength: ");
        String password = scanner.nextLine(); // Read user input

        // Call the method to check strength
        String result = checkStrength(password);

        // Display result
        System.out.println(result);
    }
}
