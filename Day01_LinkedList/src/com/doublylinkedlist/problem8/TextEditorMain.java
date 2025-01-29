package com.doublylinkedlist.problem8;
class TextEditorState {
    String text;
    TextEditorState prev;
    TextEditorState next;

    public TextEditorState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextEditorState head;        // First state
    private TextEditorState tail;        // Last state
    private TextEditorState current;     // Current state
    private int maxHistory;   // Maximum number of states to store
    private int historyCount; // Count of stored states

    public TextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.historyCount = 0;
        this.head = this.tail = this.current = null;
    }

    // Add a new state at the end of the list
    public void addState(String newText) {
        TextEditorState newState = new TextEditorState(newText);

        if (historyCount == maxHistory) {
            // Remove the oldest state when history limit is reached
            head = head.next;
            head.prev = null;
            historyCount--;
        }

        if (tail != null) {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        } else {
            head = tail = current = newState;
        }
        historyCount++;
    }

    // Undo operation: Move to the previous state
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo operations.");
        }
    }

    // Redo operation: Move to the next state
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo operations.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }
}

public class TextEditorMain {
    public static void main(String[] args) {
        // Create an editor with a maximum history size of 10
        TextEditor editor = new TextEditor(10);

        // Simulate adding text states
        editor.addState("First state");
        editor.addState("Second state");
        editor.addState("Third state");

        // Display the current state
        editor.displayCurrentState();

        // Undo and Display
        editor.undo();
        editor.displayCurrentState();

        // Redo and Display
        editor.redo();
        editor.displayCurrentState();
    }
}

