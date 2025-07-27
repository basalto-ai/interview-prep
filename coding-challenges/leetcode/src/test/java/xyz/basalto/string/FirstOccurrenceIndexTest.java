package xyz.basalto.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstOccurrenceIndexTest {

    private final FirstOccurrenceIndex finder = new FirstOccurrenceIndex();

    @Test
    void givenNeedleInMiddle_whenStrStr_thenReturnsCorrectIndex() {
        // Given
        String haystack = "thisisaverylongtext";
        String needle = "very";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(7, index);
    }

    @Test
    void givenNeedleAtStart_whenStrStr_thenReturnsZero() {
        // Given
        String haystack = "startmatchhere";
        String needle = "start";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(0, index);
    }

    @Test
    void givenNeedleAtEnd_whenStrStr_thenReturnsCorrectIndex() {
        // Given
        String haystack = "matchattheend";
        String needle = "end";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(10, index);
    }

    @Test
    void givenNoMatch_whenStrStr_thenReturnsMinusOne() {
        // Given
        String haystack = "abcdefgh";
        String needle = "xyz";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(-1, index);
    }

    @Test
    void givenEmptyNeedle_whenStrStr_thenReturnsZero() {
        // Given
        String haystack = "some text here";
        String needle = "";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(0, index);
    }

    @Test
    void givenIdenticalHaystackAndNeedle_whenStrStr_thenReturnsZero() {
        // Given
        String haystack = "matchme";
        String needle = "matchme";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(0, index);
    }

    @Test
    void givenNeedleLongerThanHaystack_whenStrStr_thenReturnsMinusOne() {
        // Given
        String haystack = "short";
        String needle = "longneedle";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(-1, index);
    }

    @Test
    void givenHaystackEmpty_whenStrStr_thenReturnsMinusOne() {
        // Given
        String haystack = "";
        String needle = "nonempty";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(-1, index);
    }

    @Test
    void givenHaystackAndNeedleBothEmpty_whenStrStr_thenReturnsZero() {
        // Given
        String haystack = "";
        String needle = "";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(0, index);
    }

    @Test
    void givenNeedleWithRepeatingCharacters_whenStrStr_thenReturnsCorrectIndex() {
        // Given
        String haystack = "aaaabaaaac";
        String needle = "aaac";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(6, index);
    }

    @Test
    void givenMultiplePossibleMatches_whenStrStr_thenReturnsFirstOccurrence() {
        // Given
        String haystack = "ababcabcababc";
        String needle = "abc";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(2, index);
    }

    @Test
    void givenWhitespaceCharacters_whenStrStr_thenReturnsCorrectIndex() {
        // Given
        String haystack = "text with    spaces";
        String needle = "    ";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(9, index);
    }

    @Test
    void givenSpecialCharacters_whenStrStr_thenHandlesCorrectly() {
        // Given
        String haystack = "find$me$now";
        String needle = "$me$";

        // When
        int index = finder.strStr(haystack, needle);

        // Then
        assertEquals(4, index);
    }

}