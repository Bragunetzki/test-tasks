package tasks.task3;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Represents a game of dice for task 3.
 */
public class GameEmulator {
    private final PlayerEmulator player1;
    private final PlayerEmulator player2;

    /**
     * Constructs a new game with the two provided players.
     *
     * @param player1 the first player.
     * @param player2 the second player.
     */
    public GameEmulator(PlayerEmulator player1, PlayerEmulator player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Runs the game for the specified number of rolls and produces a corresponding game outcome.
     *
     * @param totalRolls the number of rolls to be made for this game in total.
     * @return a {@link GameResult} enum representing the game's outcome.
     */
    public GameResult runGame(int totalRolls) {
        player1.reset();
        player2.reset();

        Random random = new Random();
        IntStream dieRolls = random.ints(totalRolls, 1, 7);

        dieRolls.forEach(roll -> {
            player1.processRoll(roll);
            player2.processRoll(roll);
        });

        if (player1.getPoints() > player2.getPoints()) {
            return GameResult.Player1Won;
        }
        else if (player1.getPoints() < player2.getPoints()) {
            return GameResult.Player2Won;
        }
        return GameResult.Draw;
    }
}
