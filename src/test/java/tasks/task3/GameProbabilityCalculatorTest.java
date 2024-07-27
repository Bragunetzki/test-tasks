package tasks.task3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameProbabilityCalculatorTest {

    @Test
    public void testConstructor() {
        List<Integer> sequence1 = List.of(1, 2, 3);
        List<Integer> sequence2 = List.of(4, 5, 6);
        int rollsTotal = 10;
        GameProbabilityCalculator calculator = new GameProbabilityCalculator(sequence1, sequence2, rollsTotal);
        assertNotNull(calculator);
    }

    @Test
    void testConstructorWithEmptySequences() {
        List<Integer> sequence1 = List.of();
        List<Integer> sequence2 = List.of();
        int rollsTotal = 10;
        assertThrows(IllegalArgumentException.class, () -> new GameProbabilityCalculator(sequence1, sequence2, rollsTotal));
    }

    @Test
    void testCalculateApproximateWithValidTotalTests() {
        List<Integer> sequence1 = List.of(1, 2, 3);
        List<Integer> sequence2 = List.of(4, 5, 6);
        int rollsTotal = 10;
        GameProbabilityCalculator calculator = new GameProbabilityCalculator(sequence1, sequence2, rollsTotal);
        GameProbabilityResult result = calculator.calculateApproximate(10);
        assertEquals(result.player2VictoryProbability() + result.player1VictoryProbability() + result.drawProbability(), 1);
    }

    @Test
    void testCalculateApproximateWithSameSequences() {
        List<Integer> sequence1 = List.of(1, 2, 3);
        List<Integer> sequence2 = List.of(1, 2, 3);
        int rollsTotal = 10;
        GameProbabilityCalculator calculator = new GameProbabilityCalculator(sequence1, sequence2, rollsTotal);
        GameProbabilityResult result = calculator.calculateApproximate(10);
        assertEquals(result.drawProbability(), 1);
        assertEquals(result.player1VictoryProbability(), 0);
        assertEquals(result.player2VictoryProbability(), 0);
    }

    @Test
    void testCalculateApproximateWithNoRolls() {
        List<Integer> sequence1 = List.of(1, 2, 3);
        List<Integer> sequence2 = List.of(4, 5, 6);
        int rollsTotal = 10;
        GameProbabilityCalculator calculator = new GameProbabilityCalculator(sequence1, sequence2, 0);
        GameProbabilityResult result = calculator.calculateApproximate(10);
        assertEquals(result.drawProbability(), 1);
        assertEquals(result.player1VictoryProbability(), 0);
        assertEquals(result.player2VictoryProbability(), 0);
    }

    @Test
    void testCalculateApproximateWithNegativeRolls() {
        List<Integer> sequence1 = List.of(1, 2, 3);
        List<Integer> sequence2 = List.of(4, 5, 6);
        GameProbabilityCalculator calculator = new GameProbabilityCalculator(sequence1, sequence2, -1);
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateApproximate(10));
    }

    @Test
    void testCalculateApproximateWithZeroGames() {
        List<Integer> sequence1 = List.of(1, 2, 3);
        List<Integer> sequence2 = List.of(4, 5, 6);
        GameProbabilityCalculator calculator = new GameProbabilityCalculator(sequence1, sequence2, 10);
        GameProbabilityResult result = calculator.calculateApproximate(0);
        assertEquals(result.drawProbability(), 1);
        assertEquals(result.player1VictoryProbability(), 0);
        assertEquals(result.player2VictoryProbability(), 0);
    }

    @Test
    void testCalculateApproximateWithNegativeGames() {
        List<Integer> sequence1 = List.of(1, 2, 3);
        List<Integer> sequence2 = List.of(4, 5, 6);
        GameProbabilityCalculator calculator = new GameProbabilityCalculator(sequence1, sequence2, 10);
        GameProbabilityResult result = calculator.calculateApproximate(-5);
        assertEquals(result.drawProbability(), 1);
        assertEquals(result.player1VictoryProbability(), 0);
        assertEquals(result.player2VictoryProbability(), 0);
    }
}