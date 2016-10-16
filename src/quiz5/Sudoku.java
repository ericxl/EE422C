package quiz5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is a Sudoku Solver that solves a partial Sudoku Board using recursion.
 * The Sudoku solver fills a N×N (N=9 by default) grid with digits so that each
 * column, each row, and each of the Size ×Size (N=Size × Size while Size =3 by
 * default) subgrids contains all of the digits from 1 to 9.
 * <p>
 * You need to implement the solve(SudokuBoard b, int current) method using
 * recursion and the isSafe(int a, int n) method that is used in the solve()
 * method.
 * </p>
 * <p>
 * Don't change other given methods/fields. You can add some private helper
 * methods but you may not add new public methods or fields.
 * </p>
 */
public class Sudoku {

    public static int noSolves = 0;
    public static int SIZE;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException {

        // Initialize board
        Scanner sc = new Scanner(new File("sudoku.in"));

        boolean more = true;
        while (more) {
            int n = sc.nextInt();
            SIZE = n * n;
            int[][] initial = new int[SIZE][SIZE];

            for (int cell = 0; cell < SIZE * SIZE; cell++) {
                initial[cell / SIZE][cell % SIZE] = sc.nextInt();
            }
            solve(initial);
            more = sc.hasNextInt();
            if (more)
                System.out.println(); // Print blank line between testcases

        }
    }

    public static void solve(int[][] initial) {
        if (SIZE == 1) {
            System.out.println(1);
            return;
        }
        SudokuBoard brd = new SudokuBoard(SIZE, initial);
        if (solve(brd, brd.nextEmpty(-1)))
            brd.print();
        else
            System.out.println("NO SOLUTION");
    }

    public static boolean solve(SudokuBoard b, int current) {
        if(current == SIZE * SIZE) return true;

        int rowNumber = current/SIZE;
        int columnNumber = current % SIZE;

        for (int i = 1; i <= SIZE; i++){
            if(b.isSafe(i, current)){
                b.board[rowNumber][columnNumber] = i;
                if(solve(b, b.nextEmpty(current))){
                    return true;
                }else {
                    b.board[rowNumber][columnNumber] = 0;
                }
            }
        }

        return false;
    }
}

class SudokuBoard {
    int[][] board;
    boolean[][] initial;
    int SIZE;
    int N;

    public SudokuBoard(int size) {
        this.SIZE = size;
        N = (int) (Math.sqrt(SIZE) + 1e-3);
        board = new int[SIZE][SIZE];
    }

    public SudokuBoard(int size, int[][] starting) {
        this(size);
        initial = new boolean[SIZE][SIZE];
        // Is a square is initialized? If not, program may change its value.
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (starting[i][j] != 0)
                    initial[i][j] = true;
            }
        }

        for (int row = 0; row < SIZE; row++) {
            board[row] = Arrays.copyOf(starting[row], SIZE);
        }
    }

    /**
     * Given a square, find the next one that was not initialized.
     */
    public int nextEmpty(int n) {
        n++;
        if (n == SIZE * SIZE)
            return n;
        int r = n / SIZE;
        int c = n % SIZE;
        while (initial[r][c]) {
            n++;
            r = n / SIZE;
            c = n % SIZE;
            if (n == SIZE * SIZE)
                return n;
        }
        return n;
    }

    /**
     * Whether safe to place number 'a' in space 'n'.
     */
    public boolean isSafe(int a, int n) {
        // TODO fill here
        int rowNumber = n/SIZE;
        int colNumber = n % SIZE;

        for (int i = 0; i < SIZE; i++){

            if(board[rowNumber][i] == a){
                return false;
            }
        }

        for (int i = 0; i < SIZE; i++){
            if(board[i][colNumber] == a){
                return false;
            }
        }

        int startRow = N*(rowNumber /N );
        int startCol = N*(colNumber / N);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[startRow + i][startCol + j] == a){
                    return false;
                }
            }
        }

        return true;
    }

    public void print() {
        for (int r = 0; r < SIZE; r++) {
            String blank = "";
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == 0)
                    System.out.print(blank + "*");
                else
                    System.out.print(blank + board[r][c]);
                blank = " ";
            }
            System.out.println();
        }
    }
}
