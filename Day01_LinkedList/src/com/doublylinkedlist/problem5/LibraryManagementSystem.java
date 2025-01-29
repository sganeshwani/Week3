package com.doublylinkedlist.problem5;

// Class representing a book node in the doubly linked list
class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

// Class representing the Library Management System using a Doubly Linked List
class Library {
    private Book head, tail;
    private int count;

    public Library() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // Add a new book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    // Add a new book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    // Add a book at a specific position (1-based index)
    public void addBookAtPosition(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position < 1 || position > count + 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }
        if (position == count + 1) {
            addBookAtEnd(title, author, genre, bookID, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        Book temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
        count++;
    }

    // Remove a book by Book ID
    public void removeBook(int bookID) {
        Book temp = head;
        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book not found!");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        count--;
    }

    // Search for a book by Title or Author
    public void searchBook(String query) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    // Update a book's availability status
    public void updateAvailability(int bookID, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = status;
                System.out.println("Updated availability for " + temp.title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.bookID + ": " + temp.title + " by " + temp.author + " [" + (temp.isAvailable ? "Available" : "Checked Out") + "]");
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.bookID + ": " + temp.title + " by " + temp.author + " [" + (temp.isAvailable ? "Available" : "Checked Out") + "]");
            temp = temp.prev;
        }
    }

    // Count total books in the library
    public int countBooks() {
        return count;
    }
}

// Main class to manage the library system
class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBookAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addBookAtPosition("1984", "George Orwell", "Dystopian", 103, false, 2);

        System.out.println("Books in library (forward order):");
        library.displayBooksForward();
        System.out.println("--------------------------------------------");

        System.out.println("\nBooks in library (reverse order):");
        library.displayBooksReverse();
        System.out.println("----------------------------------------------------");

        library.searchBook("1984");
        library.updateAvailability(103, true);

        System.out.println("\nTotal books in library: " + library.countBooks());
        System.out.println("------------------------------------------------------");

        library.removeBook(101);
        System.out.println("\nAfter removal:");
        library.displayBooksForward();
    }
}
