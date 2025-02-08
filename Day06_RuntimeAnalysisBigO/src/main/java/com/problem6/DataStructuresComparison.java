package com.problem6;

import java.util.*;

public class DataStructuresComparison {

    // Linear Search in an array (O(N))
    public static double searchArray(int[] arr, int target) {
        long startTime = System.nanoTime();
        for (int num : arr) {
            if (num == target) {
                break;
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6; // Convert to milliseconds
    }

    // Search in HashSet (O(1) on average)
    public static double searchHashSet(HashSet<Integer> set, int target) {
        long startTime = System.nanoTime();
        boolean found = set.contains(target);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    // Search in TreeSet (O(log N))
    public static double searchTreeSet(TreeSet<Integer> set, int target) {
        long startTime = System.nanoTime();
        boolean found = set.contains(target);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    // Compare and print results
    public static void compare(double timeArray, double timeHashSet, double timeTreeSet) {
        System.out.println("Array Search (Linear) Time: " + timeArray + " ms");
        System.out.println("HashSet Search (O(1)) Time: " + timeHashSet + " ms");
        System.out.println("TreeSet Search (O(log N)) Time: " + timeTreeSet + " ms");
        System.out.println();

        // Finding the fastest
        double minTime = Math.min(timeArray, Math.min(timeHashSet, timeTreeSet));
        if (minTime == timeHashSet) {
            System.out.println("HashSet is the fastest for searching.");
        } else if (minTime == timeTreeSet) {
            System.out.println("TreeSet is the fastest after HashSet.");
        } else {
            System.out.println("Array (Linear Search) is the slowest.");
        }
        System.out.println("---*---*---*---*---*---*---*---*---*---");
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000}; // Dataset sizes
        Random random = new Random();

        for (int N : sizes) {
            int[] arr = new int[N];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            // Fill structures with random values
            for (int i = 0; i < N; i++) {
                int num = random.nextInt(N);
                arr[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }
            System.out.println("Comparison of Search Algorithms of Size: "+N);

            int target = random.nextInt(N); // Random target to search

            // Measure search times
            double timeArray = searchArray(arr, target);
            double timeHashSet = searchHashSet(hashSet, target);
            double timeTreeSet = searchTreeSet(treeSet, target);

            compare(timeArray, timeHashSet, timeTreeSet);
        }
    }
}
