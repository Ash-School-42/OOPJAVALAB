
/**
 * Name: James Ash
 * Date: 03-31-2026
 * Assignment: 5.2 Application Delivery
 *
 * Calculator Class.
 * Description:
 * This class performs all mathematical operations and manages
 * calculator memory. It supports:
 * - Basic arithmetic (add, subtract, multiply, divide)
 * - Single-value memory storage
 * - Collection memory using ArrayList (max 10 values)
 *
 * This class contains no user input or output logic. It is
 * designed to be called by the main application class.
 **/

import java.util.ArrayList;

public class Calculator {

    // Memory Variables

    // Stores a single memory value
    private Double singleMemory = null;

    // Stores multiple values (up to 10)
    private ArrayList<Double> memoryList = new ArrayList<>();

    // Basic Arithmetic Operations

    // Adds two numbers.
    public double add(double a, double b) {
        return a + b;
    }

    // Subtracts second number from first.
    public double subtract(double a, double b) {
        return a - b;
    }

    // Multiplies two numbers.
    public double multiply(double a, double b) {
        return a * b;
    }

    // Divides first number by second.
    // Throws exception if dividing by zero.
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    // Single Memory Functions

    // Stores a value in single memory.
    public void storeSingle(double value) {
        singleMemory = value;
    }

    // Retrieves stored single value.
    public Double retrieveSingle() {
        return singleMemory;
    }

    // Clears the single memory value.
    public void clearSingle() {
        singleMemory = null;
    }

    // Collection Memory Functions

    // Adds a value to memory list.
    // Maximum of 10 values allowed.
    public void addToMemoryList(double value) {
        if (memoryList.size() < 10) {
            memoryList.add(value);
        } else {
            throw new IllegalStateException("Memory list is full.");
        }
    }

    // Returns all stored memory values.
    public ArrayList<Double> getMemoryList() {
        return memoryList;
    }

    // Removes a specific value from memory list.
    public void removeFromMemory(double value) {
        memoryList.remove(value);
    }

    // Calculates the sum of memory list values.
    public double sumMemory() {
        double sum = 0;
        for (double v : memoryList) {
            sum += v;
        }
        return sum;
    }

    // Calculates the average of memory list values.
    public double averageMemory() {
        if (memoryList.isEmpty()) {
            throw new IllegalStateException("Memory list is empty.");
        }
        return sumMemory() / memoryList.size();
    }

    // Returns difference between first and last values.
    public double differenceFirstLast() {
        if (memoryList.size() < 2) {
            throw new IllegalStateException("Need at least two values.");
        }
        return memoryList.get(0) - memoryList.get(memoryList.size() - 1);
    }
}