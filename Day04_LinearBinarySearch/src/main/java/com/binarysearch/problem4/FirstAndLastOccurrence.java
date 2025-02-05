package com.binarysearch.problem4;
public class FirstAndLastOccurrence {

    //Function to find the first occurrence of target
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                first = mid;  //Potential first occurrence
                right = mid - 1;  //Continue searching left
            } else if (arr[mid] < target) {
                left = mid + 1;  //Search in right half
            } else {
                right = mid - 1; //Search in left half
            }
        }
        return first;
    }

    //Function to find the last occurrence of target
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                last = mid;  //Potential last occurrence
                left = mid + 1;  //Continue searching right
            } else if (arr[mid] < target) {
                left = mid + 1;  //Search in right half
            } else {
                right = mid - 1; //Search in left half
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        int target = 2;

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if (first == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First occurrence: " + first);
            System.out.println("Last occurrence: " + last);
        }
    }
}

