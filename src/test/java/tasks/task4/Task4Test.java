package tasks.task4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    public void testExample1() {
        List<Integer> list = Arrays.asList(10, 11, 7, 7, 12);
        List<List<Integer>> partitions = Task4.kSplit(list, 2);
        assertNotNull(partitions);
        assertEquals(partitions.get(0), Arrays.asList(11, 12));
        assertEquals(partitions.get(1), Arrays.asList(10, 7, 7));
    }

    @Test
    public void testExample2() {
        List<Integer> list = Arrays.asList(5, 2, 6, 4, 3, 6);
        List<List<Integer>> partitions = Task4.kSplit(list, 4);
        assertNotNull(partitions);
        assertEquals(partitions.get(0), List.of(5));
        assertEquals(partitions.get(1), List.of(6));
        assertEquals(partitions.get(2), Arrays.asList(4, 3));
        assertEquals(partitions.get(3), Arrays.asList(2, 6));
    }

    @Test
    public void testExample3() {
        List<Integer> list = Arrays.asList(7, 8, 12, 11);
        List<List<Integer>> partitions = Task4.kSplit(list, 3);
        assertNull(partitions);
    }

    @Test
    public void testIllegalK() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> Task4.kSplit(list, -1));
    }

    @Test
    public void testNoDivisionByK() {
        List<Integer> list = Arrays.asList(5, 2, 7, 4, 3, 6);
        List<List<Integer>> partitions = Task4.kSplit(list, 4);
        assertNull(partitions);
    }

    @Test
    public void testSums() {
        List<Integer> list = Arrays.asList(4, 4, 4, 5, 5, 5, 5, 6);
        List<List<Integer>> partitions = Task4.kSplit(list, 4);
        assertNotNull(partitions);

        int sum1 = partitions.get(0).stream().reduce(0, Integer::sum);
        int sum2 = partitions.get(1).stream().reduce(0, Integer::sum);
        int sum3 = partitions.get(2).stream().reduce(0, Integer::sum);
        int sum4 = partitions.get(3).stream().reduce(0, Integer::sum);

        assertEquals(sum1, 8);
        assertEquals(sum2, 9);
        assertEquals(sum3, 10);
        assertEquals(sum4, 11);

        assertEquals(list.stream().reduce(0, Integer::sum), sum1 + sum2 + sum3 + sum4);
    }
}