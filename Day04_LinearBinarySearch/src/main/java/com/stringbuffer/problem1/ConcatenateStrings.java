package com.stringbuffer.problem1;

public class ConcatenateStrings {
    //Method to concatenate the strings
    public static void concatenate(String[] strings) {
        //create a string buffer
        StringBuffer buffer = new StringBuffer();
        //check each string in string array
        for(String str : strings){
            //add the string in string buffer
            buffer.append(str);
            //add a space between each string in the array
            buffer.append(" ");
        }
        System.out.println(buffer);
    }
    public static void main(String[] args) {
        String[] string = {"Hello" , "ji," , "tussi" , "kese", "ho"}; //create a string array
        concatenate(string);
    }
}
