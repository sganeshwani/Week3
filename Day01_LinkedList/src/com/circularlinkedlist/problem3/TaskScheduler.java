package com.circularlinkedlist.problem3;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    // Constructor to initialize task details
    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private static TaskNode head = null;
    private static TaskNode tail = null;
    private static TaskNode currentTask = null; // Tracks the current task for traversal

    // Add task at the beginning
    public static void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) { // First task in the list
            head = tail = newNode;
            newNode.next = head; // Circular link
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular nature
        }
    }

    // Add task at the end
    public static void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (tail == null) { // First task in the list
            head = tail = newNode;
            newNode.next = head; // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular nature
        }
    }

    // Add task at a specific position (1-based index)
    public static void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) { // If added at the end, update tail
            tail = newNode;
        }
    }

    // Remove a task by Task ID
    public static void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }
        TaskNode temp = head;
        TaskNode prev = tail;

        // Traverse the circular list
        do {
            if (temp.taskId == taskId) { // Task found
                if (temp == head) { // Removing head
                    if (head == tail) { // Only one node
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else if (temp == tail) { // Removing tail
                    tail = prev;
                    tail.next = head;
                } else { // Removing middle node
                    prev.next = temp.next;
                }
                System.out.println("Task with ID " + taskId + " removed successfully.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found!");
    }

    // View the current task and move to the next task
    public static void viewAndMoveToNext() {
        if (currentTask == null) {
            currentTask = head; // Initialize current task
        }
        if (currentTask != null) {
            displayTask(currentTask);
            currentTask = currentTask.next; // Move to next task
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks starting from the head
    public static void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        TaskNode temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public static void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }
        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }

    // Helper method to display a task
    private static void displayTask(TaskNode task) {
        System.out.println("Task ID: " + task.taskId + ", Task Name: " + task.taskName +
                ", Priority: " + task.priority + ", Due Date: " + task.dueDate);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Adding tasks at beginning, end, speci
        addAtBeginning(1, "Task A", 1, "01-02-2025");
        addAtEnd(2, "Task B", 3, "05-02-2025");
        addAtPosition(3, "Task C", 2, "03-02-2025", 2);
        // Display all tasks
        System.out.println("All Tasks:");
        displayAllTasks();
        // View and move to the next task
        System.out.println("\nViewing current tasks:");
        viewAndMoveToNext();
        viewAndMoveToNext();
        // Search by priority
        searchByPriority(2);
        // Remove a task
        removeByTaskId(2);
        // Display all tasks after removal
        System.out.println("\nAll Tasks After Removal:");
        displayAllTasks();
    }
}
