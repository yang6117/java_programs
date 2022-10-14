// Xuefeng Yang, 5424929, yang6117
// Puzzle - project 3
public class Puzzle{
  public static void main(String[] args){ // java only reads the main method.
    final int NROWS = 4;
    final int NCOLS = 4;
    String myStringVar;
    Boolean playagain = false;
    int[][] puzzle = new int[NROWS][NCOLS];
    int[][] solution = new int[NROWS][NCOLS];

    while(!playagain){ // while loop allows the user to play again
      System.out.println("\nWelcome to the 15-Puzzle");
      delay();
      initializer(puzzle);
      initSolution(solution);
      playLoop(puzzle, solution);
      playagain = playAgain();
    }
  } // end of main


  public static void delay(){ // delays certain parts of code. my use for this is to make the program more user friendly
    try{
      Thread.sleep(750); // delays for 750 milliseconds
    }
    catch(InterruptedException e){
    }
  } // end of delay


  public static void initializer(int[][] p){ // scrambles the puzzle
    int count;
    int swapcount;
    int randomtile;
    int prevtileswapped;

    initSolution(p); // introduces the solved solution so it can be scrambled

    randomtile = 0;
    swapcount = 0;
    prevtileswapped = 0;
    while(swapcount < 10000){
      randomtile = randomInt(1, 15);

      if(swapper(p, randomtile) && randomtile != prevtileswapped){ // the condtions in this if statement satisfies the requirements stated in the assignement page
        prevtileswapped = randomtile; // sets previous tile swapped to the random tile declared earlier, so that swapcount can only increase when a new tile that's not the previous tile is generated
        swapcount++; // counter variable, only increases when conditions in if statement are met
      }
    }
  } // end of initializer


  static void initSolution(int[][] p){ // solution
    int row, col;
    for(row = 0; row < p.length; row++)
    for(col = 0; col < p[row].length; col++){
      p[row][col] = row * p[row].length + col + 1;
    }
    p[p.length - 1][p[p.length - 1].length - 1] = 0;
  } // end of initSolution


  public static int randomInt(int min, int max){ // gives us random numbers
    return (int)((Math.random()*((max-min)+1))+min);
  }  // end of randomInt


  public static boolean swapper(int[][] p, int n){ // swaps the numbers in the grid
    // swaps tile n with the open spot in puzzle p
    // verifies that n is in range and adjacent to open spot
    // returns true if swap successful, false otherwise
    int row, col;
    if(n < 1 || n > 15)
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
      else if (col > 0 && p[row][col - 1] == 0){
       swap(p, row, col, row, col - 1);
       return true;
      }
    } // found n
    return false;
  } // end of swapper


  public static void swap(int[][] p, int row1, int col1, int row2, int col2){ // the actual method that does the swapping
    // swaps elements at p[row1][col1] and p[row2][col2]
    int temp;

    temp = p[row1][col1];
    p[row1][col1] = p[row2][col2];
    p[row2][col2] = temp;
  } // end of swap


  public static void playLoop(int[][] p, int[][] sol){ // loop that alloyws us to play the game
    int n = 0;
    int count = 0;

    while(puzzleEqual(p, sol) == false){ // while loop that ccontains the main gameplay
      printPuzzle(p);

      System.out.println("enter a number to be moved.");
      printAdjacent(p);
      System.out.println("enter -1 to quit.");
      n = TextIO.getInt();
      if(n == -1){ // if statement that stops the gameplay loop when -1 is entered
        System.out.println("ha! you're a loser!"); // please don't take points away, I just think that this is funny
        delay();
        System.out.println("it took you " + count + " move(s) to quit!"); // let's user know how many turns it took to quit
        delay();
        return;
      }
      while(swapper(p, n) == false){ // this chunk of code activates if a user enters a number not adjacent to 0
        System.out.println("please enter a number that is adjacent to 0. enter -1 to quit.");
        n = TextIO.getInt();
        if(n == -1){ // if statement that stops the gameplay loop when -1 is entered
          System.out.println("ha! you're a loser!"); // please don't take points away, I just think that this is funny
          delay();
          System.out.println("it took you " + count + " move(s) to quit!"); // let's user know how many turns it took to quit
          delay();
          return;
        }
      }
      count++; // let's us know how many moves we're at
    }
    System.out.println("congrats, you solved it! it took you " + count + " moves."); // let's user know how many moves it took to solve the puzzle
    delay();
  } // end of playLoop


  public static boolean puzzleEqual(int[][] puzzle, int[][] anotherPuzzle){ // method that lets us know when our puzzle is solved
      // returns true if both puzzles contain exactly the same information
      // returns false otherwise
      for (int row = 0; row < puzzle.length; row++)
          for (int col = 0; col < puzzle[row].length; col++)
              if (puzzle[row][col] != anotherPuzzle[row][col])
                return false;
      return true;
  }  // end of puzzleEqual


  static void printPuzzle(int[][] p){ // prints out our puzzle
    int row, col;
    System.out.println();
    for(row = 0; row < p.length; row++){
      for(col = 0; col < p[row].length; col++)
      System.out.printf("%4d   ", p[row][col]);
      System.out.println();
    }
    System.out.println();
  }  // printPuzzle


  static void printAdjacent(int[][] p){ // this is a method I created using parts of swapper. it's used to find and print the numbers adjacent to 0
    int row, col;
    int count = 0;

    System.out.println("your options for input are:");

    while(count <= 15){
      for(row = 0; row < p.length; row++)
      for(col = 0; col < p[row].length; col++)
      if(p[row][col] == count){
        if(row + 1 < p.length && p[row + 1][col] == 0){
        System.out.print(count + "    ");
        }
        else if(row > 0 && p[row - 1][col] == 0){
        System.out.print(count + "    ");
        }
        else if(col + 1 < p[row].length && p[row][col + 1] == 0){
        System.out.print(count + "    ")  ;
        }
        else if(col > 0 && p[row][col - 1] == 0) {
        System.out.print(count + "    ");
        }
      }
      count++;
    }
    System.out.println();
  }  // end of printAdjacent


  public static Boolean playAgain(){ // my own custom method. taken from a previous project. this allows the player to play the game again if chosen. gives a boolean depending on input
    String myStringVar;

    System.out.println("would you like to play again?");
    delay();
    System.out.println("enter \"y\" if yes,");
    delay();
    System.out.println("enter \"n\" if no.");
    myStringVar = TextIO.getWord();
  // this while statement makes it so only "y" and "n" can be entered.
    while(!myStringVar.equals("y") && !myStringVar.equals("n")){
      System.out.println("please re-enter, input has to be either \"y\" or \"n\".");
      myStringVar = TextIO.getWord();
    }
  /* the if statement below is what allows the user to play again, and makes the check variable
  / true once again so that the while loop can continue guessing the user's number furthermore. */
    if(myStringVar.equals("y")){
      System.out.println("aight cool");
      delay();
      return false;
    }
  // this else if statement ends the program in the case if the user does not want to play again.
    else if(myStringVar.equals("n")){
      System.out.println("goodbye, thank you for playing!");
      delay();
    }
    return true;
  } // end of playAgain
} // end of class
