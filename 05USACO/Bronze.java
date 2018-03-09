import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Bronze {

    private static int R, C, E, N;
    private static int[][] instructions;
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
	    /*
	      int R_s = scan.nextInt();
	      int C_s = scan.nextInt();
	      int D_s = scan.nextInt();
	    */
	    instructions = new int[N][3];
	    for (int i = 0; i < N; i ++) {
		for (int x = 0; x < 3; x ++) {
		    instructions[i][x] = scan.nextInt();
		}
	    }   
	}
	catch (FileNotFoundException e) {
	    System.out.println("FileNotFound");
	    System.exit(0);
	}

	stomp();
    }

    private static void stomp() {
	// stomping
	for (int i = 0; i < N; i ++) {
	    
	    R_s = instructions[i][0] - 1;
	    C_s = instructions[i][1] - 1;
	    D_s = instructions[i][2];
	    //System.out.println(R_s + " " + C_s + " " + D_s);
	    
	    int max = lake[R_s][C_s];
	    for (int r = R_s; r < R_s + 3; r ++) {
		for (int c = R_s; c < C_s + 3; c ++) {
		    if (lake[r][c] >= max) {
			max = lake[r][c];
		    }
		}
	    }
	    
	    int temp = max - D_s;
	    
	    for (int r = R_s; r < R_s + 3; r ++) {
		for (int c = R_s; c < C_s + 3; c ++) {
		    if (lake[r][c] > temp) {
			lake[r][c] = temp;
		    }
		}
	    }
	}
    }

    public static int solve() {
	// subtracting elevation 
	int[][] bleh = new int[R][C];
	for (int r = 0; r < R; r ++) {
	    for (int c = 0; c < C; c ++) {
		if (E - lake[r][c] > 0) {
		    bleh[r][c] = E - lake[r][c];
		}
		else {
		    bleh[r][c] = 0;
		}
		ans += bleh[r][c];
	    }
	}
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