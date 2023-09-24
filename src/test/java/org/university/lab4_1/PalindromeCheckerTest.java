package org.university.lab4_1;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class PalindromeCheckerTest {
    //Running tests with possible problems
    @Test
    public void testIsPalindromeWithPalindromeWord(){
        assertTrue(PalindromChecker.isPalindrome("madam"));
    }
    @Test
    public void testIsPalindromeWithMixedCasePalindrome(){
        assertTrue(PalindromChecker.isPalindrome("KaYaK"));
    }
    @Test
    public void testIsPalindromeWithPhrasePalindrome(){
        assertTrue(PalindromChecker.isPalindrome("A man a plan a canal Panama"));
    }
    @Test
    public void testIsPalindromeWithNonPalindromeWord(){
        assertFalse(PalindromChecker.isPalindrome("summer"));
    }
    @Test
    public void testIsPalindromeWithPhraseNonPalindrome(){
        assertFalse(PalindromChecker.isPalindrome("His name is Vasya"));
    }
    @Test
    public void testIsPalindromeWithEmptyString(){
        assertTrue(PalindromChecker.isPalindrome(""));
    }



}
