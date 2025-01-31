package com.hashmaps.problem3;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        // Sample input array
        int []arr=new int[]{2,3,4,56,57,58,59,3,4,5,6,7,8};

        // Finding the longest consecutive sequence length
        int maxConsecutiveLength= lengthOfLongestConsecutiveSequence(arr);

        // Printing the result
        System.out.println("Maximum length of consecutive elements: "+maxConsecutiveLength);
    }

    private static int lengthOfLongestConsecutiveSequence(int[] numbs) {
        // If array is empty, return 0
        if(numbs.length==0) return 0;

        // Using HashSet to store unique elements
        Set<Integer> set=new HashSet<>();
        for (int numb : numbs) {
            set.add(numb);
        }

        int max=1; // Variable to store maximum length of consecutive sequence

        // Iterating through the set to find longest sequence
        for(int num : set){
            // Checking if it's the start of a sequence
            if(!set.contains(num-1)){
                int count=1;

                // Counting consecutive elements
                while(set.contains(num+1)){
                    count++;
                    num++;
                }

                // Updating maximum length found
                max=Math.max(max,count);
            }
        }

        return max; // Returning the maximum length
    }
}
