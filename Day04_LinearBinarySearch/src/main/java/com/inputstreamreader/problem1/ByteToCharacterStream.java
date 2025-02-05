package com.inputstreamreader.problem1;

import java.io.FileInputStream; //To read binary data from a file
import java.io.InputStreamReader; //To convert byte stream to character stream
import java.io.BufferedReader; //To read text efficiently
import java.io.FileNotFoundException; //Exception handling for missing files
import java.io.IOException; //Exception handling for I/O errors

public class ByteToCharacterStream {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week3\\Day04_LinearBinarySearch\\src\\main\\java\\com\\inputstreamreader\\problem1\\Input.txt"; //File to read

        //Try-with-resources to automatically close streams
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) { //Read file line by line
                System.out.println(line); //Print each line
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}

