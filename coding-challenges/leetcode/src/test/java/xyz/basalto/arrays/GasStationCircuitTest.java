package xyz.basalto.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasStationCircuitTest {

    private final GasStationCircuit gasStation = new GasStationCircuit();

    @Test
    void givenSimpleFeasibleRoute_whenCanCompleteCircuit_thenReturnsStartIndex() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(3, result);
    }

    @Test
    void givenEqualGasAndCost_whenCanCompleteCircuit_thenReturnsZero() {
        int[] gas = {2, 3, 4};
        int[] cost = {2, 3, 4};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(0, result); // All start points valid; 0 is the first
    }

    @Test
    void givenImpossibleRoute_whenCanCompleteCircuit_thenReturnsMinusOne() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(-1, result);
    }

    @Test
    void givenMultipleStartOptions_whenCanCompleteCircuit_thenReturnsFirstValidStart() {
        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(4, result);
    }

    @Test
    void givenSingleStationWithSurplusGas_whenCanCompleteCircuit_thenReturnsZero() {
        int[] gas = {5};
        int[] cost = {4};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(0, result);
    }

    @Test
    void givenSingleStationWithInsufficientGas_whenCanCompleteCircuit_thenReturnsMinusOne() {
        int[] gas = {1};
        int[] cost = {2};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(-1, result);
    }

    @Test
    void givenLargeBalancedRoute_whenCanCompleteCircuit_thenReturnsCorrectIndex() {
        int[] gas = {3, 3, 4, 5, 1, 2, 6, 4, 3, 7};
        int[] cost = {4, 2, 3, 2, 1, 3, 2, 5, 2, 4};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(1, result); // Based on simulation
    }

    @Test
    void givenLargeImbalancedRoute_whenCanCompleteCircuit_thenReturnsMinusOne() {
        int[] gas = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] cost = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(-1, result);
    }

    @Test
    void givenSurplusAtEndOnly_whenCanCompleteCircuit_thenReturnsLastIndex() {
        int[] gas = {1, 1, 1, 10};
        int[] cost = {2, 2, 2, 1};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(3, result);
    }

    @Test
    void givenZeroGasAndCost_whenCanCompleteCircuit_thenReturnsZero() {
        int[] gas = {0, 0, 0};
        int[] cost = {0, 0, 0};
        int result = gasStation.canCompleteCircuit(gas, cost);
        assertEquals(0, result);
    }

}