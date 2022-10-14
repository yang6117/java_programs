// Fifteen.java
// Start of 15 Puzzle
// Revised October 16, 2018
// Notice that the numerical length of the array (4) is never referred to, why not?

public class Fifteen {
    public static void main(String[] args) {
        int[][] puzzle = new int[4][4];
        int row, col;
        int count;

        // initialize the puzzle to all zeroes
        for (row = 0; row < puzzle.length; row++)
            for (col = 0; col < puzzle[row].length; col++)
                puzzle[row][col] = 0;

        // print out the puzzle
        System.out.println();
        for (row = 0; row < puzzle.length; row++) {
            for (col = 0; col < puzzle[row].length; col++)
                System.out.printf("%4d   ", puzzle[row][col]);
            System.out.println();
        }
        System.out.println();

        // initialize the puzzle to a completed puzzle
        for (row = 0; row < puzzle.length; row++)
            for (col = 0; col < puzzle[row].length; col++)  {
                puzzle[row][col] = row * puzzle[row].length + col + 1;
            }
        //  puzzle[3][3] = 0;  // set lower right corner to 0
        //  following is a general form of setting the lower right corner to 0
        puzzle[puzzle.length - 1][puzzle[puzzle.length - 1].length - 1] = 0;

/*
        // alternate initialization of puzzle to completed puzzle using a counter
        count = 0;
        for (row = 0; row < puzzle.length; row++)
            for (col = 0; col < puzzle[row].length; col++)  {
                count++;
                puzzle[row][col] = count;
            }
        //  puzzle[3][3] = 0;  // set lower right corner to 0
        //  following is a general form of setting the lower right corner to 0
        puzzle[puzzle.length - 1][puzzle[puzzle.length - 1].length - 1] = 0;
*/

        // print out the puzzle
        System.out.println();
        for (row = 0; row < puzzle.length; row++) {
            for (col = 0; col < puzzle[row].length; col++)
                System.out.printf("%4d   ", puzzle[row][col]);
            System.out.println();
        }
        System.out.println();

    }  // main
}  // Fifteen
