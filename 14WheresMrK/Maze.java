import java.util.*;
import java.io.*;

public class Maze{
    
    private Location start,end;
    private char[][] board;
    private int maxRows, maxCols;
    
    public Maze(String mazeText){

	// reads file
	try {
	    File text = new File(mazeText);
	    Scanner inf = new Scanner(text);
	    
	    int row = 0;
	    int col = 0;
	    String ans = "";
	    while (inf.hasNextLine()) {
		String line = inf.nextLine();
		row ++;
		col = line.length();
		ans += line;
	    }
	    maxRows = row;
	    maxCols = col;
	    
	    // copies file into 2d array
	    
	    board = new char[maxRows][maxCols];
	    
	    int i = 0;
	    int numS = 0;
	    int numE = 0;
	    while (i < ans.length()) {
		for (int r = 0; r < maxRows; r ++) {
		    for (int c = 0; c < maxCols; c ++) {
			board[r][c] = ans.charAt(i);
			if (board[r][c] == 'S') {
			    numS ++;
			    start = new Location(r, c, null);
			}
			if (board[r][c] == 'E') {
			    numE ++;
			    end = new Location(r, c, null);
			}
			i ++;
		    }
		}
	    }

	    if (numS != 1) {
		throw new IllegalStateException();
	    }
	    if (numE != 1) {
		throw new IllegalStateException();
	    }
	    
	    
	} catch (FileNotFoundException e) {
	    System.exit(0);
	    System.out.println("File Not Found");
	}
    }
    
    // '#' - wall 
    // ' ' - open space
    // '?' - frontier space
    // '.' - visited space
    // 'E' - end space (do not replace this)
    // '@' - part of solution
    // 'S' - starting space (do not replace this)
    public String toString(){
	String ans = "";

	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c ++) {
		ans += board[r][c] + "";
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    // Work on this method as a group! 
    public String toStringColor(){
        return "";
    }
    
    //return a list of Locations that are:
    // adjacent to n and  not visited
    // all the Locations in this list should have their previous set to n.
    public Location[] getNeighbors(Location n){
	Location[] neighbors = new Location[4];
	
	if (n.getX() + 1 < board.length && board[n.getX() + 1][n.getY()] == ' ') {
	    neighbors[0] = new Location(n.getX() + 1, n.getY(), n);
	}
	if (n.getX() - 1 >= 0 && board[n.getX() - 1][n.getY()] == ' ') {
	    neighbors[1] = new Location(n.getX() - 1, n.getY(), n);
	}
	if (n.getY() + 1 < board.length && board[n.getX()][n.getY() + 1] == ' ') {
	    neighbors[2] = new Location(n.getX(), n.getY() + 1, n);
	}
	if (n.getY() - 1 >= 0 && board[n.getX()][n.getY() - 1] == ' ') {
	    neighbors[3] = new Location(n.getX(), n.getY() - 1, n);
	}
	
	return neighbors;
    }
    
    public Location getStart(){
	return start;
    }
    
    public Location getEnd(){
	return end;
    }
       
}
