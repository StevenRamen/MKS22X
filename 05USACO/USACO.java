import java.util.*;
import java.io.*;

public class USACO {
    
    public static int bronze(String filename) throws FileNotFoundException {
	
	int R, C, E, N;
	int[][] lake;
	int R_s, C_s, D_s;

	try {
	    
	    File file = new File(filename);
	    Scanner scan = new Scanner(file);

	    R = scan.nextInt(); // rows
	    C = scan.nextInt(); // cols
	    E = scan.nextInt(); // elevation
	    N = scan.nextInt(); // # of instructions

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
	
		int max = 0;
		for (int r = 0; r < 3 && r + R_s < lake.length; r ++) {		    
		    for (int c = 0; c < 3 && c + C_s < lake[r].length; c ++) {
			if (lake[r + R_s][c + C_s] > max) {
			    max = lake[r + R_s][c + C_s];
			}	
		    }
		}
		int temp = max - D_s;
	
		for (int r = 0; r < 3 && r + R_s < lake.length; r ++) {		    
		    for (int c = 0; c < 3 && c + C_s < lake[r].length; c ++) {
			if (lake[r + R_s][c + C_s] > temp) {
			    lake[r + R_s][c + C_s] = temp;
			}	
		    }
		}
	    }
	
	    int ans = 0;
	
	    for (int r = 0; r < lake.length; r ++) {
		for (int c = 0; c < lake[r].length; c ++) {
		    if (lake[r][c] < E) {
			ans += E - lake[r][c];
		    }
		}
	    }
	
	    return ans * 72 * 72;
		
	} catch (FileNotFoundException e) {
	    System.out.println("File Not Found");
	    System.exit(0);
	}
	return 0;
    }
    
    public static int silver(String filename) throws FileNotFoundException {

	int N, M, T;
	int R1, C1, R2, C2;
	char[][] map;
	int[][] copy1;
	int[][] copy2;

	try {
	    
	    File file = new File(filename);
	    Scanner scan = new Scanner(file);

	    N = scan.nextInt();
	    M = scan.nextInt();
	    T = scan.nextInt();

	    map = new char[N][M];
	    copy1 = new int[N][M];
	    copy2 = new int[N][M];

	    for (int r = 0; r < N; r ++) {
		String line = scan.next();
		for (int c = 0; c < M; c ++) {
		    map[r][c] = line.charAt(c);
		}
	    }

	    R1 = scan.nextInt() - 1;
	    C1 = scan.nextInt() - 1;
	    R2 = scan.nextInt() - 1;
	    C2 = scan.nextInt() - 1;

	    copy1[R1][C1] = 1;

	    for (int t = 0; t < T; t ++) {
		for (int r = 0; r < N; r ++) {
		    for (int c = 0; c < M; c ++) {
			if (copy1[r][c] != 0) {
			    copy2[r][c] = 0;
			} else if (map[r][c] != '*' && copy2[r][c] == 0){
			    int ans = 0;

			    if (r + 1 < N) {
				ans += copy1[r + 1][c];
			    }
			    if (r - 1 >= 0) {
				ans += copy1[r - 1][c];
			    }
			    if (c + 1 < M) {
				ans += copy1[r][c + 1];
			    }
			    if (c - 1 >= 0) {
				ans += copy1[r][c - 1];
			    }
			    copy2[r][c] = ans;
			}
		    }
		}

		for (int r = 0; r < N; r ++) {
		    for (int c = 0; c < M; c ++) {
			copy1[r][c] = copy2[r][c];
		    }
		}
	    }
	    return copy2[R2][C2];
	    
	} catch (FileNotFoundException e) {
	    System.out.println("File Not Found");
	    System.exit(0);
	}
	
	return 0;
	
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
	for (int i = 1; i <= 10; i ++) {
	    //System.out.println(bronze("makelake/makelake." + i + ".in"));
	    System.out.println(silver("ctravel/ctravel." + i + ".in"));
	}
	
    }
    
}
