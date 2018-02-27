import java.util.*;

public class KnightBoard {

    private int[][] board;

    //non square is required!
    public KnightBoard(int startingRows,int startingCols) {
	if (startingRows < 0 || startingCols < 0) {
	    throw new IllegalArgumentException("Non-negative parameters only");
	}
	
	board = new int[startingRows][startingCols];
    }
    
    
    /* see format for toString below
       blank boards use underscores 
       you get a blank board if you never called solve or 
       when there is no solution 
    */
    public String toString() {
	String ans = "";
	//int counter = 1;
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c ++) {
		//board[r][c] = counter;
		if (board[r][c] < 10) {
		    ans += " ";
		}
		ans += board[r][c] + " ";
		//counter ++;
	    }
	    ans += "\n";
	}
	return ans;
    }

    public void check() {
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c ++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
    }

    public boolean solve(int startingRow, int startingCol) {
	check();
	if (startingRow < 0 || startingCol < 0) {
	    throw new IllegalArgumentException("Non-negative parameters only");
	}
	if (startingRow >= board.length || startingCol >= board[startingRow].length) {
	    throw new IllegalArgumentException("Parameters are out of bounds");
	}
	return solveH(startingRow, startingCol, 1);
    }

    // level is the # of the knight
    private boolean solveH(int row, int col, int level) {
	if (level == board.length * board[row].length){
	    return true;
	}
	if (board[row][col] == 0) {
	    board[row][col] = level;
	    for (int i = 0; i < 8; i ++) {
		if (solveH(getLegalMoves(row, col)[i][0], getLegalMoves(row, col)[i][1], level + 1)) {
		    return true;
		}
	    }
	    board[row][col] = 0;
	}
	return false;
    }

    private int[][] getLegalMoves(int row, int col) {
	int[][] coords = new int[8][2];
	int counter = 0;

	for (int up = 2, side = 1; up > 0 && side < 3; up --) {
	    if (col + side < board[row].length) {
		if (row + up < board.length) {
		    coords[counter][0] = row + up;
		    coords[counter][1] = col + side;
		    counter ++;
		}
		if (row - up >= 0) {
		    coords[counter][0] = row - up;
		    coords[counter][1] = col + side;
		    counter ++;
		}
	    }
	    if (col - side >= 0) {
		if (row + up < board.length) {
		    coords[counter][0] = row + up;
		    coords[counter][1] = col - side;
		    counter ++;
		}
		if (row - up >= 0) {
		    coords[counter][0] = row - up;
		    coords[counter][1] = col - side;
		    counter ++;	
		}
	    }
	    side ++;
	}
	    
	return coords;
    }
    
    public int countSolutions(int startingRow, int startingCol) {
	check();
	if (startingRow < 0 || startingCol < 0) {
	    throw new IllegalArgumentException("Non-negative parameters only");
	}
	if (startingRow >= board.length || startingCol >= board[startingRow].length) {
	    throw new IllegalArgumentException("Parameters are out of bounds");
	}
	
	return countSolutionsH(startingRow, startingCol, 1, 0);
    }

    public int countSolutionsH(int startingRow, int startingCol, int level, int total) {
	if (level == board[0].length * board.length){
	    board[startingRow][startingCol] = level;
	    return 1;
	}

	for (int i = 0; i < getLegalMoves(startingRow, startingCol).length; i ++) {
	    total += countSolutionsH(getLegalMoves(startingRow, startingCol)[i][0], getLegalMoves(startingRow, startingCol)[i][1], level + 1, 0);
	}

	return total;
    }

    public static void main(String[] args) {
	/*
	KnightBoard a = new KnightBoard(7, 7);
	System.out.println(a.toString());
	System.out.println(Arrays.deepToString(a.getLegalMoves(2, 2)));
	System.out.println(a.solve(0, 0));
	*/
	
	KnightBoard b = new KnightBoard(5, 5);
	System.out.println(b.countSolutions(0, 0));
    }
}
