package com.problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class SearchTargetTest {

    @Test
    public void testBinarySearchFasterThanLinearSearch() {
        int N = 1000000; // Large dataset
        int[] arr = new int[N];

        Random random = new Random();

        // Fill array with random values
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(N);
        }

        int target = 1000; // Target value

        // Measure Linear Search Time
        long startTime = System.nanoTime();
        SearchTarget.LinearSearch(arr, target);
        long linearTime = System.nanoTime() - startTime;

        // Sort array for Binary Search
        Arrays.sort(arr);

        // Measure Binary Search Time
        startTime = System.nanoTime();
        SearchTarget.BinarySearch(arr, target);
        long binaryTime = System.nanoTime() - startTime;

        // Expected: Binary search should be faster
        assertTrue(binaryTime < linearTime, "Expected: Binary Search is faster");
    }
}

