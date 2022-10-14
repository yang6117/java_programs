//Myfifteen.java

public class MyFifteen{
  public static void main(String[] args){
    final int NROWS = 4;
    final int NCOLS = 4;
    int row;
    int col;
    int[][] puzzle = new int[NROWS][NCOLS];
    int[][] anotherpuzzle = new int[6][6];

    printPuzzle(puzzle);
    initSolution(anotherpuzzle);
    printPuzzle(anotherpuzzle);


    if(puzzleEqual(puzzle, anotherpuzzle)){
        System.out.println("aye yo the puzzles match");
    }
    else{
      System.out.println("aye the puzzles are different yo");
    }

  } // end of main class

  static void initSolution(int[][] p){
    int row;
    int col;

    for(row = 0; row < p.length; row++){ // from fifteen.java
      for(col = 0; col < p[row].length; col++){
        p[row][col] = row * p[row].length + col + 1;
      }
      p[p.length - 1][p[p.length - 1].length - 1] = 0;
    }
  } // end of initsolution class

  static void anotherPuzzle(int[][] p){
    int row;
    int col;

    for (row = 0; row < p.length; row++)
      for (col = 0; col < p[row].length; col++)
        p[row][col] = 0;
  } // end of anotherpuzzle class

  static void printPuzzle(int[][] p){
    int row;
    int col;

    System.out.println(); // from fifteen.java
    for (row = 0; row < p.length; row++) {
      for (col = 0; col < p[row].length; col++)
        System.out.printf("%4d   ", p[row][col]);
        System.out.println();
    }
  } // end of printpuzzle class



  static boolean puzzleEqual(int[][] a, int [][] b){
    int row;
    int col;

    for(row = 0; row < a.length; row++){
      for(col = 0; col < a[row].length; col++){
        if(a[row][col] != b[row][col]){
          return false;
        }
      }
    }
    return true;
  } // end of boolean class
}
