package xyz.basalto.arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BestTimeToBuyAndSellStockIITest {

    private final BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();

    @Test
    void givenAscendingPrices_whenMaxProfit_thenReturnFullProfit() {
        int[] prices = {1, 2, 3, 4, 5};
        assertEquals(4, solution.maxProfit(prices));
    }

    @Test
    void givenDescendingPrices_whenMaxProfit_thenReturnZeroProfit() {
        int[] prices = {5, 4, 3, 2, 1};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void givenFluctuatingPrices_whenMaxProfit_thenReturnSumOfAllPositiveDiffs() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(7, solution.maxProfit(prices));
    }

    @Test
    void givenSingleDay_whenMaxProfit_thenReturnZero() {
        int[] prices = {10};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void givenEmptyArray_whenMaxProfit_thenReturnZero() {
        int[] prices = {};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void givenSamePriceRepeated_whenMaxProfit_thenReturnZero() {
        int[] prices = {4, 4, 4, 4};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void givenSpikeInMiddle_whenMaxProfit_thenReturnSegmentProfit() {
        int[] prices = {1, 5, 3, 8};
        assertEquals(9, solution.maxProfit(prices)); // (5-1) + (8-3)
    }

    @Test
    void givenMultipleOpportunities_whenMaxProfit_thenReturnSumOfAll() {
        int[] prices = {2, 4, 1, 7, 5, 10};
        assertEquals(13, solution.maxProfit(prices)); // (4-2) + (7-1) + (10-5)
    }
    
}
