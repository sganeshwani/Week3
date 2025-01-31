package com.hashmaps.problem5;

import java.util.HashMap;

public class TwoSumProblem {
    //Finds a pair of indices in the given array whose values sum up to the target.

    public static int[] findPair(int []arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>(); // HashMap to store array values and their indices

        for(int i = 0; i < arr.length; i++){
            // Check if the complement (target - current number) is already in the map
            if(map.containsKey(target - arr[i])){
                return new int[]{map.get(target - arr[i]), i}; // Return the indices of the two numbers
            } else {
                map.put(arr[i], i); // Store the current number and its index in the map
            }
        }

        return new int[]{}; // Return an empty array if no valid pair is found
    }

    public static void main(String[] args) {
        int []arr = new int[]{2, 3, 4, 5, 6, 7, 8, 10, 12, 13, 15, 34}; // Input array
        int target = 36; // Target sum to find
        int []index = findPair(arr, target);

        // Print result based on whether a valid pair was found
        if(index.length > 0){
            System.out.println("Yes Possible, Index: " + index[0] + " and " + index[1]);
        } else {
            System.out.println("Not Possible.");
        }
    }
}
