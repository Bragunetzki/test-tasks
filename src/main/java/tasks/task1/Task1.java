package tasks.task1;

import java.util.Arrays;
import java.util.Random;

/**
 * Class for running an example of task 1. Generates an array with random integers
 * and sorts it using a custom comparator.
 */
public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = random.ints(10).toArray();

        System.out.println("Unsorted: " + Arrays.toString(array));

        Integer[] sortedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedArray, new CustomComparator());

        System.out.println("Sorted:   " + Arrays.toString(sortedArray));
    }
}
