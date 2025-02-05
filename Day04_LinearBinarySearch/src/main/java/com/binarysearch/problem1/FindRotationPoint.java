package com.binarysearch.problem1;

public class FindRotationPoint {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;  //Smallest element is in the right half
            } else {
                right = mid;  //Smallest element is in the left half
            }
        }
        return left;  //Left is now at the index of the smallest element
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};  //Rotated sorted array
        int index = findRotationPoint(arr); //Store the index of rotation point
        System.out.println("The index of rotation is: " + index);
    }
}
