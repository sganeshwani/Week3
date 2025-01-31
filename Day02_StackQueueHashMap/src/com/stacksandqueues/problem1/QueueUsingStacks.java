package com.stacksandqueues.problem1;

import java.util.*;

public class QueueUsingStacks {
    // Two stacks are used to implement the queue
    private Stack<Integer> stack1; // Used for enqueue operations
    private Stack<Integer> stack2; // Used for dequeue operations

    // Constructor to initialize the two stacks
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: Add an element to the queue
    public void enqueue(int x) {
        // Push the element onto stack1
        stack1.push(x);
    }

    // Dequeue operation: Remove and return the oldest element
    public int dequeue() {
        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Pop from stack1 and push to stack2
            }
        }

        // If stack2 is still empty, the queue is empty
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Dequeue from an empty queue");
        }

        // Pop and return the top element from stack2 (oldest element)
        return stack2.pop();
    }

    // Peek operation: Return the oldest element without removing it
    public int peek() {
        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Pop from stack1 and push to stack2
            }
        }

        // If stack2 is still empty, the queue is empty
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Peek from an empty queue");
        }

        // Return the top element from stack2 (oldest element)
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        // The queue is empty if both stacks are empty
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
        // Create a queue using two stacks
        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue elements into the queue
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);

        // Dequeue elements from the queue and print them
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.dequeue()); // Output: 4
        System.out.println(queue.dequeue()); // Output: 6

        // Enqueue another element
        queue.enqueue(7);

        // Peek at the oldest element without removing it
        System.out.println(queue.peek()); // Output: 7
    }
}