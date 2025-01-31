package com.stacksandqueues.problem5;

import java.util.*;

public class CircularTour {
    // Queue to track petrol balance at each station
    static Queue<Integer> queue = new LinkedList<>();
    //Method to find the starting point of tour
    public static int firstCircularTour(int[] petrol, int[] distance, int n) {
        int totalPetrol = 0;  // Total petrol available
        int totalDistance = 0; // Total distance to cover
        int currentPetrol = 0; // Current petrol balance while traversing
        int start = 0; // Starting index of the tour

        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i]; // Accumulate total petrol
            totalDistance += distance[i]; // Accumulate total distance
            currentPetrol += (petrol[i] - distance[i]); // Update current petrol balance
            queue.offer(currentPetrol); // Store petrol balance at each station

            // If petrol balance is negative, reset start position
            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0; // Reset current petrol balance
            }
        }

        // If total petrol is less than total distance, tour is not possible
        if (totalPetrol < totalDistance) {
            return -1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 5, 6, 1, 2, 4}; // Petrol available at each station
        int[] distance = {5, 2, 7, 2, 3, 1}; // Distance to next station
        int n = petrol.length; // Number of stations

        int startingPoint = firstCircularTour(petrol, distance, n);

        System.out.println("Starting Point of tour: " + startingPoint);
        System.out.println("Tracking Petrol: " + queue);
    }
}