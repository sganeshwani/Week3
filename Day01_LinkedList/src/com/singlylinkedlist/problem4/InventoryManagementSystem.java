package com.singlylinkedlist.problem4;

class ItemNode {
    String itemName;
    int itemID;
    int quantity;
    double price;
    ItemNode next;

    // Constructor to initialize item details
    ItemNode(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
public class InventoryManagementSystem {

    private static ItemNode head;

    // Method to add an item at the beginning
    public void addAtBeginning(String itemName, int itemID, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemID, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Method to add an item at the end
    public void addAtEnd(String itemName, int itemID, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemID, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            ItemNode current = head;
            while (current.next!= null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Methhod to add an item at specific position
    public void addAtPosition(String itemName, int itemID, int quantity, double price, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        ItemNode newNode = new ItemNode(itemName, itemID, quantity, price);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        ItemNode current = head;
        for (int i = 1; i < position - 1 && current!= null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position!");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Remove an item from item id
    public void removeById(int itemID) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        if (head.itemID == itemID) {
            head = head.next;
            return;
        }

        ItemNode current = head;
        while (current.next!= null && current.next.itemID!= itemID) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item with ID " + itemID + " not found!");
            return;
        }
        current.next = current.next.next;
    }

    // Update item quantity of an item by item id
    public void updateQuantityById(int itemID, int newQuantity) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        ItemNode current = head;
        while (current!= null && current.itemID!= itemID) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Item with ID " + itemID + " not found!");
            return;
        }
        current.quantity = newQuantity;
    }

    // Search for an item by item name
    public ItemNode searchByName(String itemName) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return null;
        }

        ItemNode current = head;
        boolean found = false;
        while (current!= null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Item not found!");
        }
        return current;
    }

    // Sort the inventory based on Price (ascending or descending)
    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) {
            return;
        }
        ItemNode current = head;
        ItemNode index = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if ((ascending && current.price > index.price) ||
                        (!ascending && current.price < index.price)) {
                    // Swap data
                    swapNodes(current, index);
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // Helper method to swap nodes
    private void swapNodes(ItemNode a, ItemNode b) {
        String tempName = a.itemName;
        int tempID = a.itemID;
        int tempQuantity = a.quantity;
        double tempPrice = a.price;

        a.itemName = b.itemName;
        a.itemID = b.itemID;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemName = tempName;
        b.itemID = tempID;
        b.quantity = tempQuantity;
        b.price = tempPrice;
    }

    // Display by calculating the total value of inventory (
    public double calculateTotalValue() {
        double totalValue = 0;
        ItemNode current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }

    // Display the inventory
    public void displayInventory() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemID +
                    ", Quantity: " + temp.quantity + ", Price: ₹" + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Adding items
        inventory.addAtEnd("Laptop", 101, 10, 1200.0);
        inventory.addAtEnd("Mouse", 102, 50, 25.0);
        inventory.addAtBeginning("Keyboard", 103, 30, 50.0);

        // Display inventory
        System.out.println("Inventory:");
        inventory.displayInventory();

        // Update quantity
        inventory.updateQuantityById(102, 60);

        // Search by Item ID
        ItemNode item = inventory.searchByName("Laptop");
        if (item != null) {
            System.out.println("Item Found: " + item.itemName);
        } else {
            System.out.println("Item not found.");
        }

        // Calculate total value
        System.out.println("Total inventory value: ₹" + inventory.calculateTotalValue());

        // Sort by Price (descending)
        inventory.sortByPrice(false);
        System.out.println("Sorted by Price (descending):");
        inventory.displayInventory();
    }
}

