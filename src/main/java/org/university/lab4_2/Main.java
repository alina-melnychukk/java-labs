package org.university.lab4_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.university.lab4_2.Decoder.*;

public class Main {
    private static void main(String[] args) {
        //Examples of coded messages
        String encodedMessage1 = "t2st3ng g1tset ufttjoh";
        String encodedMessage2 = "o4h4ll5";
        String encodedMessage3 = "1ppl2s 1r2 3l4g3t3m3t3";

        //Defining regular expressions to define the encoding method
        Pattern reversePattern = Pattern.compile("[a-z]+");
        Pattern vowelReplacePattern = Pattern.compile("[12345]+");
        Pattern consonantReplacePattern = Pattern.compile("[[bcdfghjklmnpqrstvwxyz]+]");

        //Split the message into words and decode each word
        String[] words1 = encodedMessage1.split(" ");
        String[] words2 = encodedMessage2.split(" ");
        String[] words3 = encodedMessage3.split(" ");

        for (String word : words1) {
            Matcher reverseMatcher = reversePattern.matcher(word);
            Matcher vowelReplaceMatcher = vowelReplacePattern.matcher(word);
            Matcher consonantReplaceMatcher = consonantReplacePattern.matcher(word);

            if (reverseMatcher.matches()) {
                System.out.print(reverseDecode(word) + " ");
            } else if (vowelReplaceMatcher.matches()) {
                System.out.print(vowelReplaceDecode(word) + " ");
            } else if (consonantReplaceMatcher.matches()) {
                System.out.print(consonantReplaceDecode(word) + " ");
            } else {
                System.out.print(word + " ");
            }
        }
        System.out.println();

        for (String word : words2) {
            Matcher reverseMatcher = reversePattern.matcher(word);
            Matcher vowelReplaceMatcher = vowelReplacePattern.matcher(word);
            Matcher consonantReplaceMatcher = consonantReplacePattern.matcher(word);

            if (reverseMatcher.matches()) {
                System.out.print(reverseDecode(word) + " ");
            } else if (vowelReplaceMatcher.matches()) {
                System.out.print(vowelReplaceDecode(word) + " ");
            } else if (consonantReplaceMatcher.matches()) {
                System.out.print(consonantReplaceDecode(word) + " ");
            } else {
                System.out.print(word + " ");
            }
        }

        System.out.println();

        for (String word : words3) {
            Matcher reverseMatcher = reversePattern.matcher(word);
            Matcher vowelReplaceMatcher = vowelReplacePattern.matcher(word);
            Matcher consonantReplaceMatcher = consonantReplacePattern.matcher(word);

            if (reverseMatcher.matches()) {
                System.out.print(reverseDecode(word) + " ");
            } else if (vowelReplaceMatcher.matches()) {
                System.out.print(vowelReplaceDecode(word) + " ");
            } else if (consonantReplaceMatcher.matches()) {
                System.out.print(consonantReplaceDecode(word) + " ");
            } else {
                System.out.print(word + " ");
            }
        }
        System.out.println();
    }
}