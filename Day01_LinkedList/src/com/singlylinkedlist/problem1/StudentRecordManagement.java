package com.singlylinkedlist.problem1;

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    // Constructor to initialize a student node
    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    private static Student head; // Head of the linked list

    // Add a new student record at the beginning
    public static void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add a new student record at the end
    public static void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
    }

    // Add a new student record at a specific position
    public static void addAtPosition(int position, int rollNumber , String name, int age, String grade) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }

        Student temp = head;
        for (int i = 1; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of range!");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range!");
        } else {
            newStudent.next = temp.next;
            temp.next = newStudent;
        }
    }

    // Delete a student record by Roll Number
    public static void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student with Roll Number " + rollNumber + " deleted");
        }
    }

    // Search for a student record by Roll Number
    public static void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll Number = " + temp.rollNumber +
                        ", Name = " + temp.name +
                        ", Age = " + temp.age +
                        ", Grade = " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found");
    }

    // Display all student records
    public static void displayAllRecords() {
        if (head == null) {
            System.out.println("No student records available");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber +
                    ", Name: " + temp.name +
                    ", Age: " + temp.age +
                    ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Update a student's grade by Roll Number
    public static void updateGradeByRollNumber(int rollNumber, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNumber);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found");
    }

    // Main method for testing
    public static void main(String[] args) {
        //Student added at the beginning
        StudentRecordManagement.addAtBeginning(137,"Sahil",21, "A");
        //Student added at the end
        StudentRecordManagement.addAtEnd(187,"Vinay", 20, "B");
        //Student added at specific position
        StudentRecordManagement.addAtPosition(2, 148,"Satyam", 21, "A");
        //Displaying all students record
        StudentRecordManagement.displayAllRecords();
        //Upgrading student grade by roll number
        StudentRecordManagement.updateGradeByRollNumber(137, "A+");
        //Searching student by their roll number
        StudentRecordManagement.searchByRollNumber(137);
        //Deleting student record by roll number
        StudentRecordManagement.deleteByRollNumber(148);
    }
}
