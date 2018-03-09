import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Silver {

    private static int N, M, T;
    private static int R1, C1, R2, C2;
    private static int[][] copy1;
    private static int[][] copy2;
    
    // Problem 7: Cow Travelling
    public Silver(String filename) {
        try {
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
		    if (line.charAt(c) == '.') {
			copy1[r][c] = 0;
			copy2[r][c] = 0;
		    }
		    else {
			copy1[r][c] = -1;
			copy2[r][c] = -1;
		    }
		}
	    }

	    int R1 = scan.nextInt() - 1;
	    int C1 = scan.nextInt() - 1;
	    int R2 = scan.nextInt() - 1;
	    int C2 = scan.nextInt() - 1;
	    
	} catch (FileNotFoundException e) {
	    System.out.println("File Not Found");
	    System.exit(0);
	}
    }

    public static int move() {
	System.out.println(R1 + " " + C1);
	System.out.println(R2 + " " + C2);
	int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // downupleftright
	copy1[R1][C1] = 1;
	
	for (int x = 0; x < T; x ++) {
	    for (int r = 0; r < N; r ++) {
		for (int c = 0; c < M; c ++) {
		    
		    if (copy2[r][c] != -1) {
			copy2[r][c]= 0;
			
			for (int i = 0; i < moves.length; i ++) {
			    if (r + moves[i][0] < N && c + moves[i][1] < M && r + moves[i][0] >= 0 && c + moves[i][1] >= 0) {

				
				if (copy2[r + moves[i][0]][c + moves[i][1]] != -1) {
				    copy2[r][c] += copy1[r + moves[i][0]][c + moves[i][1]];
				}

				
			    }
			}
		    }
		}
	    }
	}
	for (int x = 0; x < T; x ++) {
	    for (int r = 0; r < N; r ++) {
		for (int c = 0; c < M; c ++) {
		    copy2[r][c] = copy1[r][c];
		}
	    }
	}
	
	System.out.println(toString(copy2));
	System.out.println(R1 + " " + C1);
	System.out.println(R2 + " " + C2);
	if (copy2[R1][C1] == -1 || copy2[R2][C2] == -1) {
	    return 0;
	}
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
}
