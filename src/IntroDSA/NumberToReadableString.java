import java.util.Scanner;

public class NumberToReadableString {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        // Close the scanner to prevent resource leaks
        scanner.close();

        // Convert the number to a human-readable string
        String result = convertToHumanReadable(number);

        // Display the result
        System.out.println("Human Readable Format: " + result);
    }

    private static String convertToHumanReadable(long number) {
        // Array to store the suffixes for each power of 10
        String[] suffixes = {"", "th", "L", "Cr", "Ar", "Ab"};

        // Determine the magnitude of the number
        int magnitude = (int) Math.log10(number) / 3;

        // Calculate the index for the appropriate suffix
        int suffixIndex = Math.min(magnitude, suffixes.length - 1);

        // Calculate the scaled value (number divided by 10^3 to the power of magnitude)
        double scaledValue = number / Math.pow(10, magnitude * 3);

        // Format the result as a string
        return String.format("%.2f %s", scaledValue, suffixes[suffixIndex]);
    }
}
