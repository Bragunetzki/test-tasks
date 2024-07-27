package tasks.task4;

import java.util.*;

/**
 * Class for running examples of task 4.
 */
public class Task4 {
    /**
     * Asks the user to enter K. Randomly generates an initial array and attempts to split it into K parts.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите K: ");
        int k = scanner.nextInt();

        Random random = new Random();
        List<Integer> list = random.ints(10, 1, 21).boxed().toList();
        System.out.println("Исходные данные: " + list);

        List<List<Integer>> partitions = kSplit(list, k);
        if (partitions == null) {
            System.out.println("Разделить невозможно.");
        }
        else {
            System.out.println("Данные после разделения: ");
            for (int i = 0; i < k; i++) {
                System.out.println(partitions.get(i) + ", " + sumList(partitions.get(i)));
            }
        }
    }

    /**
     * Attempts to split the list into K parts as per task 4.
     *
     * @param list the list which is partitioned.
     * @param k the number of parts the list needs to be split into.
     * @return a list of lists, representing the element partitions. If no valid partition is possible, returns null.
     */
    public static List<List<Integer>> kSplit(List<Integer> list, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("K must be a positive number.");
        }

        int arraySum = list.stream().mapToInt(Integer::intValue).sum();
        int progressionSum = k / 2 * (k - 1);
        // check if L is a whole number.
        if ((arraySum - progressionSum) % k != 0) {
            return null;
        }
        int l = (arraySum - progressionSum) / k;

        int[] targetSums = new int[k];
        for (int i = 0; i < k; i++) {
            targetSums[i] = l + i;
        }

        List<List<Integer>> partitions = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            partitions.add(new ArrayList<>());
        }

        if (tryPartition(list, targetSums, partitions, 0)) {
            return partitions;
        }
        return null;
    }

    /**
     * Recursively attempts to partition the list. If no valid partition is possible, backtracks and cancels some actions.
     *
     * @param list the list which is partitioned.
     * @param targetSums the current remaining target sums of each partition.
     * @param partitions a list of lists, representing the element partitions.
     * @param currentIndex the index of the element currently being assigned to a partition.
     * @return true if the partition is successful, false otherwise.
     */
    private static boolean tryPartition(List<Integer> list, int[] targetSums, List<List<Integer>> partitions, int currentIndex) {
        // reached last number
        if (currentIndex == list.size()) {
            // returns true if all target sums are at zero
            return Arrays.stream(targetSums).noneMatch(s -> s != 0);
        }

        int currentNum = list.get(currentIndex);

        for (int i = 0; i < targetSums.length; i++) {
            if (currentNum <= targetSums[i]) {
                targetSums[i] -= currentNum;
                partitions.get(i).add(currentNum);

                if (tryPartition(list, targetSums, partitions, currentIndex + 1)) {
                    return true;
                }

                // cancel changes
                targetSums[i] += currentNum;
                partitions.get(i).remove(partitions.get(i).size() - 1);
            }
        }

        return false;
    }

    /**
     * Utility method for summing all elements in an Integer list.
     *
     * @param list list where the summed values are taken from.
     * @return a sum of elements within the list.
     */
    private static int sumList(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
}
