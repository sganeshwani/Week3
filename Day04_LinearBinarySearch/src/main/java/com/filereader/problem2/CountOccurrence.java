package com.filereader.problem2;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CountOccurrence {
    public static void main(String[] args) {

        //Define the file path
        String filePath = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week3\\Day04_LinearBinarySearch\\src\\main\\java\\com\\filereader\\problem2\\Sample.txt";
        String targetWord = "what"; //provide the target word which you want to search
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            //Read file line by line
            while ((line = br.readLine()) != null) {
                //Split the line into words
                String[] words = line.split(" ");

                //Count occurrences of the target word
                for (String word : words) {
                    // Remove punctuations
                    word = word.replace(".", "").replace(",", "").replace("!", "").replace("?", "");
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) { //If file is not present
            System.out.println("File not found or error in reading file.");
        }
        System.out.println("The word " + targetWord + " appears " + count + " times in the file.");
    }
}

