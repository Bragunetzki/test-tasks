package tasks.task2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    public void testEmpty() {
        assertTrue(Task2.findMostCommonNumbers(new int[0]).isEmpty());
    }

    @Test
    public void testSingle() {
        List<Integer> elems = Task2.findMostCommonNumbers(new int[]{5});
        assertEquals(elems.get(0), 5);
    }

    @Test
    public void testAllMostCommon() {
        List<Integer> elems = Task2.findMostCommonNumbers(new int[]{1, 2, 3});
        Collections.sort(elems);
        List<Integer> target = Arrays.asList(1, 2, 3);
        assertEquals(elems, target);
    }

    @Test
    public void testSingleMostCommon() {
        List<Integer> elems = Task2.findMostCommonNumbers(new int[]{1, 1, 1, 2, 2, 3, 3});
        Collections.sort(elems);
        List<Integer> target = List.of(1);
        assertEquals(elems, target);
    }

    @Test
    public void testSeveralMostCommon() {
        List<Integer> elems = Task2.findMostCommonNumbers(new int[]{1, 2, 2, 3, 3});
        Collections.sort(elems);
        List<Integer> target = Arrays.asList(2, 3);
        assertEquals(elems, target);
    }
}