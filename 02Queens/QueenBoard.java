public class QueenBoard {
    private int[][] board;

    public QueenBoard(int size) {
	board = new int[size][size];
    }

    private boolean addQueen(int r, int c) {
	if (board[r][c] == 0) {
	    board[r][c] --;

	    // upper diag
	    int j = c + 1;
	    for (int i = r - 1; i >= 0 && j < board.length; i --) {
		board[i][j] ++;
		j ++;
	    }

	    // right
	    for (int x = c + 1; x < board.length; x ++) {
		board[r][x] ++;
	    }

	    // lower diag
	    int b = c + 1;
	    for (int a = r + 1; a < board.length && b < board.length; a ++) {
		board[a][b] ++;
		b ++;
	    }
	    
	    return true;
	}
	return false;
    }

    private boolean removeQueen(int r, int c) {
	if (board[r][c] == -1) {
	    board[r][c] ++;
	    
	    // upper diag
	    int j = c + 1;
	    for (int i = r - 1; i >= 0 && j < board.length; i --) {
		board[i][j] --;
		j ++;
	    }

	    // right
	    for (int x = c + 1; x < board.length; x ++) {
		board[r][x] --;
	    }

	    // lower diag
	    int b = c + 1;
	    for (int a = r + 1; a < board.length && b < board.length; a ++) {
		board[a][b] --;
		b ++;
	    }
	    
	    return true;
	}
	return false;
    }

    private void clear() {
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[r].length; c ++) {
		board[r][c] = 0;
	    }
	}
    }

    /**
     *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:  
     *Q _ _ _
     *_ _ Q _
     * etc.
     */
    
    public String toString() {
	String ans = "";
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c ++) {
		if (board[r][c] == -1) {
		    ans += "Q ";
		}
		else if (board[r][c] == 0) {
		    ans += "_ ";
		}
		else {
		    ans += board[r][c] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    
  
    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
     
     *        true when the board is solveable, and leaves the board in a solved state
     
     *@throws IllegalStateException when the board starts with any non-zero value
     
     */
    
    public boolean solve() {
	return solveHelp(0);
    }

    public boolean solveHelp(int col) {
	//System.out.println(toString());
	//System.out.println(col);
	if (col >= board.length){
	    return true;
	}
	for (int r = 0; r < board.length; r++){
	    if (addQueen(r, col)){
		if (solveHelp(col + 1)){
                    return true;
		} 
		removeQueen(r, col);
	    }
	}
	return false;
    }
    
    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    
    public int countSolutions() {
	
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c ++) {
		if (board[r][c] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return countHelp(0, 0);
    }

    public int countHelp(int c, int total) {
	if (c == board.length) {
	    return total;
	}
	for (int r = 0; r < board.length; r ++) {
	    if (addQueen(r, c)) {
		if (countHelp(c + 1, total) == 1) {
		    return 1;
		}
		removeQueen(r, c);
	    }
	}
	return 0;
    }

    public static void main(String []args) {
	QueenBoard b = new QueenBoard(8);
	System.out.println(b.solve());
	System.out.println(b.toString());
	QueenBoard a = new QueenBoard(8);
	System.out.println(a.countSolutions());
	System.out.println(a.toString());
    }
}
