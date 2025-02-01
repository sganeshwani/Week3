package com.quicksort;

import java.util.Arrays;

public class SortProductPrice {
    public static void main(String[] args) {
        // Array of product prices to be sorted
        int []productPrice={20,120,45,60,80,25,750,500,180,999,10};
        int n = productPrice.length;

        // Display the product prices before sorting
        System.out.println("Product Price Array Before Sorting: " + Arrays.toString(productPrice));

        // Call quick sort function to sort the product prices
        quickSort(productPrice, 0, n - 1);

        // Display the product prices after sorting
        System.out.println("Product Price Array After Sorting: " + Arrays.toString(productPrice));
    }

    // Recursive method to perform quick sort
    private static void quickSort(int[] productPrice, int left, int right) {
        if (left < right) {
            // Partition the array and get the pivot index
            int part = partition(productPrice, left, right);

            // Recursively sort the left sub array
            quickSort(productPrice, left, part - 1);

            // Recursively sort the right sub array
            quickSort(productPrice, part + 1, right);
        }
    }

    // Method to partition the array and return the pivot index
    private static int partition(int[] productPrice, int left, int right) {
        int pivot = productPrice[right]; // Choosing the rightmost element as the pivot
        int i = left - 1; // Index of smaller element

        // Traverse through the array and rearrange elements based on the pivot
        for (int j = left; j < right; j++) {
            if (productPrice[j] < pivot) {
                // Swap elements to ensure smaller elements are on the left
                int temp = productPrice[j];
                productPrice[j] = productPrice[i + 1];
                productPrice[i + 1] = temp;
                i++;
            }
        }

        // Swap the pivot element to its correct position
        int temp = productPrice[i + 1];
        productPrice[i + 1] = productPrice[right];
        productPrice[right] = temp;

        return i + 1; // Return the partition index
    }
}
