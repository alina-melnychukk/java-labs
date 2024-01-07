package org.university.lab4_2;

public class Main {
    private static void main(String[] args) {

        String encodedWord = "H2ll4 w4rld!";
        System.out.println("Encoded word: " + encodedWord);
        System.out.println("Decoded word: " + Decoder.decodeVowels(encodedWord));

        String consonantWord = "gekko voqkc!";
        String replacedWord = Decoder.decodeConsonant(consonantWord);
        System.out.println("Original word: " + consonantWord);
        System.out.println("Word with consonants replaced: " + replacedWord);
    }

}