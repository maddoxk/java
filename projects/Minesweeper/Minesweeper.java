import java.util.Scanner;
import java.lang.*;

public class Minesweeper {

  private static final int GAME_WON = 1;
  private static final int GAME_LOST = -1;
  private static final int GAME_NOTOVER = 0;

  private static Cell[][] grid;
  private static boolean gameOver = false;
  private static int gridRows;
  private static int gridCols;
  private static int Difficulty = 6;
  /* 
   * Create the grid and place mines in random locations.
   *
   * @param rows     The number of rows in the Minesweeper grid
   * @param columns  The number of columns in the Minesweeper grid
   *
   * Tip: Create Minesweeper grid with 2 extra rows and 2 extra columns
   *      This will make it easy to go around the grid eliminating
   *      the need for ArrayOutOfBounds checking at the edges.
   */
  public static void initGrid(int rows, int columns) {
    grid = new Cell[rows + 2][columns + 2];
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        grid[row][col] = new Cell();
      }
    }
    disperseMines(grid);
    adjacentMines();
  }

  /*
   * Places mines in random locations in the grid.
   *
   * @param Cell Grid to disperse.
   */
  public static void disperseMines(Cell[][] x) {
    int randInt;
    for (int row = 1; row < x.length - 1; row++) {
      for (int col = 1; col < x[row].length - 1; col++) {
        randInt = (int)(Math.random() * Difficulty);
        if (randInt == 0) { //Chance to place mine
          x[row][col].setMine();
        }
      }
    }
  }

  /*
   * Updates each cell with the number of adjacent cells with mines
   */
  public static void adjacentMines() {
    for (int row = 1; row < grid.length - 1; row++) {
      for (int col = 1; col < grid[row].length - 1; col++) {
        if (grid[row][col].isMine() != true) {
          if (grid[row - 1][col - 1].isMine() == true) {
            grid[row][col].setAdjacentMines(grid[row][col].getAdjacentMines() + 1);
          }
          if (grid[row][col - 1].isMine() == true) {
            grid[row][col].setAdjacentMines(grid[row][col].getAdjacentMines() + 1);
          }
          if (grid[row + 1][col - 1].isMine() == true) {
            grid[row][col].setAdjacentMines(grid[row][col].getAdjacentMines() + 1);
          }
          if (grid[row + 1][col].isMine() == true) {
            grid[row][col].setAdjacentMines(grid[row][col].getAdjacentMines() + 1);
          }
          if (grid[row + 1][col + 1].isMine() == true) {
            grid[row][col].setAdjacentMines(grid[row][col].getAdjacentMines() + 1);
          }
          if (grid[row][col + 1].isMine() == true) {
            grid[row][col].setAdjacentMines(grid[row][col].getAdjacentMines() + 1);
          }
          if (grid[row - 1][col + 1].isMine() == true) {
            grid[row][col].setAdjacentMines(grid[row][col].getAdjacentMines() + 1);
          }
          if (grid[row - 1][col].isMine() == true) {
            grid[row][col].setAdjacentMines(grid[row][col].getAdjacentMines() + 1);
          }
        }
      }
    }
  }

  /*
   * Method to print Minesweeper grid
   */
  private static void printGrid(Cell[][] x) {
    for (int row = 1; row < x.length - 1; row++) {
      for (int col = 1; col < x[row].length - 1; col++) {
        System.out.print(x[row][col].getVal());
      }
      System.out.println();
    }
  }

  /*
   * Method to reveal all the hidden cells.
   */
  public static void revealGrid() {
    for (int row = 1; row < grid.length - 1; row++) {
      for (int col = 1; col < grid[row].length - 1; col++) {
        grid[row][col].reveal();
      }
    }
  }

  /* 
   * Reveals the selected cell. So the cell now displays a '.' if no
   * adjacent cells have mines, or, a number representing the number 
   * of adjacent cells with mines.
   *
   * Extra Credit: Reveal surrounding cells until encountering a cell 
   *               with non-zero adjacent mines 
   *
   * @param   row    Row of the user selected cell
   * @param   column Column of the user selected cell
   * @return  an integer indicating if the game is won, lost or not-over
   */
  public static int revealCell(int row, int column) {
    /*
     * Handle user's cell selection specified by row and column 
     * There are three different cases:
     * 1. user chooses already explored cell - do nothing
     * 2. user chooses cell which has a mine - game lost
     * 3. user chooses a mine-free cell - reveal the cell
     * Print Minesweeper grid after handling user input
     *
     */
    if (grid[row][column].isMine() == true) {
      grid[row][column].reveal();
      return GAME_LOST;
    }
    if (grid[row][column].isMine() == false && grid[row + 1][column + 1].isRevealed() == true) {
      return GAME_NOTOVER;
    }
    if (grid[row][column].isMine() == false && grid[row + 1][column + 1].isRevealed() == false) {
      grid[row][column].reveal();
      return GAME_NOTOVER;
    }
    return GAME_NOTOVER;
  }

  /*
   * Check if all the mine-free cells are revealed
   * @return  true if game over, false if not
   */
  public static boolean checkGameOver() {
    for (int row = 1; row < grid.length - 1; row++) {
      for (int col = 1; col < grid[row].length - 1; col++) {
        if (grid[row][col].isMine() == false && grid[row][col].isRevealed() == false) {
          return false;
        }
        if (grid[row][col].isMine() == true && grid[row][col].isRevealed() == true){
          return false;
        }
      }
    }
    return true;
  }

  /*
   * Simply clears console screen.
   */
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

    /*
    * Kill me if you will code monkeys... Im AWARE THIS MAIN IS F*CKING ATROCIOUS!
    */
  public static void main(String[] args) {
    int guessedRow;
    int guessedCol;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Minesweeper!");
    System.out.println("How many rows? ");
    gridRows = scanner.nextInt();
    System.out.println("How many columns? ");
    gridCols = scanner.nextInt();
    initGrid(gridRows, gridCols);
    while (gameOver == false) {
      clearScreen();
      System.out.println("Minesweeper | Board Size: " + gridRows + "x" + gridCols);
      printGrid(grid);
      System.out.println("row: ");
      guessedRow = scanner.nextInt();
      System.out.println("col: ");
      guessedCol = scanner.nextInt();
      revealCell(guessedRow, guessedCol);
      if (revealCell(guessedRow, guessedCol) == -1) {
        clearScreen();
        revealGrid();
        System.out.println(" YOU LOSE! | Minesweeper | Board Size: " + gridRows + "x" + gridCols);
        printGrid(grid);
        gameOver = true;
      }
      if (checkGameOver() == true) {
        clearScreen();
        revealGrid();
        System.out.println(" YOU WIN! | Minesweeper | Board Size: " + gridRows + "x" + gridCols);
        printGrid(grid);
        gameOver = true;
      }
    }
  }
}
