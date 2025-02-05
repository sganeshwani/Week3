package com.filereader.problem1;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("C:\\Users\\HP\\Desktop\\Capgemini Training\\Week3\\Day04_LinearBinarySearch\\src\\main\\java\\com\\filereader\\problem1\\Text.txt")) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);  //Reads and prints the file's characters
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}