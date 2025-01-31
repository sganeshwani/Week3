package com.hashmaps.problem4;

import java.util.LinkedList;

class HashMap<K, V> {
    // Define the size of the hash map (array)
    private static final int SIZE = 16;

    // Array to store the linked lists (buckets)
    private final LinkedList<Node<K, V>>[] map;

    // Inner class to represent key-value pairs
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the map with a certain size
    public HashMap() {
        map = new LinkedList[SIZE];

        // Initialize each bucket (linked list)
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function to map keys to indices
    private int hash(K key) {
        return key.hashCode() % SIZE;
    }

    // Insert key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = map[index];

        // Check if the key already exists, and if so, update the value
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // If key doesn't exist, add a new node to the bucket
        bucket.add(new Node<>(key, value));
    }

    // Retrieve value by key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = map[index];

        // Search for the key in the bucket
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;  // Return null if key is not found
    }

    // Delete key-value pair
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = map[index];

        // Iterate through the bucket and remove the key-value pair
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                return;
            }
        }
    }

    // Print the hash map for debugging purposes
    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            LinkedList<Node<K, V>> bucket = map[i];
            if (!bucket.isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Node<K, V> node : bucket) {
                    System.out.print("[" + node.key + "=" + node.value + "] ");
                }
                System.out.println();
            }
        }
    }
}
public class CustomHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insert some key-value pairs
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("cherry", 7);

        // Retrieve and print values
        System.out.println("Value for apple: " + map.get("apple"));   // 5
        System.out.println("Value for banana: " + map.get("banana")); // 3

        // Delete a key-value pair
        map.remove("banana");

        // Try retrieving the deleted key
        System.out.println("Value for banana after removal: " + map.get("banana")); // null

        // Print the map contents
        map.printMap();
    }
}
