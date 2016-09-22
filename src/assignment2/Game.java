package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Eric on 9/17/16.
 */
public class Game {
    private boolean isTesing;
    public String[] code;
    private int guessLeft;
    private static Scanner console = new Scanner(System.in);
    private boolean gameover = false;

    public Game (boolean test){
        isTesing = test;
    }

    public void runGame(){
        printMessage();
        askToStart();
        while(guessLeft > 0 || gameover){
            printNext();
        }
    }

    private void initGame(){
        System.out.println("Generating secret code ....");
        String secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
        code = secretCode.split("");
        if(isTesing){
            System.out.println("\nSecret Code: " + secretCode + "\n");
        }
        Board.clear();
        guessLeft = GameConfiguration.guessNumber;
        gameover = false;
    }

    private void printMessage() {
        System.out.print("Welcome to Mastermind.  Here are the rules.\n" +
                "\n" +
                "This is a text version of the classic board game Mastermind.\n" +
                "The computer will think of a secret code. The code consists of 4 colored pegs.\n" +
                "The pegs MUST be one of six colors: blue, green, orange, purple, red, or yellow. A color may appear more than once in the code. You try to guess what colored pegs are in the code and what order they are in. After you make a valid guess the result (feedback) will be displayed.\n" +
                "The result consists of a black peg for each peg you have guessed exactly correct (color and position) in your guess. For each peg in the guess that is the correct color, but is out of position, you get a white peg. For each peg, which is fully incorrect, you get no feedback.\n" +
                "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
                "When entering guesses you only need to enter the first character of each color as a capital letter.\n" +
                "\n" +
                "You have 12 guesses to figure out the secret code or you lose the game. Are you ready to play? (Y/N): ");

    }

    private void askToStart(){
        String put = console.nextLine().toLowerCase();
        if(!put.equals("y") && !put.equals("yes")){
            System.out.println("Thank you!");
            console.close();
            System.exit(0);
            return;
        }
        initGame();
    }

    private void printNext(){
        if(gameover){
            System.out.print("Are you ready for another game (Y/N) : ");
            askToStart();
            return;
        }
        System.out.println("You have " + guessLeft + " guesses left.");
        System.out.println("What is your next guess?");
        System.out.println("Type in the characters for your guess and press enter.");
        System.out.print("Enter guess: ");
        String guess = console.nextLine().toUpperCase().trim();
        if(!validateGuess(guess)) {
            System.out.println(guess + " -> INVALID GUESS\n");
        } else if (guess.equals("HISTORY")){
            Board.print();
        }
        else{
            Peg feedback = generatePeg(guess);
            String msg;
            boolean win = false;
            if(feedback.White == 0 && feedback.Black == 0){
                msg = "No pegs";
            }else if(feedback.Black > 0 && feedback.White == 0){
                if(feedback.Black == GameConfiguration.pegNumber){
                    win = true;
                    msg = feedback.Black + " black peg" + (feedback.Black > 1 ? "s" : "") + " - You win!!";
                }else{
                    msg = feedback.Black + " black peg" + (feedback.Black > 1 ? "s" : "");
                }

            } else if(feedback.Black == 0 && feedback.White > 0){
                msg = feedback.White + " white peg" + (feedback.White > 1 ? "s" : "");
            } else {
                msg = feedback.Black + " black peg"  + (feedback.Black > 1 ? "s" : "") + ", " + feedback.White + " white peg"  + (feedback.White > 1 ? "s" : "");
            }

            Board.add(guess, feedback);

            System.out.println(guess + " -> Result: " + msg + "\n");

            guessLeft --;
            if(guessLeft <= 0 && !win){
                System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.");
                gameover = true;
            }
            if(win){
                gameover = true;
            }
        }
    }

    public Peg generatePeg(String guess) {
        String[] guesses = guess.split("");
        Peg feedback = new Peg();
        int[] excludeCode = new int[GameConfiguration.pegNumber];
        int[] excludeGuess = new int[GameConfiguration.pegNumber];
        for(int x = 0; x < excludeCode.length; x++){
            excludeCode[x] = -1;
        }
        for(int x = 0; x < excludeGuess.length; x++){
            excludeGuess[x] = -1;
        }

        for (int i = 0; i < guesses.length; i++) {
            if (guesses[i].equals(code[i])) {
                feedback.Black++;
                excludeCode[i] = i;
                excludeGuess[i] = i;
            }
        }

        for (int i = 0; i < guesses.length; i++) {
            if(excludeGuess[i] != -1){
                continue;
            }
            for (int j = 0; j < code.length; j++) {
                if(guesses[i].equals(code[j])){
                    if(excludeCode[j] != -1){
                        continue;
                    }
                    feedback.White++;
                    excludeCode[j] = i;
                    break;
                }
            }

        }
        return feedback;
    }

    public boolean validateGuess(String guess) {
        if(guess.equals("HISTORY")){
            return true;
        }
        if(guess.length() != GameConfiguration.pegNumber){
            return false;
        }
        for (String character: guess.split("")) {
            boolean found = false;
            for (String code: GameConfiguration.colors) {
                if (character.equals(code)) {
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }
}
