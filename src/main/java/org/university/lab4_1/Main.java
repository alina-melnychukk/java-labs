package org.university.lab4_1;

public class Main {
    public static void main(String[] args) {
        String word = "Level";
        if(PalindromChecker.isPalindrome(word)){
            System.out.println("This word is palindrome");
        }
        else System.out.println("This word is not a palindrome");
    }
}
