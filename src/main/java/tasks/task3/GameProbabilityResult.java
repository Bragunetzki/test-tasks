package tasks.task3;

/**
 * A record storing the calculated probability of each game outcome.
 *
 * @param player1VictoryProbability the probability of the first player's victory.
 * @param player2VictoryProbability the probability of the second player's victory.
 * @param drawProbability the probability of a draw occuring.
 */
public record GameProbabilityResult(double player1VictoryProbability, double player2VictoryProbability,
                                    double drawProbability) {
}
