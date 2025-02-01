package com.bubblesort;

import java.util.Arrays;

public class SortStudentMarks {

    // Bubble Sort method to sort an array in ascending order
    private static void bubbleSort(int []arr) {
        int n = arr.length;

        // Loop for multiple passes
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;

            // Compare adjacent elements and swap if needed
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }

            // If no swaps, array is already sorted
            if (!flag) break;
        }
    }

    public static void main(String[] args) {
        int []marks = {34, 94, 65, 67, 56, 76, 45, 88};

        // Print marks before sorting
        System.out.println("Marks before sorting: " + Arrays.toString(marks));

        // Sort marks using Bubble Sort
        bubbleSort(marks);

        // Print marks after sorting
        System.out.println("Marks after sorting: " + Arrays.toString(marks));
    }
}