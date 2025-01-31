package com.stacksandqueues.problem3;

import java.util.*;

public class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // Array to store the span values
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the stack is not empty and the price at the top is <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Calculate the span
            if (stack.isEmpty()) {
                span[i] = i + 1; // If stack is empty, span is current index + 1
            } else {
                span[i] = i - stack.peek(); // Otherwise, span is current index - top of stack index
            }

            // Push the current index onto the stack
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        System.out.print("Stock Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();

        System.out.print("Stock Spans: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
