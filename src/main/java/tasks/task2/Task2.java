package tasks.task2;

import java.util.*;

/**
 * Class for running an example for task 2. Generates an array with random integers from 1 to 10, prints the initial data and the most common values.
 */
public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = random.ints(10, 1, 11).toArray();
        System.out.println("Initial data: " + Arrays.toString(array));
        List<Integer> mostCommonValues = findMostCommonNumbers(array);
        System.out.println("Most common values: " + mostCommonValues);
    }

    /**
     * Returns a list of most common integers within an array.
     *
     * @param array the array which will be searched.
     * @return a {@link List} of Integers containing the most common value or values within the array. If the array is empty, returns an empty list.
     */
    public static List<Integer> findMostCommonNumbers(int[] array) {
        List<Integer> mostCommonNumbers = new ArrayList<>();
        if (array.length <= 0) {
            return mostCommonNumbers;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : array) {
            frequencyMap.merge(i, 1, Integer::sum);
        }
        int maxFreq = Collections.max(frequencyMap.values());

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                mostCommonNumbers.add(entry.getKey());
            }
        }
        return mostCommonNumbers;
    }
}
