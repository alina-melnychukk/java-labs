package org.university.lab4_1;

public class PalindromChecker {
    public static boolean isPalindrome(String word){
        //Transforming phrases to lower case and deleting gaps
        word = word.toLowerCase().replaceAll("\\s+", "");

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if(word.charAt(left) != word.charAt(right)){
                return false; //If the characters at the same positions do not match, then this is not a palindrome
            }
            left++;
            right--;
        }
        return true; //If the cycle is completed without detecting discrepancies, then this is a palindrome
    }

}
