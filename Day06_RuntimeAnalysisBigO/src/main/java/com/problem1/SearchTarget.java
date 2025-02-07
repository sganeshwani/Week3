package com.problem1;

import java.util.*;

public class SearchTarget {
    // Linear Search (O(N))
    public static int LinearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (O(log N))
    public static int BinarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Initialize sizes array for 3 different sizes
        int[] sizes = {1000, 10000, 1000000};
        // Take random variable from Random Class to pick random value
        Random random = new Random();

        for (int N : sizes) {
            int[] arr = new int[N];

            // Fill array with random values
            for (int i = 0; i < N; i++) {
                arr[i] = random.nextInt(N);
            }

            int target = 1000; // Pick a random target

            // Measure Linear Search Time
            long startTime = System.nanoTime();
            LinearSearch(arr, target);
            long linearTime = System.nanoTime() - startTime;

            // Sort array for Binary Search
            Arrays.sort(arr);

            // Measure Binary Search Time
            startTime = System.nanoTime();
            BinarySearch(arr, target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.println("Dataset Size: " + N);

            // Convert time to milliseconds
            System.out.println("Linear Search Time: " + (linearTime / 1e6) + " ms");
            System.out.println("Binary Search Time: " + (binaryTime / 1e6) + " ms");

            // Checking which one is faster by their time
            if (binaryTime > linearTime)
                System.out.println("Linear Search is faster");
            else
                System.out.println("Binary Search is faster");
            System.out.println("---*---*---*---*---*---*---*---");
        }
    }
}
