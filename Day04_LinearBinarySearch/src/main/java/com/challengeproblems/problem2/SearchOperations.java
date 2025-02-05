package com.challengeproblems.problem2;

public class SearchOperations {

    //Function to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        //Mark numbers in the correct index position
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        //Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    //Function to perform Binary Search and find the target index
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;  //Target found
            } else if (arr[mid] < target) {
                left = mid + 1;  //Search in right half
            } else {
                right = mid - 1; //Search in left half
            }
        }
        return -1; //Target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int[] sortedNums = {1, 2, 3, 4, 5, 6, 7, 8, 9};  //Sorted array for binary search
        int target = 6;

        //Find first missing positive integer
        int missing = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missing);

        //Perform Binary Search
        int index = binarySearch(sortedNums, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }
}
