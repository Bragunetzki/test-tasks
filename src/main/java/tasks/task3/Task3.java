package tasks.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for running an example of task 3. Asks the user to enter the player sequences, the number of rolls per game, and the number of games to be tested.
 * The approximate probabilities are then calculated using a Monte Carlo approach.
 */
public class Task3 {
    public static void main(String[] args) {
        List<Integer> sequence1 = new ArrayList<>();
        List<Integer> sequence2 = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first player sequence line by line:");
        sequence1.add(scanner.nextInt());
        sequence1.add(scanner.nextInt());
        sequence1.add(scanner.nextInt());
        System.out.println("Enter the second player sequence line by line:");
        sequence2.add(scanner.nextInt());
        sequence2.add(scanner.nextInt());
        sequence2.add(scanner.nextInt());
        System.out.println("Enter the total number of rolls per game:");
        int rollsTotal = scanner.nextInt();
        System.out.println("Enter the total number of games to be tested:");
        int testsTotal = scanner.nextInt();
        scanner.close();

        GameProbabilityCalculator gameProbabilityCalculator = new GameProbabilityCalculator(sequence1, sequence2, rollsTotal);
        GameProbabilityResult probabilities = gameProbabilityCalculator.calculateApproximate(testsTotal);

        System.out.println("Approximate player 1 victory probability: " + probabilities.player1VictoryProbability());
        System.out.println("Approximate player 2 victory probability: " + probabilities.player2VictoryProbability());
        System.out.println("Approximate draw probability: " + probabilities.drawProbability());
    }
}
