package com.circularlinkedlist.problem9;
class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
class TicketReservationSystem {
    private Ticket head; // Points to the first node in the list
    private Ticket tail; // Points to the last node in the list
    private int totalTickets; // Keeps track of the total number of tickets

    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
        this.totalTickets = 0;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head; // Points to itself (circular)
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Complete the circular link
        }
        totalTickets++;
    }

    // Remove a ticket by Ticket ID
    public boolean removeTicket(int ticketID) {
        if (head == null) return false; // Empty list

        Ticket current = head;
        Ticket previous = null;

        // If the head is the ticket to remove
        if (head.ticketID == ticketID) {
            if (head == tail) {
                head = tail = null; // Only one ticket in the list
            } else {
                head = head.next;
                tail.next = head; // Adjust the circular link
            }
            totalTickets--;
            return true;
        }

        // Traverse the list to find the ticket
        do {
            previous = current;
            current = current.next;
            if (current.ticketID == ticketID) {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous; // Update the tail if the last node is removed
                }
                totalTickets--;
                return true;
            }
        } while (current != head); // Loop back after reaching the last node

        return false; // Ticket not found
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head); // Loop back to the first node
    }

    // Search tickets by Customer Name or Movie Name
    public void searchTickets(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.contains(searchTerm) || current.movieName.contains(searchTerm)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for the search term: " + searchTerm);
        }
    }

    // Calculate the total number of booked tickets
    public int totalBookedTickets() {
        return totalTickets;
    }
}


public class TicketReservationSystemManager {
    public static void main(String []args){
        TicketReservationSystem system = new TicketReservationSystem();

        // Add some tickets
        system.addTicket(101, "Sahil", "Pushpa 2", "A9", "2025-01-29 10:00");
        system.addTicket(102, "Ayush", "Beast", "B10", "2025-01-29 12:00");
        system.addTicket(103, "Shresth", "Avengers Endgame", "C8", "2025-01-29 14:00");
        system.addTicket(104, "Satyam", "K.G.F.", "D7", "2025-01-29 16:00");

        // Display all tickets
        System.out.println("Displaying all tickets:");
        system.displayTickets();
        System.out.println("----------------------------------------");
        // Remove a ticket by Ticket ID
        System.out.println("\nRemoving ticket with Ticket ID 102:");
        if (system.removeTicket(102)) {
            System.out.println("Ticket removed successfully.");
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Ticket not found.");
            System.out.println("-------------------------------------");
        }

        // Display all tickets after removal
        System.out.println("\nDisplaying all tickets after removal:");
        system.displayTickets();
        System.out.println("---------------------------------------");

        // Search for tickets by Customer Name or Movie Name
        System.out.println("\nSearching for tickets with 'Inception':");
        system.searchTickets("Inception");
        System.out.println("----------------------------------------");

        // Get and display the total number of booked tickets
        System.out.println("\nTotal Booked Tickets: " + system.totalBookedTickets());
    }
}
