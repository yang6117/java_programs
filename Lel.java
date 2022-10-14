//playloop experiment

public class Lel{
  public static void main(String[] args){ // java only reads the main method.
    final int NROWS = 10;
    final int NCOLS = 10;
    String myStringVar;
    Boolean playagain = false;
    int[][] puzzle = new int[NROWS][NCOLS];
    int[][] solution = new int[NROWS][NCOLS];

    initializer(puzzle);
  } // end of main


  public static void initializer(int[][] p){
    int count;
    int swapcount;
    int randomtile;
    int prevtileswapped;

    initSolution(p);

    randomtile = 0;
    swapcount = 0;
    prevtileswapped = 0;
    while(swapcount < 100){
      randomtile = randomInt(1, 99);

      if(swapper(p, randomtile) && randomtile != prevtileswapped){
        printPuzzle(p);
        prevtileswapped = randomtile;
        swapcount++;
        delay();
      }
    }
  } // end of initializer


  static void initSolution(int[][] p){
    int row, col;
    for(row = 0; row < p.length; row++)
    for(col = 0; col < p[row].length; col++){
      p[row][col] = row * p[row].length + col + 1;
    }
    p[p.length - 1][p[p.length - 1].length - 1] = 0;
  } // end of initSolution


  public static int randomInt(int min, int max){
    return (int)((Math.random()*((max-min)+1))+min);
  }  // end of randomInt


  public static boolean swapper(int[][] p, int n){
    // swaps tile n with the open spot in puzzle p
    // verifies that n is in range and adjacent to open spot
    // returns true if swap successful, false otherwise
    int row, col;
    if(n < 1 || n > 99)
    return false;

    for(row = 0; row < p.length; row++)
    for(col = 0; col < p[row].length; col++)
    if(p[row][col] == n){ // found n
      if(row + 1 < p.length && p[row + 1][col] == 0){
        swap(p, row, col, row + 1, col);
        return true;
      }
      else if(row > 0 && p[row - 1][col] == 0){
       swap(p, row, col, row - 1, col);
       return true;
      }
      else if(col + 1 < p[row].length && p[row][col + 1] == 0){
       swap(p, row, col, row, col + 1);
       return true;
      }
      else if (col > 0 && p[row][col - 1] == 0) {
       swap(p, row, col, row, col - 1);
       return true;
      }
    } // found n
    return false;
  } // end of swapper


  public static void swap(int[][] p, int row1, int col1, int row2, int col2){
    // swaps elements at p[row1][col1] and p[row2][col2]
    int temp;

    temp = p[row1][col1];
    p[row1][col1] = p[row2][col2];
    p[row2][col2] = temp;
  } // end of swap


  static void printPuzzle(int[][] p){
    int row, col;
    System.out.println();
    for(row = 0; row < p.length; row++){
      for(col = 0; col < p[row].length; col++)
      System.out.printf("%4d   ", p[row][col]);
      System.out.println("\n \n");
    }
    System.out.println();
  }  // printPuzzle


  public static void delay(){
    try{
      Thread.sleep(750);
    }
    catch (InterruptedException e){
    }
  }
}
