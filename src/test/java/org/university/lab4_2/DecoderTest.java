package org.university.lab4_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DecoderTest {
    @Test
    public void testReverseDecode(){
        assertEquals("testing", Decoder.reverseDecode("gnitset"));
        assertEquals("hello", Decoder.reverseDecode("olleh"));
        assertEquals("world", Decoder.reverseDecode("dlrow"));
    }
    @Test
    public void testVowelReplaceDecode() {
        assertEquals("testing", Decoder.vowelReplaceDecode("t2st3ng"));
        assertEquals("hello", Decoder.vowelReplaceDecode("h2ll4"));
        assertEquals("world", Decoder.vowelReplaceDecode("w4rld"));
    }



}