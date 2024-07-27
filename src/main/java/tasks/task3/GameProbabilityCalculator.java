package tasks.task3;

import java.util.List;

/**
 * Utility class for calculating the game outcome probabilities.
 */
public class GameProbabilityCalculator {
    private final int rollsTotal;
    private final GameEmulator gameEmulator;

    /**
     * Constructs a new probability calculator based on the two specified player sequences and total rolls per game.
     *
     * @param sequence1 the first player's sequence.
     * @param sequence2 the second player's sequence.
     * @param rollsTotal the total rolls made for each game.
     */
    public GameProbabilityCalculator(List<Integer> sequence1, List<Integer> sequence2, int rollsTotal) {
        gameEmulator = new GameEmulator(new PlayerEmulator(sequence1), new PlayerEmulator(sequence2));
        this.rollsTotal = rollsTotal;
    }

    /**
     * Calculates the approximate probabilities of each outcome using a Monte Carlo approach.
     *
     * @param totalTests the total number of games that will be tested.
     * @return a {@link GameProbabilityResult} with the calculated probabilities of each possible game outcome.
     */
    public GameProbabilityResult calculateApproximate(int totalTests) {
        int player1Victories = 0, player2Victories = 0, draws = 0;
        if (totalTests <= 0) {
            return new GameProbabilityResult(0, 0, 1);
        }

        for (int i = 0; i < totalTests; i++) {
            GameResult result = gameEmulator.runGame(rollsTotal);
            switch (result) {
                case Player1Won -> player1Victories++;
                case Draw -> draws++;
                case Player2Won -> player2Victories++;
            }
        }

        double player1Prob = (double) player1Victories / totalTests;
        double player2Prob = (double) player2Victories / totalTests;
        double drawProb = (double) draws / totalTests;
        return new GameProbabilityResult(player1Prob, player2Prob, drawProb);
    }
}
