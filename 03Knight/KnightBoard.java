public class KnightBoard {

    private int[][] board;

    //non square is required!
    public KnightBoard(int startingRows,int startingCols) {
	if (startingRows < 0 || startingCols < 0) {
	    throw new IllegalArgumentException("Non-negative parameters only");
	}
	
	board = new int[startingRows][startingCols];
    }

    private boolean addKnight(int row, int col) {
	if (board[r][c] == 0) {
	    board[r][c] --;
	    return true;
	}
	return false;
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
	return false;
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
    private boolean solveH(int row ,int col, int level) {
	if (level == board.length * board[row].length){
	    return true;
	}

	
	
	return false;
    }
    
    public int countSolutions() {
	check();
	
	return 0;
    }

    public static void main(String[] args) {
	KnightBoard a = new KnightBoard(7, 7);
	System.out.println(a.toString());
    }
}
