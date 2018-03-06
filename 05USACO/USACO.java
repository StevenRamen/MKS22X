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
	    
	    int R = scan.nextInt();
	    int C = scan.nextInt();
	    int E = scan.nextInt();
	    int N = scan.nextInt();
	    int[][] lake = new int[R][C];
	    
	    for (int r = 0; r < R; r ++) {
		for (int c = 0; c < C; c ++) {
		    lake[r][c] = scan.nextInt();
		}
	    }

	    int R_s = scan.nextInt();
	    int C_s = scan.nextInt();
	    int D_s = scan.nextInt();
	    /*
	    System.out.println(R);
	    System.out.println(C);
	    System.out.println(E);
	    System.out.println(N);
	    System.out.println(R_s);
	    System.out.println(C_s);
	    System.out.println(D_s);
	    System.out.println(Arrays.deepToString(lake));
	    */
	    
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

