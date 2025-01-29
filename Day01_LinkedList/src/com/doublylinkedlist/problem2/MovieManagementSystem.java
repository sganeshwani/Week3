package com.doublylinkedlist.problem2;

class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode next, prev;

    // Constructor to initialize movie details
    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagementSystem {
    private static MovieNode head;
    private static MovieNode tail;

    // Add movie at the beginning
    public static void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) { // First movie in the list
            head = tail = newNode;
        } else { // Link new node at the beginning
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add movie at the end
    public static void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) { // First movie in the list
            head = tail = newNode;
        } else { // Link new node at the end
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add movie at a specific position
    public static void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 1) { // Add at the beginning for position <= 1
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) { // Traverse to the desired position
            temp = temp.next;
        }
        if (temp == null || temp.next == null) { // Add at the end if position is beyond list size
            addAtEnd(title, director, year, rating);
        } else { // Insert in the middle
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Remove movie by title
    public static void removeByTitle(String title) {
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) { // Find the movie
            temp = temp.next;
        }
        if (temp == null) { // Movie not found
            System.out.println("Movie not found!");
            return;
        }
        if (temp == head) { // Remove head
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) { // Remove tail
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else { // Remove in the middle
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Movie removed successfully.");
    }

    // Search movies by director
    public static void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) { // Find all movies by the director
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) { // No movies found
            System.out.println("No movies found for the director: " + director);
        }
    }

    // Update a movie's rating by title
    public static void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) { // Find the movie
            temp = temp.next;
        }
        if (temp == null) { // Movie not found
            System.out.println("Movie not found!");
        } else { // Update rating
            temp.rating = newRating;
            System.out.println("Rating updated successfully.");
        }
    }

    // Display all movies in forward order
    public static void displayForward() {
        if (head == null) { // Empty list
            System.out.println("No movies to display.");
            return;
        }
        MovieNode temp = head;
        while (temp != null) { // Traverse forward
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public static void displayReverse() {
        if (tail == null) { // Empty list
            System.out.println("No movies to display.");
            return;
        }
        MovieNode temp = tail;
        while (temp != null) { // Traverse backward
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Helper method to display a movie
    public static void displayMovie(MovieNode movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director +
                ", Year: " + movie.year + ", Rating: " + movie.rating);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Adding movies
        addAtBeginning("3 Idiots", "Rajkumar Hirani", 2009, 8.4);
        addAtEnd("Gully Boy", "Zoya Akhtar", 2019, 7.9);
        addAtPosition("Baahubali: The Beginning", "S.S. Rajamouli", 2015, 8.0, 2);
        addAtPosition("Avengers Endgame", "Anthony Russo", 2019, 8.4, 3);

        // Display movies
        System.out.println("Movies in Forward Order");
        displayForward();
        System.out.println("Movies in Reverse Order");
        displayReverse();

        // Remove a movie
        removeByTitle("Gully Boy");

        // Search movies by director
        searchByDirector("Rajkumar Hirani");

        // Update movie rating
        updateRating("3 Idiots", 9.0);

        // Display updated list
        System.out.println("Movies in Forward Order After Updates");
        displayForward();
    }
}
