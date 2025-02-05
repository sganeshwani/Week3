package com.stringbuffer.problem2;

public class Comparison {
    public static void compareTime(StringBuilder builderobj , StringBuffer bufferobj) {
        StringBuffer stringBuffer = new StringBuffer(); //create a string buffer
        int appends = 1000000;
        String string = "Hello";
        long startTime = System.nanoTime(); //check time before appending
        for (int i = 0; i < appends; i++) { //append the string in buffer
            stringBuffer.append(string);
        }
        long endTime = System.nanoTime(); //check time after appending
        long stringBufferTime = endTime - startTime; //calculate the time taken
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " ns");

        //Measure time for StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.nanoTime(); //check time before appending
        for (int i = 0; i < appends; i++) { //append the string in builder
            stringBuilder.append(string);
        }
        endTime = System.nanoTime(); //check time after appending
        long stringBuilderTime = endTime - startTime; //calculate the time taken
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " ns");

        //Compare results
        if (stringBuilderTime < stringBufferTime) {
            System.out.println("StringBuilder is faster.");
        } else {
            System.out.println("StringBuffer is faster.");
        }
    }
    public static void main(String[] args) {
        //Create two object each for String builder and String Buffer
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();

        //Call the method to compare
        compareTime(builder, buffer);
    }
}
