package assignment2;

import java.util.ArrayList;

/**
 * Created by Eric on 9/21/16.
 */
public class Board {
    private class HistoryEntry{
        public String Guess;
        public Peg Peg;

        @Override
        public String toString(){
            return Guess + "\t\t" + Peg.Black + "B_" + Peg.White + "W";
        }
    }

    private final static ArrayList<HistoryEntry> Guesses = new ArrayList<HistoryEntry>();

    public static void add(String guess, Peg peg){
        HistoryEntry entry = new Board().new HistoryEntry();
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
