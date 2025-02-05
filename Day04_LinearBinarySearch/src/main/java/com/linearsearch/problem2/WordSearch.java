package com.linearsearch.problem2;

import java.util.*;

public class WordSearch {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) { //Iterate through sentences
            if (sentence.contains(word)) { //Check if the sentence contains the word
                return sentence; //Return the first matching sentence
            }
        }
        return "Not Found"; //Return if no sentence contains the word
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of sentences: ");
        int n = input.nextInt();
        input.nextLine();

        String[] sentences = new String[n];
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = input.nextLine(); //Read each sentence
        }

        System.out.print("Enter the word to search for: ");
        String word = input.next(); //Read the word to search

        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
    }
}

