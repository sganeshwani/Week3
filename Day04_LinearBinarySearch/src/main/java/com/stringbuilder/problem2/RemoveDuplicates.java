package com.stringbuilder.problem2;
import java.util.HashSet;

public class RemoveDuplicates {
    //Method to remove duplicates in a string
    public static String removeDuplicates(String string) {
        StringBuilder string1 = new StringBuilder(); //create a string builder
        HashSet<Character> occurred = new HashSet<>(); //create a hashmap
        for (char c : string.toCharArray()) {
            if (!occurred.contains(c)) { //check whether the character is in hashmap or not
                string1.append(c);  //if it's not present add to string builder
                occurred.add(c); //then add to hash map
            }
        } return string1.toString();
    }

    public static void main(String[] args) {
        String string = "KEENNESS";
        System.out.println("Original String : " + string);
        String result = removeDuplicates(string);
        System.out.println("String after removing duplicates: " + result);
    }
}
