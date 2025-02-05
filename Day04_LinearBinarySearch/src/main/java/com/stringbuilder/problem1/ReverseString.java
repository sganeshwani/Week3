package com.stringbuilder.problem1;

public class ReverseString {
    public static void main(String[] args) {
        String string = "Hello";
        //Create a string builder
        StringBuilder string1 = new StringBuilder();

        //Append the given string in string builder
        string1.append(string);

        //Reverse the string builder
        string1.reverse();

        //Convert string builder back to string
        string1.toString();
        System.out.println("Original String : " + string);
        System.out.print("Reversed String : " + string1);
    }
}
