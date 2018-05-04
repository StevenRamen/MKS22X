import java.util.*;
import java.io.*;

public class Maze{
    
    private Location start,end;
    private char[][] board;
    private int maxRows, maxCols;
    
    public Maze(String mazeText){

	// reads file
	
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
	
	board = new char[maxRows][maxCols]
	
	int i = 0;
	while (i < ans.length()) {
	    for (int r = 0; r < maxRows; r ++) {
		for (int c = 0; c < maxCols; c ++) {
		    board[r][c] = ans.charAt(i);
		    i ++;
		}
	    }
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
	return "";
    }
    
    // Work on this method as a group! 
    public String toStringColor(){
        return "";
    }
    
    //return a list of Locations that are:
    // adjacent to n and  not visited
    // all the Locations in this list should have their previous set to n.
    public Location[] getNeighbors(Location n){
	return null;
    }
    
    public Location getStart(){
	return null;
    }
    
    public Location getEnd(){
	return null;
    }
       
}
