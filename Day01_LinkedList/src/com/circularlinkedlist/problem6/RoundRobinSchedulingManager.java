package com.circularlinkedlist.problem6;

// Class representing a process node in the circular linked list
class Process {
    int processID;
    int burstTime;
    int priority;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

// Class representing the Round Robin Scheduler using a Circular Linked List
class RoundRobinScheduler {
    private Process head, tail;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular link
        }
    }

    // Remove a process by Process ID after its execution
    public void removeProcess(int processID) {
        if (head == null) return;

        Process current = head, prev = tail;
        do {
            if (current.processID == processID) {
                if (current == head && current == tail) { // Only one process left
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head) head = head.next;
                    if (current == tail) tail = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate round-robin scheduling
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalTime = 0, totalWaitTime = 0, totalTurnAroundTime = 0, processCount = 0;
        Process current = head;

        while (head != null) {
            System.out.println("Executing Process " + current.processID);

            if (current.burstTime > timeQuantum) {
                totalTime += timeQuantum;
                current.burstTime -= timeQuantum;
            } else {
                totalTime += current.burstTime;
                totalTurnAroundTime += totalTime;
                removeProcess(current.processID);
            }

            current = current.next;
            displayProcesses();
        }

        double avgWaitTime = (double) totalWaitTime / processCount;
        double avgTurnAroundTime = (double) totalTurnAroundTime / processCount;
        System.out.println("Average Waiting Time: " + avgWaitTime);
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
    }

    // Display all processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.print("Processes in queue: ");
        do {
            System.out.print("[P" + temp.processID + " (BT: " + temp.burstTime + ")] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

// Class to manage the Round Robin Scheduler
class RoundRobinSchedulerManager {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3); // Time Quantum = 3
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        System.out.println("\nStarting Round Robin Scheduling:");
        scheduler.simulateScheduling();
    }
}

