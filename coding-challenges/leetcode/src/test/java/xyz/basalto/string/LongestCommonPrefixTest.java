package xyz.basalto.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    private final LongestCommonPrefix lcpSolver = new LongestCommonPrefix();

    @Test
    void givenCommonPrefixAcrossAllStrings_whenLongestCommonPrefix_thenReturnsCorrectPrefix() {
        // Given
        String[] input = {"flower", "flow", "flight"};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("fl", result);
    }

    @Test
    void givenNoCommonPrefix_whenLongestCommonPrefix_thenReturnsEmptyString() {
        // Given
        String[] input = {"dog", "racecar", "car"};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("", result);
    }

    @Test
    void givenAllStringsIdentical_whenLongestCommonPrefix_thenReturnsSameString() {
        // Given
        String[] input = {"test", "test", "test"};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("test", result);
    }

    @Test
    void givenSingleStringInArray_whenLongestCommonPrefix_thenReturnsSameString() {
        // Given
        String[] input = {"hello"};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("hello", result);
    }

    @Test
    void givenEmptyArray_whenLongestCommonPrefix_thenReturnsEmptyString() {
        // Given
        String[] input = {};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("", result);
    }

    @Test
    void givenArrayWithEmptyString_whenLongestCommonPrefix_thenReturnsEmptyString() {
        // Given
        String[] input = {"", "nonempty", "another"};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("", result);
    }

    @Test
    void givenLongStringsWithShortCommonPrefix_whenLongestCommonPrefix_thenReturnsShortPrefix() {
        // Given
        String[] input = {"abcdefghijk", "abcxyz", "abc123456"};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("abc", result);
    }

    @Test
    void givenMixedCaseStrings_whenLongestCommonPrefix_thenHandlesCaseSensitivity() {
        // Given
        String[] input = {"Prefix", "preface", "preform"};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("", result); // Case-sensitive comparison
    }

    @Test
    void givenStringsWithSpecialCharacters_whenLongestCommonPrefix_thenReturnsCorrectPrefix() {
        // Given
        String[] input = {"#hashtag", "#hash", "#hammer"};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("#ha", result);
    }

    @Test
    void givenWhitespacePrefix_whenLongestCommonPrefix_thenReturnsWhitespacePrefix() {
        // Given
        String[] input = {"   indent", "   index", "   inside"};

        // When
        String result = lcpSolver.longestCommonPrefix(input);

        // Then
        assertEquals("   in", result);
    }

}