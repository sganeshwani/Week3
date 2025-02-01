package com.insertionsort;

import java.util.Arrays;

public class SortEmployeeId {
    public static void main(String[] args) {
        // Array of employee IDs to be sorted
        int []employeeId={101,601,456,150,256,760,320,900,875,540};

        // Display the array before sorting
        System.out.println("Employee Id Array Before Sorting: "+ Arrays.toString(employeeId));

        // Call the insertion sort function
        insertionSort(employeeId);

        // Display the array after sorting
        System.out.println("\nEmployee Id Array After Sorting: "+ Arrays.toString(employeeId));
    }

    // Method to perform insertion sort on the array
    private static void insertionSort(int[] employeeId) {
        int n = employeeId.length;

        // Loop through each element in the array starting from the second element
        for (int i = 1; i < n; i++) {
            int j = i - 1; // Previous index
            int key = employeeId[i]; // Current element to be placed correctly

            // Shift elements of the sorted segment to the right to make space for the key
            while (j >= 0 && employeeId[j] > key) {
                employeeId[j + 1] = employeeId[j];
                j--;
            }

            // Insert the key in the correct position
            employeeId[j + 1] = key;
        }
    }
}
