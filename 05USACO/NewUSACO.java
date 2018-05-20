import java.util.*;
import java.io.*;

public class NewUSACO {
    
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
	
	return 0;
	
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
	for (int i = 1; i <= 10; i ++) {
	    System.out.println(bronze("makelake/makelake." + i + ".in"));
	    
	}	
	
    }
    
}
