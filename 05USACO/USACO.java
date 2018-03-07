import java.util.*;
import java.io.*;
import java.util.Arrays;

public class USACO {
    
    public USACO() {
	
    }
    
    // Problem 12: Lake Making
    public static int bronze(String filename) {
	try {
	    File file = new File(filename);
	    Scanner scan = new Scanner(file);
	    
	    int R = scan.nextInt(); // rows
	    int C = scan.nextInt(); // cols
	    int E = scan.nextInt(); // elevation
	    int N = scan.nextInt(); // # of instructions

	    // sets up board
	    int[][] lake = new int[R][C];
	    for (int r = 0; r < R; r ++) {
		for (int c = 0; c < C; c ++) {
		    lake[r][c] = scan.nextInt();
		}
	    }
	    System.out.println(toString(lake));
	    /*
	    int R_s = scan.nextInt();
	    int C_s = scan.nextInt();
	    int D_s = scan.nextInt();
	    */
	    int[][] instructions = new int[N][3];
	    for (int i = 0; i < N; i ++) {
		for (int x = 0; x < 3; x ++) {
		    instructions[i][x] = scan.nextInt();
		}
	    }

	    //System.out.println(toString(instructions));

	    // stomping
	    for (int i = 0; i < N; i ++) {
		int R_s = instructions[i][0] - 1;
		int C_s = instructions[i][1] - 1;
		int D_s = instructions[i][2];
		System.out.println(R_s + " " + C_s + " " + D_s);
		int[][] moves = {{1, 0}, {2, 0}, {0, 1}, {0, 2}, {1, 1}, {1, 2}, {2, 1}, {2, 2}, {0, 0}};
		for (int x = 0; x < moves.length; x ++) {
		    int row = R_s + moves[x][0];
		    int col = C_s + moves[x][1];
		    if (lake[row][col] - D_s <= lake[R_s][C_s]) { // if it's possible to stomp
			if (lake[row][col] > lake[R_s][C_s]) { // if greater than row/col change to number
			    lake[row][col] = lake[R_s][C_s];
			}
			else {
			    lake[row][col] = lake[R_s][C_s] - D_s;
			}
		    }
	      	}
		System.out.println(toString(lake));
	    }
	    
	    // subtracting elevation 
	    int[][] bleh = new int[R][C];
	    int total = 0;
	    for (int r = 0; r < R; r ++) {
		for (int c = 0; c < C; c ++) {
		    if (lake[r][c] - E >= 0) {
			bleh[r][c] = lake[r][c] - E;
		    }
		    else {
			bleh[r][c] = 0;
		    }
		    total += bleh[r][c];
		}
	    }

	    return total * 72 * 72;
	    
	} catch (FileNotFoundException e) {
	    System.out.println("File Not Found");
	}
	return 0;
    }



    // Problem 7: Cow Travelling
    public static int silver(String filename) {
        try {
	    File file = new File(filename);
	    Scanner scan = new Scanner(file);
	    
	} catch (FileNotFoundException e) {
	    System.out.println("File Not Found");
	}
	return 0;
    }

    public static String toString(int[][] board) {
	String ans = "";
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c ++) {
		ans += board[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(bronze("makelake.in"));
    }
}

