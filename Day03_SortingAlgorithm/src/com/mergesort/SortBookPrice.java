package com.mergesort;

import java.util.Arrays;

public class SortBookPrice {
    public static void main(String[] args) {
        // Array of book prices to be sorted
        int []bookPrice={949,759,560,850,500,150,100,250};
        int n = bookPrice.length;

        // Display the book prices before sorting
        System.out.println("Books Price Before Sorting Prices: " + Arrays.toString(bookPrice));

        // Call merge sort function to sort the book prices
        mergeSort(bookPrice, 0, n - 1);

        // Display the book prices after sorting
        System.out.println("Books Price After Sorting Prices: " + Arrays.toString(bookPrice));
    }

    // Recursive method to perform merge sort
    private static void mergeSort(int[] bookPrice, int start, int end) {
        if (start < end) {
            // Find the middle index of the array
            int mid = start + (end - start) / 2;

            // Recursively sort the first half
            mergeSort(bookPrice, start, mid);

            // Recursively sort the second half
            mergeSort(bookPrice, mid + 1, end);

            // Merge the sorted halves
            merge(bookPrice, start, mid, end);
        }
    }

    // Method to merge two sorted sub arrays
    private static void merge(int[] bookPrice, int start, int mid, int end) {
        // Sizes of the two sub arrays
        int n1 = mid - start + 1;
        int n2 = end - mid;

        // Create temporary arrays for left and right sub arrays
        int[] part1 = Arrays.copyOfRange(bookPrice, start, mid + 1);
        int[] part2 = Arrays.copyOfRange(bookPrice, mid + 1, end + 1);

        // Indices for iteration
        int i = 0, j = 0, index = start;

        // Merge the two sub arrays into the original array
        while (i < n1 && j < n2) {
            if (part1[i] < part2[j]) {
                bookPrice[index++] = part1[i++];
            } else {
                bookPrice[index++] = part2[j++];
            }
        }

        // Copy remaining elements of part1, if any
        while (i < n1) {
            bookPrice[index++] = part1[i++];
        }

        // Copy remaining elements of part2, if any
        while (j < n2) {
            bookPrice[index++] = part2[j++];
        }
    }
}
