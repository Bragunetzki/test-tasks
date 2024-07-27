package tasks.task3;

import java.util.List;

/**
 * A class that models a player within the game.
 */
public class PlayerEmulator {
    private int points = 0;
    private int currentSequenceIndex = 0;
    private final List<Integer> sequence;

    /**
     * Constructs a PlayerEmulator with the specified sequence.
     *
     * @param sequence the die roll sequence corresponding to this player. It must contain exactly three integers between 1 and 6 inclusively.
     */
    public PlayerEmulator(List<Integer> sequence) {
        if (sequence.size() != 3)
            throw new IllegalArgumentException("Sequence must contain three rolls.");
        if (!sequence.stream().allMatch(i -> i >= 1 && i <= 6))
            throw new IllegalArgumentException("Rolls must be between 1 and 6.");
        this.sequence = sequence;
    }

    /**
     * Processes the result of a die roll from a sequence of rolls and update the player's state respectively.
     *
     * @param roll the die roll to be processed.
     */
    public void processRoll(int roll) {
        if (sequence.get(currentSequenceIndex) == roll) {
            currentSequenceIndex++;
        } else {
            currentSequenceIndex = sequence.get(0) == roll ? 1 : 0;
        }

        if (currentSequenceIndex > 2) {
            points++;
            currentSequenceIndex = 0;
        }
    }

    /**
     * Returns the player's current points.
     *
     * @return the player's current point total.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Resets the player's state as if a new game has begun. Also resets the player's points to zero.
     */
    public void reset() {
        points = 0;
        currentSequenceIndex = 0;
    }
}
