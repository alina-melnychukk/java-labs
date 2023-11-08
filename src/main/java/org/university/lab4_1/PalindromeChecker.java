package org.university.lab4_1;

public class PalindromeChecker {
    public static boolean isPalindrome(String word) {
        word = word.replaceAll("\\s+", "").toLowerCase();

        String reversed = new StringBuilder(word).reverse().toString();

        return word.equals(reversed);
    }

    public static void main(String[] args) {
        String word = "A man a plan a canal Panama";
        if (isPalindrome(word)) {
            System.out.println("Phrase '" + word + "' is palindrome.");
        } else {
            System.out.println("Phrase '" + word + "' is not a palindrome.");
        }
    }
}

