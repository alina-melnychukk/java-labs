package org.university.lab4_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DecoderTest {
    @Test
    public void testDecodeVowels() {
        assertEquals("hello", Decoder.decodeVowels("h2ll4"));
        assertEquals("aeiou", Decoder.decodeVowels("12345"));
        assertEquals("testing", Decoder.decodeVowels("t2st3ng"));
        assertEquals("", Decoder.decodeVowels(""));
    }

    @Test
    public void testDecodeConsonant() {
        assertEquals("acdfeg", Decoder.decodeConsonant("abcdef"));
        assertEquals("XYZ", Decoder.decodeConsonant("XYZ"));
        assertEquals("", Decoder.decodeConsonant(""));
    }

    @Test
    public void testIsConsonant() {
        char[] consonants = {'b', 'c', 'd', 'f', 'g'};
        assertTrue(Decoder.isConsonant('b', consonants));
        assertTrue(Decoder.isConsonant('f', consonants));
        assertFalse(Decoder.isConsonant('a', consonants));
        assertFalse(Decoder.isConsonant('e', consonants));
    }

    @Test
    public void testGetNextConsonant() {
        char[] consonants = {'b', 'c', 'd', 'f', 'g'};
        assertEquals('c', Decoder.getNextConsonant('b', consonants));
        assertEquals('g', Decoder.getNextConsonant('f', consonants));
        assertEquals('b', Decoder.getNextConsonant('g', consonants));
        assertEquals('b', Decoder.getNextConsonant('z', consonants));
    }
//    @Test
//    public void testReverseDecode(){
//        assertEquals("testing", Decoder.reverseDecode("gnitset"));
//        assertEquals("hello", Decoder.reverseDecode("olleh"));
//        assertEquals("world", Decoder.reverseDecode("dlrow"));
//    }
//    @Test
//    public void testVowelReplaceDecode() {
//        assertEquals("testing", Decoder.vowelReplaceDecode("t2st3ng"));
//        assertEquals("hello", Decoder.vowelReplaceDecode("h2ll4"));
//        assertEquals("world", Decoder.vowelReplaceDecode("w4rld"));
//    }



}