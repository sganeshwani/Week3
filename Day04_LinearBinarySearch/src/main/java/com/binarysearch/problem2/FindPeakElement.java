package com.binarysearch.problem2;

public class FindPeakElement {

    //Function to find a peak element using Binary Search
    public static void findPeakElement(int[] arr, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            //Check if the mid-element is greater than both its neighbors peak condition
            if (mid > 0 && mid < arr.length - 1 && arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                System.out.println("Peak element of array is: " + arr[mid]);
                return;  //Exit after finding the first peak
            }

            //If mid is less, the peak is in the left half
            else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;  // Move left
            }

            //Otherwise, the peak must be in the right half
            else {
                left = mid + 1;  //Move right
            }
        }
        System.out.println("No peak element fount in array.");
    }

    public static void main(String[] args) {
        int[] array = {12, 39, 45, 48, 47, 56, 87, 98, 100};
        findPeakElement(array, 0, array.length - 1);  //Call function
    }
}
