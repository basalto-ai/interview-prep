package xyz.basalto.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerConverterTest {

    private final RomanToIntegerConverter converter = new RomanToIntegerConverter();

    // Basic numeral conversion
    @Test
    void givenSingleRomanNumerals_whenConvertRomanToInt_thenReturnCorrectValue() {
        assertEquals(1, converter.romanToInt("I"));
        assertEquals(5, converter.romanToInt("V"));
        assertEquals(10, converter.romanToInt("X"));
        assertEquals(50, converter.romanToInt("L"));
        assertEquals(100, converter.romanToInt("C"));
        assertEquals(500, converter.romanToInt("D"));
        assertEquals(1000, converter.romanToInt("M"));
    }

    // Repeated numerals (valid repetitions)
    @Test
    void givenRepeatedNumerals_whenConvertRomanToInt_thenReturnSum() {
        assertEquals(2, converter.romanToInt("II"));
        assertEquals(3, converter.romanToInt("III"));
        assertEquals(30, converter.romanToInt("XXX"));
        assertEquals(300, converter.romanToInt("CCC"));
        assertEquals(3000, converter.romanToInt("MMM"));
    }

    // Subtractive notation
    @Test
    void givenSubtractiveNotation_whenConvertRomanToInt_thenReturnCorrectValue() {
        assertEquals(4, converter.romanToInt("IV"));
        assertEquals(9, converter.romanToInt("IX"));
        assertEquals(40, converter.romanToInt("XL"));
        assertEquals(90, converter.romanToInt("XC"));
        assertEquals(400, converter.romanToInt("CD"));
        assertEquals(900, converter.romanToInt("CM"));
    }

    // Complex and mixed cases
    @Test
    void givenMixedNotation_whenConvertRomanToInt_thenReturnAccurateResult() {
        assertEquals(58, converter.romanToInt("LVIII"));         // 50 + 5 + 3
        assertEquals(1994, converter.romanToInt("MCMXCIV"));     // 1000 + 900 + 90 + 4
        assertEquals(621, converter.romanToInt("DCXXI"));        // 500 + 100 + 10 + 10 + 1
        assertEquals(3999, converter.romanToInt("MMMCMXCIX"));   // Max valid Roman numeral
        assertEquals(3888, converter.romanToInt("MMMDCCCLXXXVIII")); // Complex full numeral
    }

    // Lowercase input support
    @Test
    void givenLowercaseRomanInput_whenConvertRomanToInt_thenReturnCorrectResult() {
        assertEquals(1994, converter.romanToInt("mcmxciv"));
        assertEquals(3999, converter.romanToInt("mmmcmxcix"));
    }

    // Edge case: empty string
    @Test
    void givenEmptyString_whenConvertRomanToInt_thenReturnZero() {
        assertEquals(0, converter.romanToInt(""));
    }

    // Invalid characters should throw
    @Test
    void givenInvalidRomanCharacters_whenConvertRomanToInt_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("A"));
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("XMZ"));
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("IIIIIIIIIIII")); // not structurally valid
        assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("123"));
    }

    // Null input
    @Test
    void givenNullInput_whenConvertRomanToInt_thenReturnZero() {
        assertEquals(0, converter.romanToInt(null));
    }

    // Large valid Roman numeral (stress test)
    @Test
    void givenVeryLongValidRomanInput_whenConvertRomanToInt_thenReturnCorrectSum() {
        // 1000 * 3 + 100 * 3 + 10 * 3 + 1 * 3 = 3333
        assertEquals(3333, converter.romanToInt("MMMCCCXXXIII"));
    }
}