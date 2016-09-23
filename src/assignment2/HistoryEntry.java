/*  * EE422C Project 2 (Mastermind) submission by  * Replace <...> with your actual data.
* Xiaoyong Liang
* XL5432
* Slip days used: <0>
* Fall 2016  */

package assignment2;

/**
 * Created by Eric on 9/22/16.
 */
public class HistoryEntry{
    public String Guess;
    public Peg Peg;

    @Override
    public String toString(){
        return Guess + "\t\t" + Peg.Black + "B_" + Peg.White + "W";
    }
}