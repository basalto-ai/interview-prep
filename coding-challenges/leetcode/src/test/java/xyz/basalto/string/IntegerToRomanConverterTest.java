package xyz.basalto.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanConverterTest {

    private final IntegerToRomanConverter converter = new IntegerToRomanConverter();

    @Test
    void givenBasicNumerals_whenConvert_thenReturnRoman() {
        assertEquals("I", converter.intToRoman(1));
        assertEquals("V", converter.intToRoman(5));
        assertEquals("X", converter.intToRoman(10));
        assertEquals("L", converter.intToRoman(50));
        assertEquals("C", converter.intToRoman(100));
        assertEquals("D", converter.intToRoman(500));
        assertEquals("M", converter.intToRoman(1000));
    }

    @Test
    void givenSubtractiveCases_whenConvert_thenReturnCorrectRoman() {
        assertEquals("IV", converter.intToRoman(4));
        assertEquals("IX", converter.intToRoman(9));
        assertEquals("XL", converter.intToRoman(40));
        assertEquals("XC", converter.intToRoman(90));
        assertEquals("CD", converter.intToRoman(400));
        assertEquals("CM", converter.intToRoman(900));
    }

    @Test
    void givenComplexNumbers_whenConvert_thenReturnRoman() {
        assertEquals("LVIII", converter.intToRoman(58));         // L + V + III
        assertEquals("MCMXCIV", converter.intToRoman(1994));     // 1000 + 900 + 90 + 4
        assertEquals("DCXXI", converter.intToRoman(621));        // 500 + 100 + 10 + 10 + 1
        assertEquals("MMCDXXI", converter.intToRoman(2421));     // 1000 + 1000 + 400 + 10 + 10 + 1
        assertEquals("MMMDCCCLXXXVIII", converter.intToRoman(3888)); // Complex: 3000 + 800 + 80 + 8
    }

    @Test
    void givenEdgeValues_whenConvert_thenReturnRoman() {
        assertEquals("I", converter.intToRoman(1));             // Minimum valid
        assertEquals("MMMCMXCIX", converter.intToRoman(3999));  // Maximum valid
    }

    @Test
    void givenAllKeyBreakpoints_whenConvert_thenReturnRoman() {
        assertEquals("MMM", converter.intToRoman(3000));
        assertEquals("MMMCM", converter.intToRoman(3900));
        assertEquals("MMMCMXC", converter.intToRoman(3990));
        assertEquals("MMMCMXCIX", converter.intToRoman(3999));
    }

    @Test
    void givenMultipleThousandsAndHundreds_whenConvert_thenReturnCorrectRoman() {
        assertEquals("MMMDLXXVII", converter.intToRoman(3577));
        assertEquals("MMDCCLXXXIV", converter.intToRoman(2784));
        assertEquals("MDCCLXXVI", converter.intToRoman(1776));
        assertEquals("MCMXLV", converter.intToRoman(1945));
    }

    @Test
    void givenSequentialValues_whenConvert_thenReturnExpectedRoman() {
        assertEquals("VIII", converter.intToRoman(8));
        assertEquals("XIII", converter.intToRoman(13));
        assertEquals("XXI", converter.intToRoman(21));
        assertEquals("XXIV", converter.intToRoman(24));
        assertEquals("XXIX", converter.intToRoman(29));
    }
}