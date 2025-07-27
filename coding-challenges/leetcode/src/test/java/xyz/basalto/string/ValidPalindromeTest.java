package xyz.basalto.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    private final ValidPalindrome validator = new ValidPalindrome();

    @Test
    void givenSimplePalindrome_whenIsPalindrome_thenReturnsTrue() {
        String input = "madam";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenMixedCasePalindrome_whenIsPalindrome_thenReturnsTrue() {
        String input = "RaceCar";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenPalindromeWithPunctuation_whenIsPalindrome_thenReturnsTrue() {
        String input = "A man, a plan, a canal: Panama";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenNonPalindrome_whenIsPalindrome_thenReturnsFalse() {
        String input = "hello";
        boolean result = validator.isPalindrome(input);
        assertFalse(result);
    }

    @Test
    void givenEmptyString_whenIsPalindrome_thenReturnsTrue() {
        String input = "";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenOnlySpaces_whenIsPalindrome_thenReturnsTrue() {
        String input = "     ";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenOnlySpecialCharacters_whenIsPalindrome_thenReturnsTrue() {
        String input = "@#$%^&*()";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenSingleCharacter_whenIsPalindrome_thenReturnsTrue() {
        String input = "z";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenNumericPalindrome_whenIsPalindrome_thenReturnsTrue() {
        String input = "12321";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenAlphaNumericPalindrome_whenIsPalindrome_thenReturnsTrue() {
        String input = "1a2b2a1";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenAlphaNumericNonPalindrome_whenIsPalindrome_thenReturnsFalse() {
        String input = "1a2b3c";
        boolean result = validator.isPalindrome(input);
        assertFalse(result);
    }

    @Test
    void givenUnicodePalindrome_whenIsPalindrome_thenReturnsTrue() {
        String input = "Åbççbå";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenUnicodeWithPunctuation_whenIsPalindrome_thenReturnsTrue() {
        String input = "À@b!b@à";
        boolean result = validator.isPalindrome(input);
        assertTrue(result);
    }

    @Test
    void givenNullInput_whenIsPalindrome_thenReturnsFalse() {
        String input = null;
        boolean result = validator.isPalindrome(input);
        assertFalse(result);
    }

}