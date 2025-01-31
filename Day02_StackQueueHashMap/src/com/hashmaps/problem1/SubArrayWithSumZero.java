package com.hashmaps.problem1;

import java.util.*;

public class SubArrayWithSumZero {
    public static void main(String[] args) {
        // Define the input array
        int[] arr = new int[]{6, 3, -1, -3, -1, -4, -2, 2};

        // Call the function to find all sub arrays with sum zero
        List<int[]> subArrayList = printSubArrayWithSumZero(arr);

        // Print each zero-sum sub array
        for (int[] subArray : subArrayList) {
            System.out.println(Arrays.toString(subArray));
        }
    }

    //Function to find all sub arrays with a sum of zero.

    private static List<int[]> printSubArrayWithSumZero(int[] arr) {
        // HashMap to store cumulative sum and the list of indices where this sum occurs
        Map<Integer, List<Integer>> map = new HashMap<>();

        // List to store resulting sub arrays
        List<int[]> answer = new ArrayList<>();

        // Initialize map with sum 0 at index -1 (handles cases where sub array starts at index 0)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        int sum = 0;

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update cumulative sum

            // If sum has been seen before, there exists at least one zero-sum sub array
            if (map.containsKey(sum)) {
                for (int index : map.get(sum)) {
                    // Extract the sub array from index+1 to i (zero-sum sub array)
                    answer.add(Arrays.copyOfRange(arr, index + 1, i + 1));
                }
                // Append current index to the list of indices for this sum
                map.get(sum).add(i);
            } else {
                // If sum is not in map, add it with current index
                map.put(sum, new ArrayList<>());
            }
        }
        return answer;
    }
}
