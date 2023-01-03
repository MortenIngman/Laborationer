package rockpaperscissors;

/**
 * A text based version of the game Rock Paper Scissors.
 */
public class RockPaperScissorsMain {
    /**
     * Program entry point.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        RockPaperScissorsUI game = new RockPaperScissorsUI();
        game.startGame();
    }
}
