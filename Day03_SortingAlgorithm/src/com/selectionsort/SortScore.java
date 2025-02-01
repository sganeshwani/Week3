package com.selectionsort;

import java.util.Arrays;

public class SortScore {
    public static void main(String[] args) {
        // Array of student scores to be sorted
        int []score={56,78,98,99,45,65,12,34,56,70};

        // Display the scores before sorting
        System.out.println("Student Score Array Before sorting: " + Arrays.toString(score));

        // Call selection sort function to sort the scores
        selectionSort(score);

        // Display the scores after sorting
        System.out.println("Student Score Array After sorting: " + Arrays.toString(score));
    }

    // Method to perform selection sort on the array
    private static void selectionSort(int[] score) {
        int n = score.length;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Iterate through the remaining elements to find the smallest value
            for (int j = i + 1; j < n; j++) {
                if (score[i] > score[j]) {
                    // Swap the elements to place the smallest value at the correct position
                    int temp = score[i];
                    score[i] = score[j];
                    score[j] = temp;
                }
            }
        }
    }
}
