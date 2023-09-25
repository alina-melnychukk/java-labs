package org.university.lab4_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {
    //Method for reverse coding
    public static String reverseDecode(String word) {
        StringBuilder reversedWord = new StringBuilder(word);
        return reversedWord.reverse().toString();
    }

    //Method for changing vowels
    public static String vowelReplaceDecode(String word) {
        word = word.replaceAll("1", "a");
        word = word.replaceAll("2", "e");
        word = word.replaceAll("3", "i");
        word = word.replaceAll("4", "o");
        word = word.replaceAll("5", "u");
        return word;
    }

    //Method for changing consonant
    public static String consonantReplaceDecode(String word) {
        StringBuilder decodeWord = new StringBuilder();
        char prevConsonant = ' ';

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                if (!isVowel(c)) {
                    if (prevConsonant == 'z') {
                        prevConsonant = 'b';
                    } else {
                        prevConsonant++;
                    }
                    decodeWord.append(prevConsonant);
                } else {
                    decodeWord.append(c);
                }
            } else {
                decodeWord.append(c);
            }
        }
        return decodeWord.toString();
    }

    //Method to find out if symbol is vowel
    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}