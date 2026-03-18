/**
 * Name: James Ash
 * Date: 3-17-2026
 * Assignment: 3.2 Arrays and Lists
 * 
 * Description: This program demonstrates a calculator memory system
 * that stores single and multiple integer values.
 **/

import java.util.ArrayList;
import java.util.Scanner;

public class MemoryCalculator {

    // Single memory value
    private static Integer memoryValue = null;

    // Collection memory (max 10 values)
    private static ArrayList<Integer> memoryList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Step 1: Informative line
        System.out.println("=== Week 3 Project: Memory Calculator ===");
        System.out.println("Author: James Ash\n");

        // Step 2: Welcome message
        System.out.println("Welcome! This program allows you to store and manage numbers in memory.");
        System.out.println("You can store a single value or up to 10 integers.");
        System.out.println("Use the menu to perform operations.\n");

        // Main loop
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    storeSingleValue(scanner);
                    break;
                case 2:
                    retrieveSingleValue();
                    break;
                case 3:
                    clearSingleValue();
                    break;
                case 4:
                    replaceSingleValue(scanner);
                    break;
                case 5:
                    addToCollection(scanner);
                    break;
                case 6:
                    displayCollection();
                    break;
                case 7:
                    displayCount();
                    break;
                case 8:
                    removeValue(scanner);
                    break;
                case 9:
                    sumValues();
                    break;
                case 10:
                    averageValues();
                    break;
                case 11:
                    differenceFirstLast();
                    break;
                case 0:
                    System.out.println("\nThank you for using the Memory Calculator!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    /**
     * Displays the menu options
     **/
    public static void displayMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Store single value");
        System.out.println("2. Retrieve single value");
        System.out.println("3. Clear single value");
        System.out.println("4. Replace single value");
        System.out.println("5. Add value to collection");
        System.out.println("6. Display all values");
        System.out.println("7. Display count");
        System.out.println("8. Remove a value");
        System.out.println("9. Sum of values");
        System.out.println("10. Average of values");
        System.out.println("11. Difference (first - last)");
        System.out.println("0. Quit");
    }

    /**
     * Stores a single numeric value
     **/
    public static void storeSingleValue(Scanner scanner) {
        System.out.print("Enter a number to store: ");
        memoryValue = scanner.nextInt();
        System.out.println("Value stored.");
    }

    /**
     * Retrieves the stored single value
     **/
    public static void retrieveSingleValue() {
        if (memoryValue != null) {
            System.out.println("Stored value: " + memoryValue);
        } else {
            System.out.println("No value stored.");
        }
    }

    /**
     * Clears the stored value
     **/
    public static void clearSingleValue() {
        memoryValue = null;
        System.out.println("Memory cleared.");
    }

    /**
     * Replaces the stored value
     **/
    public static void replaceSingleValue(Scanner scanner) {
        if (memoryValue != null) {
            System.out.print("Enter new value: ");
            memoryValue = scanner.nextInt();
            System.out.println("Value replaced.");
        } else {
            System.out.println("No value to replace.");
        }
    }

    /**
     * Adds a value to the collection (max 10)
     **/
    public static void addToCollection(Scanner scanner) {
        if (memoryList.size() < 10) {
            System.out.print("Enter value to add: ");
            int value = scanner.nextInt();
            memoryList.add(value);
            System.out.println("Value added.");
        } else {
            System.out.println("Collection is full (max 10 values).");
        }
    }

    /**
     * Displays all values in the collection
     **/
    public static void displayCollection() {
        if (memoryList.isEmpty()) {
            System.out.println("Collection is empty.");
        } else {
            System.out.println("Values: " + memoryList);
        }
    }

    /**
     * Displays count of values
     **/
    public static void displayCount() {
        System.out.println("Count: " + memoryList.size());
    }

    /**
     * Removes a specific value
     **/
    public static void removeValue(Scanner scanner) {
        System.out.print("Enter value to remove: ");
        int value = scanner.nextInt();

        if (memoryList.remove(Integer.valueOf(value))) {
            System.out.println("Value removed.");
        } else {
            System.out.println("Value not found.");
        }
    }

    /**
     * Calculates sum of values
     **/
    public static void sumValues() {
        int sum = 0;
        for (int num : memoryList) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
    }

    /**
     * Calculates average of values
     **/
    public static void averageValues() {
        if (memoryList.isEmpty()) {
            System.out.println("No values to average.");
            return;
        }

        int sum = 0;
        for (int num : memoryList) {
            sum += num;
        }

        double avg = (double) sum / memoryList.size();
        System.out.println("Average: " + avg);
    }

    /**
     * Calculates difference between first and last values
     **/
    public static void differenceFirstLast() {
        if (memoryList.size() < 2) {
            System.out.println("Need at least 2 values.");
            return;
        }

        int first = memoryList.get(0);
        int last = memoryList.get(memoryList.size() - 1);
        System.out.println("Difference (first - last): " + (first - last));
    }
}