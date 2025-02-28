import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {
    private static final int WINNING_POSITION = 100;
    private static final int[] SNAKES = {16, 47, 49, 56, 62, 64, 87, 93, 95, 98};
    private static final int[] LADDERS = {1, 4, 9, 21, 28, 36, 51, 71, 80};
    private static final int[] SNAKE_DESTINATIONS = {6, 26, 11, 53, 19, 60, 24, 73, 75, 78};
    private static final int[] LADDER_DESTINATIONS = {38, 14, 31, 42, 84, 44, 67, 91, 100};

    private int playerPosition;
    private Random random;

    public SnakeAndLadder() {
        playerPosition = 0;
        random = new Random();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snake and Ladder Game!");
        System.out.println("Press Enter to roll the dice...");

        while (playerPosition < WINNING_POSITION) {
            scanner.nextLine(); // Wait for player to press Enter
            int diceRoll = rollDice();
            System.out.println("You rolled a " + diceRoll);

            playerPosition += diceRoll;
            if (playerPosition > WINNING_POSITION) {
                playerPosition -= diceRoll; // Undo the move if it exceeds 100
                System.out.println("You need exactly " + (WINNING_POSITION - playerPosition) + " to win!");
            } else {
                System.out.println("You are now at position " + playerPosition);
                checkForSnakesAndLadders();
            }
        }

        System.out.println("Congratulations! You've reached the winning position!");
        scanner.close();
    }

    private int rollDice() {
        return random.nextInt(6) + 1; // Roll a dice (1-6)
    }

    private void checkForSnakesAndLadders() {
        for (int i = 0; i < SNAKES.length; i++) {
            if (playerPosition == SNAKES[i]) {
                playerPosition = SNAKE_DESTINATIONS[i];
                System.out.println("Oops! You got bitten by a snake. You are now at position " + playerPosition);
                return;
            }
        }

        for (int i = 0; i < LADDERS.length; i++) {
            if (playerPosition == LADDERS[i]) {
                playerPosition = LADDER_DESTINATIONS[i];
                System.out.println("Yay! You climbed a ladder. You are now at position " + playerPosition);
                return;
            }
        }
    }

    public static void main(String[] args) {
        SnakeAndLadder game = new SnakeAndLadder();
        game.play();
    }
}
