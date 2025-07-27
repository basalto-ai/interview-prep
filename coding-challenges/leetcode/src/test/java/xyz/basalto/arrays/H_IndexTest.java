package xyz.basalto.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class H_IndexTest {

    @Test
    void givenMixedCitations_whenHIndex_thenReturnsCorrectHIndex() {
        int[] citations = {3, 0, 6, 1, 5};
        int expected = 3;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenAllZeros_whenHIndex_thenReturnsZero() {
        int[] citations = {0, 0, 0, 0};
        int expected = 0;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenSinglePaper_whenHIndex_thenReturnsOneIfCited() {
        int[] citations = {5};
        int expected = 1;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenSinglePaperUncited_whenHIndex_thenReturnsZero() {
        int[] citations = {0};
        int expected = 0;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenUniformCitations_whenHIndex_thenReturnsThatValue() {
        int[] citations = {4, 4, 4, 4};
        int expected = 4;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenReverseSortedCitations_whenHIndex_thenReturnsCorrectHIndex() {
        int[] citations = {10, 8, 5, 4, 3};
        int expected = 4;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenSortedAscendingCitations_whenHIndex_thenReturnsCorrectHIndex() {
        int[] citations = {0, 1, 3, 5, 6};
        int expected = 3;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenLargeGapCitations_whenHIndex_thenReturnsCorrectHIndex() {
        int[] citations = {0, 0, 0, 1, 20, 30, 40};
        int expected = 3;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenCitationsWithDuplicates_whenHIndex_thenReturnsCorrectHIndex() {
        int[] citations = {1, 2, 2, 3, 3, 4, 4, 5};
        int expected = 3;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenEmptyArray_whenHIndex_thenReturnsZero() {
        int[] citations = {};
        int expected = 0;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    void givenTenCitationsWithDuplicates_whenHIndex_thenReturnsCorrectHIndex() {
        int[] citations = {6, 0, 3, 5, 2, 8, 10, 3, 1, 7, 4, 3};
        int expected = 5;
        int actual = H_Index.hIndex(citations);
        assertEquals(expected, actual);
    }

}