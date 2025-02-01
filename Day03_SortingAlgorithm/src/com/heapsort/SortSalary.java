package com.heapsort;

import java.util.Arrays;

public class SortSalary {
    public static void main(String[] args) {
        // Array of salaries to be sorted
        int []salary={90000,70000,35000,120000,50000,27000,65000,29000};

        // Display the salary array before sorting
        System.out.println("Salary Array Before Sorting: " + Arrays.toString(salary));

        // Call heap sort function to sort the salaries
        sortSalary(salary);

        // Display the salary array after sorting
        System.out.println("Salary Array After Sorting: " + Arrays.toString(salary));
    }

    // Method to perform heap sort on the salary array
    private static void sortSalary(int[] salary) {
        int n = salary.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salary, i, n);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Swap root (max element) with the last element
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            // Heapify the reduced heap
            heapify(salary, 0, i);
        }
    }

    // Method to heapify a subtree rooted at index i
    private static void heapify(int[] salary, int i, int n) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int parent = i;

        // Check if left child is larger than root
        if (leftChild < n && salary[leftChild] > salary[parent]) {
            parent = leftChild;
        }

        // Check if right child is larger than the current largest
        if (rightChild < n && salary[rightChild] > salary[parent]) {
            parent = rightChild;
        }

        // If the largest is not root, swap and continue heapifying
        if (parent != i) {
            int temp = salary[i];
            salary[i] = salary[parent];
            salary[parent] = temp;

            // Recursively heapify the affected subtree
            heapify(salary, parent, n);
        }
    }
}
