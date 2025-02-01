package com.countingsort;

import java.util.Arrays;

public class SortAges {
    public static void main(String[] args) {
        // Array containing ages of students
        int []ages = {10,18,12,11,14,15,16,11,12,13,14,15,16,10,18,11};

        // Display ages before sorting
        System.out.println("Student ages before sorting: " + Arrays.toString(ages));

        // Perform Counting Sort
        countSort(ages);

        // Display ages after sorting
        System.out.println("Student ages after sorting: " + Arrays.toString(ages));
    }

    private static void countSort(int[] ages) {
        int []count = new int[19]; // Count array for age frequency
        int len = count.length;

        // Count occurrences of each age
        for (int age : ages) {
            count[age]++;
        }

        // Compute cumulative counts
        for (int i = 10; i < len; i++) {
            count[i] += count[i - 1];
        }

        // Create result array for sorted ages
        int []result = new int[ages.length];

        // Place elements in sorted order (maintains stability)
        for (int i = ages.length - 1; i >= 0; i--) {
            result[count[ages[i]] - 1] = ages[i];
            count[ages[i]]--;
        }

        // Copy sorted values back to original array
        System.arraycopy(result, 0, ages, 0, result.length);
    }
}