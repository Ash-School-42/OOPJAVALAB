
/**
 * Name: James Ash
 * Date: 03-31-2026
 * Assignment: 5.2 Application Delivery
 *
 * Main Application Class.
 * This is the main application class for the calculator.
 * It handles:
 * - User input and menu navigation
 * - Calling calculator operations
 * - Displaying results
 * - Exception handling for invalid input and math errors
 *
 * This class demonstrates control structures, exception
 * handling, and object-oriented design.
 **/
import java.util.Scanner;

public class CalculatorApp {

    // Main method - program entry point
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();

        boolean running = true;

        // Program header
        System.out.println("\nJames Ash - Final Calculator Project");

        // Main program loop
        while (running) {
            displayMenu();

            try {
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(input.nextLine());

                switch (choice) {

                    // Arithmetic Operations

                    case 1:
                        double a = getNumber(input, "Enter first number: ");
                        double b = getNumber(input, "Enter second number: ");
                        System.out.println("Result: " + calc.add(a, b));
                        break;

                    case 2:
                        a = getNumber(input, "Enter first number: ");
                        b = getNumber(input, "Enter second number: ");
                        System.out.println("Result: " + calc.subtract(a, b));
                        break;

                    case 3:
                        a = getNumber(input, "Enter first number: ");
                        b = getNumber(input, "Enter second number: ");
                        System.out.println("Result: " + calc.multiply(a, b));
                        break;

                    case 4:
                        a = getNumber(input, "Enter first number: ");
                        b = getNumber(input, "Enter second number: ");
                        System.out.println("Result: " + calc.divide(a, b));
                        break;

                    // Single Memory

                    case 5:
                        double value = getNumber(input, "Enter value to store: ");
                        calc.storeSingle(value);
                        System.out.println("Value stored in single memory.");
                        break;

                    case 6:
                        System.out.println("Stored value: " + calc.retrieveSingle());
                        break;

                    case 7:
                        calc.clearSingle();
                        System.out.println("Single memory cleared.");
                        break;

                    // Collection Memory

                    case 8:
                        value = getNumber(input, "Enter value to add to list: ");
                        calc.addToMemoryList(value);
                        System.out.println("Value added to memory list.");
                        break;

                    case 9:
                        System.out.println("Memory List: " + calc.getMemoryList());
                        break;

                    case 10:
                        System.out.println("Sum: " + calc.sumMemory());
                        break;

                    case 11:
                        System.out.println("Average: " + calc.averageMemory());
                        break;

                    case 12:
                        System.out.println("Difference: " + calc.differenceFirstLast());
                        break;

                    // Exit

                    case 0:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                // Catches invalid numbers and arithmetic errors
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

        // Closing message
        System.out.println("Thank you for using the calculator. Goodbye!");
        input.close();
    }

    // Displays calculator menu options
    private static void displayMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Store Single Memory");
        System.out.println("6. Retrieve Single Memory");
        System.out.println("7. Clear Single Memory");
        System.out.println("8. Add to Memory List");
        System.out.println("9. Display Memory List");
        System.out.println("10. Sum Memory List");
        System.out.println("11. Average Memory List");
        System.out.println("12. Difference First-Last");
        System.out.println("0. Exit");
    }

    // Safely retrieves a numeric value from the user
    // and prevents crashes from invalid input.
    private static double getNumber(Scanner input, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}