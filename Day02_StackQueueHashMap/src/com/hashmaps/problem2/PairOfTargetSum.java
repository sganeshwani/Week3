package com.hashmaps.problem2;

import java.util.HashMap;
import java.util.Map;

public class PairOfTargetSum {
    public static void main(String[] args) {
        // Sample array and target sum
        int[] arr = new int[]{2, 3, 4, 2, 4, 1, 7, 8};
        int target = 11;

        // Call the method to find the pair
        int[] ans = findPair(arr, target);

        // Check if a valid pair is found or not
        if (ans.length == 0) {
            System.out.println("Not Possible.");
        } else {
            System.out.println("Yes Possible.");
            // Output the indices of the pair found
            System.out.println("Index: " + ans[0] + " " + ans[1]);
        }
    }

    // Method to find the pair with the target sum
    private static int[] findPair(int[] arr, int target) {
        // If array is empty, return an empty array
        if (arr.length == 0) {
            return new int[]{};
        }

        // Create a HashMap to store the elements and their indices
        Map<Integer, Integer> map = new HashMap<>();

        // Insert the first element in the map (index 0)
        map.put(0, arr[0]);

        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Check if the complement (target - current element) is in the map
            if (map.containsKey(target - arr[i])) {
                // Return the pair of indices (complement index and current index)
                return new int[]{map.get(target - arr[i]), i};
            }
            // Otherwise, add the current element to the map with its index
            map.put(i, arr[i]);
        }

        // If no pair is found, return an empty array
        return new int[]{};
    }
}
