package com.problem3;

public class StringConcatenation {
    public static void main(String[] args) {
        int N = 100000; // Number of concatenations

        System.out.println("Comparing String, StringBuilder, and StringBuffer performance");

        // Using String
        long startTime = System.nanoTime();
        String string = "";
        for (int i = 0; i < N; i++) {
            string += "a";  // Creates a new object each time
        }
        long endTime = System.nanoTime();
        double stringPerformance = (endTime - startTime) / 1e6;
        System.out.println("Time taken by String: " + stringPerformance  + " ms");

        // Using StringBuilder
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        double stringBuilderPerformance = (endTime - startTime) / 1e6;
        System.out.println("Time taken by StringBuilder: " + stringBuilderPerformance+ " ms");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        endTime = System.nanoTime();
        double stringBufferPerformance = (endTime - startTime) / 1e6;
        System.out.println("Time taken by StringBuffer: " + stringBufferPerformance + " ms");

        if (stringPerformance < stringBufferPerformance && stringPerformance < stringBuilderPerformance) {
            System.out.println("String was the fastest.");
        } else if (stringBufferPerformance < stringPerformance && stringBufferPerformance < stringBuilderPerformance) {
            System.out.println("String buffer was the fastest.");
        } else {
            System.out.println("String Builder was the fastest.");
        }
        System.out.println("---*---*---*---*---*---*---*---*---*---");
    }
}
