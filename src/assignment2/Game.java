package assignment2;

/**
 * Created by Eric on 9/17/16.
 */
public class Game {
    public boolean isTesing;
    public Game (boolean test){
        isTesing = test;
    }

    public void runGame(){
        printMessage();
    }

    private void printMessage() {
        System.out.println("\nWelcome to Mastermind.  Here are the rules. \n\nThis is a text version of the classic board game Mastermind. \nThe computer will think of a secret code. The code consists of 4 colored pegs. \nThe pegs may be one of six colors: blue, green, orange, purple, red, or yellow. \nA color may appear more than once in the code. \nYou try to guess what colored pegs are in the code and what order they are in. \nAfter you make a valid guess the result (feedback) will be displayed. \nThe result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess.  \nFor each peg in the guess that is the correct color, but is out of position, you get a white peg. \nFor each peg, which is fully incorrect, you get no feedback.");
    }

}
