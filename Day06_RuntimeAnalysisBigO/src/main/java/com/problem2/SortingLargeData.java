package com.problem2;

import java.util.Random;

public class SortingLargeData {
    // Bubble Sort
    public static double bubbleSort(int[] array) {
        long startTime = System.nanoTime();
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;  // Reset swapped flag at the start of each pass
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;  // Stop early if no swaps were made
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;  // Convert to milliseconds
    }

    // Merge Sort
    public static double mergeSort(int[] arr) {
        long startTime = System.nanoTime();
        mergeSortHelper(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    // Merge Sort Recursive Function
    public static void mergeSortHelper(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSortHelper(arr, si, mid);
        mergeSortHelper(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    // Merge Function
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    // Quick Sort
    public static double quickSort(int[] arr) {
        long startTime = System.nanoTime();
        quickSortHelper(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    // Quick Sort Recursive Function
    public static void quickSortHelper(int arr[], int start, int end) {
        if (start >= end) return;
        int pivotIndex = partition(arr, start, end);
        quickSortHelper(arr, start, pivotIndex - 1);
        quickSortHelper(arr, pivotIndex + 1, end);
    }

    // Partition Function
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int idx = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                idx++;
                int temp = arr[idx];
                arr[idx] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[idx + 1];
        arr[idx + 1] = arr[high];
        arr[high] = temp;
        return idx + 1;
    }

    // Comparison Function
    public static void compare(double bubbleTime, double mergeTime, double quickTime) {
        System.out.println("Comparison of Sorting Algorithms:");
        System.out.println("Time taken by Bubble Sort : " + bubbleTime + " ms");
        System.out.println("Time taken by Merge Sort: " + mergeTime + " ms");
        System.out.println("Time taken by Quick Sort: " + quickTime + " ms");

        if (bubbleTime < mergeTime && bubbleTime < quickTime) {
            System.out.println("Bubble Sort was the fastest.");
        } else if (mergeTime < bubbleTime && mergeTime < quickTime) {
            System.out.println("Merge Sort was the fastest.");
        } else {
            System.out.println("Quick Sort was the fastest.");
        }
        System.out.println("---*---*---*---*---*---*---*---*---*---");
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000};
        Random random = new Random();

        for (int N : sizes) {
            int[] arr = new int[N];

            // Fill array with random values
            for (int i = 0; i < N; i++) {
                arr[i] = random.nextInt(N);
            }

            // Create copies to ensure same input for each sorting algorithm
            int[] arrBubble = arr.clone();
            int[] arrMerge = arr.clone();
            int[] arrQuick = arr.clone();

            System.out.println("Data Size: " + N);

            double bubbleTime = bubbleSort(arrBubble);
            double mergeTime = mergeSort(arrMerge);
            double quickTime = quickSort(arrQuick);

            compare(bubbleTime, mergeTime, quickTime);
        }
    }
}
