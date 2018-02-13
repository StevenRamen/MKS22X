public class KnightBoard {

    private int[][] board;

    //non square is required!
    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
    }

    /* see format for toString below
       blank boards use underscores 
       you get a blank board if you never called solve or 
       when there is no solution 
    */
    public String toString() {
	String ans = "";
	int counter = 1;
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c ++) {
		board[r][c] = counter;
		if (board[r][c] < 10) {
		    ans += " ";
		}
		ans += board[r][c] + " ";
		counter ++;
	    }
	    ans += "\n";
	}
	return ans;
    }

    public boolean solve(int row, int col) {
	return solveH(row, col, 1);
    }

    // level is the # of the knight
    private boolean solveH(int row ,int col, int level) {
	return true;
    }
    
    public int countSolutions() {
	return 0;
    }

    public static void main(String[] args) {
	KnightBoard a = new KnightBoard(5, 5);
	System.out.println(a.toString());
    }
}
