package com.stacksandqueues.problem4;

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store the maximum of each window
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices of useful elements

        for (int i = 0; i < n; i++) {
            // Remove indices from the front of the deque that are outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices from the back of the deque for elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the back of the deque
            deque.offerLast(i);

            // If the window has reached size k, add the maximum to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.print("Input Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Sliding Window Maximum for k=" + k + " is: ");
        for (int max : result) {
            System.out.print(max + " ");
        }
        System.out.println();
    }
}
