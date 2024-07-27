package tasks.task1;

import java.util.Comparator;

/**
 * Custom Integer comparator class for task 1. First, will place odd elements in non-descending order.
 * Then places zeroes. All remaining elements are then placed in non-ascending order.
 */
public class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        if (a % 2 != 0 && b % 2 != 0) {
            return Integer.compare(a, b);
        }
        if (a % 2 != 0) {
            return -1;
        }
        if (b % 2 != 0) {
            return 1;
        }
        if (a != 0 && b != 0) {
            return Integer.compare(b, a);
        }
        if (a != 0) {
            return 1;
        }
        if (b != 0) {
            return -1;
        }
        return 0;
    }
}
