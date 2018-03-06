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

	    for (int i = 0; i < instructions.length; i ++) {
		
		
		
		
	    }
	    
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

    public static void main(String[] args) {
	//bronze("makelake.in");
    }
}

