import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Bronze {

    private static int R, C, E, N;
    private static int[][] lake;
    private static int R_s, C_s, D_s;
    private static int ans;
    
    public Bronze(String filename) {
	try {
	    File file = new File(filename);
	    Scanner scan = new Scanner(file);
	    
	    R = scan.nextInt(); // rows
	    C = scan.nextInt(); // cols
	    E = scan.nextInt(); // elevation
	    N = scan.nextInt(); // # of instructions
	    
	    // sets up board
	    lake = new int[R][C];
	    for (int r = 0; r < R; r ++) {
		for (int c = 0; c < C; c ++) {
		    lake[r][c] = scan.nextInt();
		}
	    }

	    
	    for (int i = 0; i < N; i ++) {
		R_s = scan.nextInt() - 1;
		C_s = scan.nextInt() - 1;
		D_s = scan.nextInt();
		stomp();
	    }
	    

	}
	catch (FileNotFoundException e) {
	    System.out.println("FileNotFound");
	    System.exit(0);
	}
    }

    private static void stomp() {
	int max = lake[R_s][C_s];
	
	for (int r = R_s; r < R_s + 3; r ++) {
	    for (int c = C_s; c < C_s + 3; c ++) {
		if (lake[r][c] >= max) {
		    max = lake[r][c];
		}
	    }
	}
	System.out.println(toString(lake));
	int temp = max - D_s;
	System.out.println(temp);
	for (int r = R_s; r < R_s + 3; r ++) {
	    for (int c = R_s; c < C_s + 3; c ++) {
		if (lake[r][c] > temp) {
		    lake[r][c] = temp;
		}
	    }
	}
	
    }

    public static int solve() {
	int[][] bleh = new int[R][C];
	for (int r = 0; r < R; r ++) {
	    for (int c = 0; c < C; c ++) {
		if (E - lake[r][c] > 0) {
		    ans += E - lake[r][c];
		    bleh[r][c] = E - lake[r][c];
		}
	    }
	}
	System.out.println(toString(bleh));
	return ans * 72 * 72;
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
}
