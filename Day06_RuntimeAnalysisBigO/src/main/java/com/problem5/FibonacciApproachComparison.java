package com.problem5;

public class FibonacciApproachComparison {

    // Recursive Fibonacci with correct timing
    public static double fibonacciRecursive(int n) {
        long startTime = System.nanoTime();
        int result = recursiveHelper(n);
        long endTime = System.nanoTime();
        return (endTime - startTime)/1e6; // Convert to milliseconds
    }

    // Helper method for recursive Fibonacci
    private static int recursiveHelper(int n) {
        if (n <= 1) return n;
        // Recursive calls to calculate Fibonacci
        return recursiveHelper(n - 1) + recursiveHelper(n - 2);
    }

    // Iterative Fibonacci
    public static double fibonacciIterative(int n) {
        long startTime = System.nanoTime();
        if (n <= 1) return 0; // Fibonacci(0) = 0, Fibonacci(1) = 1

        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b; // Sum of last two Fibonacci numbers
            a = b; // Move a to b
            b = sum; // Update b to new Fibonacci number
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1e6;
    }

    // Comparison function
    public static void compare(double iterativeTime, double recursiveTime) {
        System.out.println("Time Taken by Iterative Approach: " + iterativeTime + " ms");
        System.out.println("Time Taken by Recursive Approach: " + recursiveTime + " ms");

        if (iterativeTime <= recursiveTime) {
            System.out.println("Iterative approach is faster.");
        } else {
            System.out.println("Recursive approach is faster.");
        }
        System.out.println("---*---*---*---*---*---*---*---*---");
    }

    public static void main(String[] args) {
        int numberOne = 10;
        int numberTwo = 30;

        // Check fibonacci series for n = 10
        double iterativeTime = fibonacciIterative(numberOne);
        double recursiveTime = fibonacciRecursive(numberOne);
        compare(iterativeTime, recursiveTime);

        // Check fibonacci series for n = 30
        iterativeTime = fibonacciIterative(numberTwo);
        recursiveTime = fibonacciRecursive(numberTwo);
        compare(iterativeTime, recursiveTime);
    }
}
