/*  * EE422C Project 2 (Mastermind) submission by  * Replace <...> with your actual data.
* Xiaoyong Liang
* XL5432
* Slip days used: <0>
* Fall 2016  */
package assignment2;

import java.util.ArrayList;

/**
 * Created by Eric on 9/21/16.
 */
public class Board {
    private final static ArrayList<HistoryEntry> Guesses = new ArrayList<HistoryEntry>();

    public static void add(String guess, Peg peg){
        HistoryEntry entry = new HistoryEntry();
        entry.Guess = guess;
        entry.Peg = peg;
        Guesses.add(entry);
    }
    public static void clear(){
        Guesses.clear();
    }

    public static void print(){
        for (HistoryEntry guess: Guesses) {
            System.out.println(guess.toString());
        }

    }
}
