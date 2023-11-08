package org.university.lab4_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PalindromeCheckerTest {

        @Test
        public void testIsPalindrome() {
            Assertions.assertTrue(PalindromeChecker.isPalindrome("А роза упала на лапу Азора"));
            Assertions.assertTrue(PalindromeChecker.isPalindrome("Radar"));
            Assertions.assertFalse(PalindromeChecker.isPalindrome("Hello, world!"));
            Assertions.assertFalse(PalindromeChecker.isPalindrome("This is not a palindrome"));
        }
    }
