package com.stacksandqueues.problem2;

import java.util.*;

public class SortStack {
    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Pop the top element
            int temp = stack.pop();

            // Sort the remaining stack
            sortStack(stack);

            // Insert the popped element in the correct position
            insertSorted(stack, temp);
        }
    }

    // Function to insert an element in the correct position
    public static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            // Pop the top element and recursively insert the element
            int temp = stack.pop();
            insertSorted(stack, element);

            // Push the popped element back
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(21);
        stack.push(48);
        stack.push(62);
        stack.push(73);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
