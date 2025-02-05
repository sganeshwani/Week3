package com.inputstreamreader.problem2;

import java.io.FileWriter; //To write data to a file
import java.io.InputStreamReader; //To read input from the console
import java.io.BufferedReader; //To read text efficiently
import java.io.IOException; //Exception handling for I/O errors

public class WriteToFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week3\\Day04_LinearBinarySearch\\src\\main\\java\\com\\inputstreamreader\\problem2\\Input.txt"; //File where user input will be stored

        //Try-with-resources to ensure streams are closed automatically
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String input;
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) { //Read input line by line
                fw.write(input + System.lineSeparator()); //Write input to file with a new line
            }
            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}

