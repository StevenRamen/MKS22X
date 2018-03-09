import java.util.*;
import java.io.*;

public class USACO {

    public static int bronze(String filename) {
	Bronze a = new Bronze(filename);
	return a.solve();
    }

    public static int silver(String filename) {
	Silver a = new Silver(filename);
	return a.move();
    }

    public static void main(String[] args) {
	USACO x = new USACO();
	System.out.println(bronze("makelake.1.in"));
	//System.out.println(silver("ctravel.1.in"));
    }
}

