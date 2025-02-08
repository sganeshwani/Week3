package com.problem4;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LargeFileReaderComparison {
    public static void main(String[] args) {
        // File Path
        String filePath = "C:\\Users\\HP\\Desktop\\Capgemini Training\\Week3\\Day06_RuntimeAnalysisBigO\\src\\main\\java\\com\\problem4\\Textfile 100MB.txt";

        long fileReaderTime = measureFileReaderTime(filePath);
        System.out.println("Time taken by FileReader: " + fileReaderTime + " ms\n");

        long inputStreamReaderTime = measureInputStreamReaderTime(filePath);
        System.out.println("Time taken by InputStreamReader: " + inputStreamReaderTime + " ms");

        System.out.println("\nComparison:");
        if(inputStreamReaderTime < fileReaderTime) {
            System.out.println("InputStreamReader was the fastest");
        } else {
            System.out.println("FileReader was the fastest");
        }
    }

    // FileReader: Reads character by character
    private static long measureFileReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {} // Read character by character
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }

    // InputStreamReader: Reads bytes and converts to characters
    private static long measureInputStreamReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)) {
            while (reader.read() != -1) {} // Read in bulk
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }
}
