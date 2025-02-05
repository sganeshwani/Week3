package com.binarysearch.problem3;
public class SearchTarget {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;      //Number of rows
        int cols = matrix[0].length;   //Number of columns
        int left = 0, right = rows * cols - 1; //Treat matrix as a 1D array

        while (left <= right) {
            int mid = left + (right - left) / 2; //Avoid integer overflow
            int row = mid / cols;  //Convert mid to row index
            int col = mid % cols;  //Convert mid to column index

            if (matrix[row][col] == target) {
                return true;  //If found the target
            } else if (matrix[row][col] < target) {
                left = mid + 1;  //Search in the right half
            } else {
                right = mid - 1; //Search in the left half
            }
        }

        return false;  //Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };

        int target = 3;

        if (searchMatrix(matrix, target)) {
            System.out.println("Target " + target + " found in the matrix.");
        } else {
            System.out.println("Target " + target + " not found in the matrix.");
        }
    }
}

