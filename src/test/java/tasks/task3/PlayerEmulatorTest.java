package tasks.task3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerEmulatorTest {
    @Test
    public void testIllegalSequenceSize() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerEmulator(Arrays.asList(1, 1, 1, 1)));
        assertThrows(IllegalArgumentException.class, () -> new PlayerEmulator(Arrays.asList(1, 1)));
    }

    @Test
    public void testIllegalSequenceValues() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerEmulator(Arrays.asList(0, 1, 2)));
        assertThrows(IllegalArgumentException.class, () -> new PlayerEmulator(Arrays.asList(3, 4, 7)));
    }

    @Test
    public void testExample1() {
        Stream<Integer> rolls = Stream.of(1, 4, 2, 4, 4, 4, 4, 4, 2, 4);
        PlayerEmulator player1 = new PlayerEmulator(Arrays.asList(4, 2, 4));
        PlayerEmulator player2 = new PlayerEmulator(Arrays.asList(4, 4, 4));

        rolls.forEach(roll -> {
            player1.processRoll(roll);
            player2.processRoll(roll);
        });

        assertEquals(player1.getPoints(), 2);
        assertEquals(player2.getPoints(), 1);
    }

    @Test
    public void testExample2() {
        Stream<Integer> rolls = Stream.of(1, 4, 2, 4, 4, 4, 4, 4, 4, 4);
        PlayerEmulator player1 = new PlayerEmulator(Arrays.asList(4, 2, 4));
        PlayerEmulator player2 = new PlayerEmulator(Arrays.asList(4, 4, 4));

        rolls.forEach(roll -> {
            player1.processRoll(roll);
            player2.processRoll(roll);
        });

        assertEquals(player1.getPoints(), 1);
        assertEquals(player2.getPoints(), 2);
    }

    @Test
    public void testExample3() {
        Stream<Integer> rolls = Stream.of(4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 1);
        PlayerEmulator player1 = new PlayerEmulator(Arrays.asList(4, 2, 4));
        PlayerEmulator player2 = new PlayerEmulator(Arrays.asList(2, 4, 2));

        rolls.forEach(roll -> {
            player1.processRoll(roll);
            player2.processRoll(roll);
        });

        assertEquals(player1.getPoints(), 3);
        assertEquals(player2.getPoints(), 2);
    }

    @Test
    public void testExample4() {
        Stream<Integer> rolls = Stream.of(2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1);
        PlayerEmulator player1 = new PlayerEmulator(Arrays.asList(1, 2, 3));
        PlayerEmulator player2 = new PlayerEmulator(Arrays.asList(2, 3, 1));

        rolls.forEach(roll -> {
            player1.processRoll(roll);
            player2.processRoll(roll);
        });

        assertEquals(player1.getPoints(), 3);
        assertEquals(player2.getPoints(), 4);
    }

    @Test
    public void testExample5() {
        Stream<Integer> rolls = Stream.of(1, 2, 4, 3, 5, 5, 2, 3, 4, 5, 5, 5);
        PlayerEmulator player1 = new PlayerEmulator(Arrays.asList(1, 2, 3));
        PlayerEmulator player2 = new PlayerEmulator(Arrays.asList(4, 5, 5));

        rolls.forEach(roll -> {
            player1.processRoll(roll);
            player2.processRoll(roll);
        });

        assertEquals(player1.getPoints(), 0);
        assertEquals(player2.getPoints(), 1);
    }

    @Test
    public void resetTest() {
        Stream<Integer> rolls = Stream.of(1, 2, 3, 1, 2, 3, 1, 2, 3);
        PlayerEmulator player1 = new PlayerEmulator(Arrays.asList(1, 2, 3));
        rolls.forEach(player1::processRoll);
        assertEquals(player1.getPoints(), 3);
        player1.reset();
        assertEquals(player1.getPoints(), 0);
    }
}