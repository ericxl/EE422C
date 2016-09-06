/*  * This file is how you might test out your code.  Don't submit this, and don't  * have a main method in SortTools.java.  */
package assignment1;

public class Main {
    public static void main(String[] args) {

        System.out.println("Testing...");
        SortToolsTest test = new SortToolsTest();
        test.testFind();
        test.testIsSorted();
        test.testInsertGeneral();
        test.testInsertInPlace();
        test.testInsertSort();
        System.out.println("All passed!");
    }
}