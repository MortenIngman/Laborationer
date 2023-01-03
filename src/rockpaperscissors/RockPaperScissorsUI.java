package rockpaperscissors;

import java.util.Scanner;
/**
 * UI for a text based version of the game Rock Paper Scissors. Exit game by entering 'q' as input.
 */
public class RockPaperScissorsUI {
    /**
     * Start the game.
     */
    void startGame() {
        RockPaperScissorsLogic logic = new RockPaperScissorsLogic();
        String[] alternatives = { "Rock", "Scissors", "Paper", "q" };
        String[] actions = { "crushes", "cuts", "covers"};
        String[] players = { "You", "Computer" };
        boolean play = true;
        int[] choices = new int[2];
        int[] score = new int[2];
        int roundWinner;

        printWelcomeMessage();

        while(play) {
            choices[0] = getUserChoice(alternatives);
            choices[1] = logic.getComputerChoice();

            if(choices[0] == alternatives.length - 1) {
                System.out.println("Exiting game, thank you for playing");
                play = false;
            }
            else {
                roundWinner = logic.determineRoundWinner(choices[0], choices[1]);

                if(roundWinner == -1) {
                    System.out.println("Draw, both chose " + alternatives[choices[0]]);
                }
                else {
                    score[roundWinner] ++;
                    System.out.println(alternatives[choices[roundWinner]] + " " + actions[choices[roundWinner]] + " " +
                            alternatives[choices[((roundWinner + 1) % 2)]]);
                    System.out.println(players[roundWinner] + " won (" + score[0] + "-" + score[1] + ")!");
                }
                int winner = logic.determineGameWinner(score[0], score[1]);

                if(winner >= 0) {
                    play = false;
                    System.out.println(players[winner] + " won the best of three game (" + score[0] + "-" + score[1] + ")!");
                }
            }
        }
    }
    /**
     * Print welcome message.
     */
    void printWelcomeMessage() {
        System.out.println("** Welcome to Rock Paper Scissors **");
        System.out.println("You will play against the computer in best of three");
        System.out.println("Exit program by entering 'q' as input");
    }
    /**
     * Get user choice and return corresponding int value. 0 represents
     * rock, 1 represents scissors, 2 represents paper, and 3 represents that
     * user wants to exit program.
     *
     * @param validAlternatives valid inputs
     * @return int corresponding to user choice
     */
    int getUserChoice(String[] validAlternatives) {
        String input;
        int choice = -1;
        Scanner scanner = new Scanner(System.in);

        while(choice < 0) {
            System.out.print("Your choice (");
            for(int i = 0; i < validAlternatives.length - 1; i ++) {
                System.out.print(validAlternatives[i]);

                if(i != validAlternatives.length - 2) {
                    System.out.print(", ");
                }
            }
            System.out.print(")? ");
            input = scanner.nextLine();

            for(int i = 0; i < validAlternatives.length; i ++) {
                if(input.equalsIgnoreCase(validAlternatives[i])) {
                    choice = i;
                }
            }
            if(choice < 0) {
                System.out.println("Invalid input");
            }
        }
        return choice;
    }
}
