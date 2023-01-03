package rockpaperscissors;

import java.util.Random;
/**
 * Logic for the game Rock Paper Scissors.
 */
public class RockPaperScissorsLogic {
    /**
     * Generate random computer choice between 0 and 2 where 0 represents
     * rock, 1 represents scissors, and 2 represents paper.
     *
     * @return computer choice between 0 and 2
     */
    int getComputerChoice() {
        return new Random().nextInt(2);
    }
    /**
     * Determine game winner.
     *
     * @param userChoice users choice (0 - 3)
     * @param computerChoice computers choice (0 - 3)
     * @return 1 for draw, -1 if user won, and 0 if computer won
     */
    int determineRoundWinner(int userChoice, int computerChoice) {
        int winner;
        //draw
        if(userChoice == computerChoice) {
            winner = -1;
        }
        //user won
        else if((userChoice + 1) % 3 == computerChoice) {
            winner = 0;
        }
        //computer won
        else {
            winner = 1;
        }
        return winner;
    }
    /**
     * Determine game winner.
     *
     * @param userScore current score for user
     * @param computerScore current score for computer
     * @return -1 if there is no winner, 0 if user won or 1 if computer won
     */
    int determineGameWinner(int userScore, int computerScore) {
        //default, no one won
        int winner = -1;
        //user won
        if(userScore == 2) {
            winner = 0;
        }
        //computer won
        else if(computerScore == 2) {
            winner = 1;
        }
        return winner;
    }
}
