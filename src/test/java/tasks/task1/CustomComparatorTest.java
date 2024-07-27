package tasks.task1;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.lang.Integer.signum;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the custom comparator from task 1.
 */
class CustomComparatorTest {
    /**
     * Test for two odd values.
     */
    @Test
    public void testBothOdd() {
        Comparator<Integer> comp = new CustomComparator();

        int a = 5;
        int b = 7;
        assertTrue(comp.compare(a, b) < 0);
        assertEquals(signum(comp.compare(a, b)), -signum(comp.compare(b, a)));

        b = a;
        assertEquals(0, comp.compare(a, b), comp.compare(b, a));
    }

    /**
     * Test for an odd value and zero.
     */
    @Test
    public void testOddAndZero() {
        Comparator<Integer> comp = new CustomComparator();

        int a = 9;
        int b = 0;
        assertTrue(comp.compare(a, b) < 0);
        assertEquals(signum(comp.compare(a, b)), -signum(comp.compare(b, a)));
    }

    /**
     * Test for an odd value and an even value.
     */
    @Test
    public void testOddAndEven() {
        Comparator<Integer> comp = new CustomComparator();

        int a = 11;
        int b = 4;
        assertTrue(comp.compare(a, b) < 0);
        assertEquals(signum(comp.compare(a, b)), -signum(comp.compare(b, a)));
    }

    /**
     * Test for an even value and zero.
     */
    @Test
    public void testEvenAndZero() {
        Comparator<Integer> comp = new CustomComparator();

        int a = 24;
        int b = 0;
        assertTrue(comp.compare(a, b) > 0);
        assertEquals(signum(comp.compare(a, b)), -signum(comp.compare(b, a)));
    }

    /**
     * Test for two even values.
     */
    @Test
    public void testBothEven() {
        Comparator<Integer> comp = new CustomComparator();

        int a = 22;
        int b = 14;
        assertTrue(comp.compare(a, b) < 0);
        assertEquals(signum(comp.compare(a, b)), -signum(comp.compare(b, a)));

        b = a;
        assertEquals(0, comp.compare(a, b), comp.compare(b, a));
    }

    /**
     * Test for two zeroes.
     */
    @Test
    public void testBothZero() {
        Comparator<Integer> comp = new CustomComparator();

        int a = 0;
        int b = 0;
        assertEquals(comp.compare(a, b), comp.compare(b, a), 0);
    }

    /**
     * Shuffles a sorted array and sorts it using the custom comparator. Then checks that the sorting was successful.
     */
    @Test
    public void testArray() {
        Integer[] target = new Integer[]{-5, -5, 3, 9, 11, 0, 0, 0, 0, 0, 20, 4, 4, -6, -8};

        Comparator<Integer> comp = new CustomComparator();
        // make sure target is sorted
        for (int i = 0; i < target.length - 1; i++) {
            assertTrue(comp.compare(target[i], target[i + 1]) <= 0);
        }

        // copy and shuffle the array
        List<Integer> list = Arrays.asList(Arrays.copyOf(target, target.length));
        Collections.shuffle(list);
        Integer[] shuffledArr = new Integer[list.size()];
        list.toArray(shuffledArr);

        Arrays.sort(shuffledArr, new CustomComparator());
        // make sure shuffled array is now sorted
        for (int i = 0; i < shuffledArr.length - 1; i++) {
            assertTrue(comp.compare(shuffledArr[i], shuffledArr[i + 1]) <= 0);
        }
    }
}