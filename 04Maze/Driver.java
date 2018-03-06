import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[]args){
	try {
	    Maze f;
	    f = new Maze("data3.dat");//true animates the maze.
	    
	    f.setAnimate(true);
	    f.solve();
	
	} catch (FileNotFoundException e) {
	    System.out.println("File Not Found");
	    System.exit(0);
	}

    }
	
}
