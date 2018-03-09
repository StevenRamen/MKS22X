import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;//false by default
    private int rows;
    private int cols;
    private int startingRow, startingCol;
    private int[][] moves = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.

    */

    public Maze(String filename) throws FileNotFoundException {
	animate = false;
	// File reading
	File text = new File(filename);
	Scanner inf = new Scanner(text);
	
	
	// Finding rows and cols 
	int row = 0;
	int col = 0;
	String ans = "";
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    row ++;
	    col = line.length();
	    ans += line;
	}
	rows = row;
	cols = col;
	
	maze = new char[rows][cols];
	
	int i = 0;
	while (i < ans.length()) {
	    for (int r = 0; r < maze.length; r ++) {
		for (int c = 0; c < maze[r].length; c ++) {
		    if (ans.charAt(i) == 'S') { // Finds S
			startingRow = r;
			startingCol = c;
		    }
		    maze[r][c] = ans.charAt(i);
		    i ++;
		}
	    }
	}
	
	// Counting E's and S's
	int eCount = 0;
	int sCount = 0;
	for (int r = 0; r < rows; r ++) {
	    for (int c = 0; c < cols; c++) {
		if (maze[r][c] == 'E') {
		    eCount ++;
		}
		if (maze[r][c] == 'S') {
		    sCount ++;
		}
	    }
	}
	if (eCount != 1 || sCount != 1) {
	    throw new IllegalStateException();
	}
	
	
    }
    
    public String toString() {
	String ans = "";
	
	for (int r = 0; r < rows; r ++) {
	    for (int c = 0; c < cols; c ++) {
		ans += maze[r][c];
	    }
	    ans += "\n";
	}
	
	return ans;
    }
    

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){
        
            //erase the S
	maze[startingRow][startingCol] = ' ';

            //and start solving at the location of the s.
	
            //return solve(???,???);
	return solve(startingRow, startingCol, 0);
    }

    private int count(){
    	int counter = 0;
    	for (int r = 0; r < maze.length; r ++){
	    for(int c = 0; c < maze[0].length; c ++){
		if (maze[r][c] == '@'){
		    counter ++;
		}
	    }
    	}
    	return count();
    }
    
    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int counter){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);
            wait(70);
        }

        //COMPLETE SOLVE

	if (maze[row][col] == 'E') {
	    return counter;
	}
	maze[row][col] = '@';
	// Anthony Lam explained this to me
	for (int x = 0; x < 4; x ++) {
	    if (row + moves[x][0] < maze.length && col + moves[x][1] < maze[row].length) { // check index out of bounds
		if (maze[row + moves[x][0]][col + moves[x][1]] == ' ' || maze[row + moves[x][0]][col + moves[x][1]] == 'E') { // check available space
		    int n = solve(row + moves[x][0], col + moves[x][1], counter + 1);
		    if (n > 0) {
		        return n;
		    }
		    
		}
		
	    }

	}
	maze[row][col] = '.';
	
        return -1; //so it compiles
    }

    
}
