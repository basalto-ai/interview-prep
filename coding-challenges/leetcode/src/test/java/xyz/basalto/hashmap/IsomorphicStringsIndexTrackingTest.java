package xyz.basalto.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsomorphicStringsIndexTrackingTest {

    private final IsomorphicStringsIndexTracking checker = new IsomorphicStringsIndexTracking();

    @Test
    void givenIdenticalStrings_whenCheckIsomorphic_thenReturnTrue() {
        assertTrue(checker.isIsomorphic("abc", "abc"));
    }

    @Test
    void givenValidIsomorphicStrings_whenCheckIsomorphic_thenReturnTrue() {
        assertTrue(checker.isIsomorphic("egg", "add"));
        assertTrue(checker.isIsomorphic("paper", "title"));
        assertTrue(checker.isIsomorphic("foo", "app"));
        assertTrue(checker.isIsomorphic("aab", "xxy"));
        assertTrue(checker.isIsomorphic("abab", "cdcd"));
    }

    @Test
    void givenInvalidIsomorphicStrings_whenCheckIsomorphic_thenReturnFalse() {
        assertFalse(checker.isIsomorphic("foo", "bar"));
        assertFalse(checker.isIsomorphic("ab", "aa"));
        assertFalse(checker.isIsomorphic("aba", "baa"));
        assertFalse(checker.isIsomorphic("abc", "ddd"));
        assertFalse(checker.isIsomorphic("aaaa", "bcde"));
    }

    @Test
    void givenEmptyStrings_whenCheckIsomorphic_thenReturnTrue() {
        assertTrue(checker.isIsomorphic("", ""));
    }

    @Test
    void givenSingleCharStrings_whenCheckIsomorphic_thenReturnTrue() {
        assertTrue(checker.isIsomorphic("a", "z"));
        assertTrue(checker.isIsomorphic("x", "x"));
    }

    @Test
    void givenLongValidIsomorphicStrings_whenCheckIsomorphic_thenReturnTrue() {
        assertTrue(checker.isIsomorphic("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"));
    }

    @Test
    void givenLongInvalidIsomorphicStrings_whenCheckIsomorphic_thenReturnFalse() {
        assertFalse(checker.isIsomorphic("abcdefghijklmnopqrstuvwxyz", "aaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    void givenRepeatingPatternMismatch_whenCheckIsomorphic_thenReturnFalse() {
        assertFalse(checker.isIsomorphic("abca", "zbxy"));
    }

    @Test
    void givenStringsOfDifferentLengths_whenCheckIsomorphic_thenReturnFalse() {
        assertFalse(checker.isIsomorphic("ab", "abc"));
        assertFalse(checker.isIsomorphic("abc", "ab"));
    }

    @Test
    void givenExtendedAsciiInput_whenCheckIsomorphic_thenReturnTrue() {
        assertTrue(checker.isIsomorphic("ññçç", "aabb"));
    }

}