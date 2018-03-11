import java.util.*;
import java.io.*;

public class USACO {

    public static int bronze(String filename) throws FileNotFoundException {

	int R, C, E, N;
	int[][] lake;
	int R_s, C_s, D_s;
	int ans = 0;
	
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

	    int max = lake[R_s][C_s];
	    
	    for (int r = R_s; r < R_s + 3; r ++) {
		for (int c = C_s; c < C_s + 3; c ++) {
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
	
	
	int[][] bleh = new int[R][C];
	for (int r = 0; r < R; r ++) {
	    for (int c = 0; c < C; c ++) {
		if (E - lake[r][c] > 0) {
		    ans += E - lake[r][c];
		    bleh[r][c] = E - lake[r][c];
		}
	    }
	}
	return ans * 72 * 72;
	
    }
    

    
    public static int silver(String filename) throws FileNotFoundException {
        int N, M, T;
	int R1, C1, R2, C2;
	int[][] copy1;
	int[][] copy2;
	int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // downupleftright
	
	// Problem 7: Cow Travelling
        
	File file = new File(filename);
	Scanner scan = new Scanner(file);
	
	N = scan.nextInt(); // rows
	M = scan.nextInt(); // cols
	T = scan.nextInt(); // steps
	
	// sets up board
	copy1 = new int[N][M];
	copy2 = new int[N][M];
	for (int r = 0; r < N; r ++) {
	    String line = scan.next();
	    for (int c = 0; c < M; c ++) {
		if (line.charAt(c) == '*') {
		    copy1[r][c] = -1;
		    copy2[r][c] = -1;
		}
		
	    }
	}
	
	R1 = scan.nextInt() - 1;
	C1 = scan.nextInt() - 1;
	R2 = scan.nextInt() - 1;
	C2 = scan.nextInt() - 1;
	
	
	copy2[R1][C2] = 1;
	while (T > 0) {
	    for (int r = 0; r < N; r ++) {
		for (int c = 0; c < M; c ++) {
		    copy1[r][c] = copy2[r][c];
		}
	    }
	    
	    for (int r = 0; r < N; r ++){
		for (int c = 0; c < M; c ++) {
		    if (copy2[r][c] != -1) {
			copy2[r][c] = 0;
			
			if (r - 1 >= 0 && copy2[r - 1][c] >= 0) {
			    copy2[r][c] += copy1[r - 1][c];
			}
			
			if (c - 1 >= 0 && copy2[r][c - 1] >= 0) {
			    copy2[r][c] += copy1[r][c - 1];
			}
			
			if (r + 1 < N && copy2[r + 1][c] >= 0) {
			    copy2[r][c] += copy1[r + 1][c];
			}
			
			if (c + 1 < M && copy2[r][c + 1] >= 0) {
			    copy2[r][c] += copy1[r][c + 1];
			}
		    }
		}
	    }
	    T --;
	}
	System.out.println(toString(copy2));
	return copy2[R2][C2];	
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
    
    public static void main(String[] args) throws FileNotFoundException {
	//System.out.println(bronze("makelake.1.in"));
	System.out.println(silver("ctravel.1.in"));
    }
}

