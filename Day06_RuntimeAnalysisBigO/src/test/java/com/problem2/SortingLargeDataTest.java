package com.problem2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

class SortingLargeDataTest {

    @Test
    void testBubbleSort() {
        int[] arr = {5, 3, 8, 6, 2, 7, 4, 1};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        SortingLargeData.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Bubble Sort should correctly sort the array.");
    }

    @Test
    void testMergeSort() {
        int[] arr = {10, -5, 2, 8, 3, 7, 1, 4};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        SortingLargeData.mergeSort(arr);
        assertArrayEquals(expected, arr, "Merge Sort should correctly sort the array.");
    }

    @Test
    void testQuickSort() {
        int[] arr = {9, 7, 5, 3, 1, 2, 4, 6, 8};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        SortingLargeData.quickSort(arr);
        assertArrayEquals(expected, arr, "Quick Sort should correctly sort the array.");
    }

    @Test
    void testPerformanceComparison() {
        int N = 10000;
        Random random = new Random();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(N);
        }

        int[] arrBubble = arr.clone();
        int[] arrMerge = arr.clone();
        int[] arrQuick = arr.clone();

        double bubbleTime = SortingLargeData.bubbleSort(arrBubble);
        double mergeTime = SortingLargeData.mergeSort(arrMerge);
        double quickTime = SortingLargeData.quickSort(arrQuick);

        assertAll(
                () -> assertTrue(bubbleTime > mergeTime, "Merge Sort should be faster than Bubble Sort."),
                () -> assertTrue(bubbleTime > quickTime, "Quick Sort should be faster than Bubble Sort.")
        );
    }
}



