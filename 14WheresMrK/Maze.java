import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Arrays;

public class Maze{
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    Location start,end;
    private char[][]maze;
    private boolean isAstar;
    private int distanceSoFar;

    
    public Maze (String mazeText) {
	try {
	    File text = new File(mazeText);
	    Scanner inf = new Scanner(text);
		    
	    int row = 0;
	    int col = 0;
	    String ans = "";
	    while (inf.hasNextLine()) {
		String line = inf.nextLine();
		row ++;
		col = line.length();
		ans += line;
	    }
	    int maxRows = row;
	    int maxCols = col;
	    
	    // copies file into 2d array
	    
	    maze = new char[maxRows][maxCols];
	    
	    int i = 0;
	    int numS = 0;
	    int numE = 0;
	    while (i < ans.length()) {
		for (int r = 0; r < maxRows; r ++) {
		    for (int c = 0; c < maxCols; c ++) {
			maze[r][c] = ans.charAt(i);
			if (maze[r][c] == 'S') {
			    numS ++;
			    start = new Location(r, c, null);
			}
			if (maze[r][c] == 'E') {
			    numE ++;
			    end = new Location(r, c, null);
			}
			i ++;
		    }
		}
	    }
	    
	    start = new Location(start.getX(), start.getY(), null, distance(start));
	    
	    if (numS != 1) {
		throw new IllegalStateException();
	    }
	    if (numE != 1) {
		throw new IllegalStateException();
	    }

	    isAstar = false;
	    distanceSoFar = 0;
	    
	    
	} catch (FileNotFoundException e) {
	    System.exit(0);
	    System.out.println("File Not Found");
	}
    }
    
   
    /*
      YOU MUST COMPLETE THIS METHOD!!!
      YOU MUST COMPLETE THIS METHOD!!!
      YOU MUST COMPLETE THIS METHOD!!!
    */
    public Location[] getNeighbors(Location n){
	Location[] neighbors = new Location[4];
	distanceSoFar ++;

	int row = n.getX();
	int col = n.getY();

	
	if (row + 1 < maze.length && (maze[row + 1][col] == ' ' || maze[row + 1][col] == 'E')) {
	    Location loc = new Location(row + 1, col, n);
	    neighbors[0] = new Location(row + 1, col, n, distance(loc));
	}
	if (row - 1 >= 0 && (maze[row - 1][col] == ' ' || maze[row - 1][col] == 'E')) {
	    Location loc = new Location(row - 1, col, n);
	    neighbors[1] = new Location(row - 1, col, n, distance(loc));
	}
	if (col + 1 < maze[row].length && (maze[row][col + 1] == ' ' || maze[row][col + 1] == 'E')) {
	    Location loc = new Location(row, col + 1, n);
	    neighbors[2] = new Location(row, col + 1, n, distance(loc));
	}
	if (col - 1 >= 0 && (maze[row][col - 1] == ' ' || maze[row][col - 1] == 'E')) {
	    Location loc = new Location(row, col - 1, n);
	    neighbors[3] = new Location(row, col - 1, n, distance(loc));
	}
	//System.out.println(Arrays.toString(neighbors));

	return neighbors;
    }

    public void makePath(Location loc, char c) {
	maze[loc.getX()][loc.getY()] = c;
    }
    
    public Location getStart(){
	return start;
    }
    public Location getEnd(){
	return end;
    }
    
    public void setAstar(boolean a) {
	isAstar = a;
    }
    
    private static String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private static String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }
    
    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN+"\033[1;1H");
    }
    /*
    public Maze(String filename){
	ArrayList<char[]> lines = new ArrayList<char[]>();
	int startr=-1, startc=-1;
	int endr=-1,endc=-1;
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		lines.add(in.nextLine().toCharArray());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: "+filename);
	    System.exit(1);
	}
	maze = new char[lines.size()][];
	for(int i = 0; i < maze.length; i++){
	    maze[i]=lines.get(i);
	}
	for(int r=0; r<maze.length;r++){
	    for(int c=0; c<maze[r].length;c++){
		if(maze[r][c]=='S'){
		    if(startr == -1){
			startr=r;
			startc=c;
		    }else{
			System.out.println("Multiple 'S' found!");
			System.exit(0);
		    }
		}
		
		if(maze[r][c]=='E'){
		    //erase E
		    //maze[r][c]=' ';
		    if(endr == -1){
			endr=r;
			endc=c;
		    }else{
			System.out.println("Multiple 'E' found!");
			System.exit(0);
		    }
		}
	    }
	}
	if(startr == -1 || endr == -1){
	    System.out.println("Missing 'S' or 'E' from maze.");
	    System.exit(0);
	    
	}
	
	
	  THIS IS AN IMPORTANT PART BECAUSE YOU WILL NEED TO CHANGE IT LATER!
	  The start/end Locations may need more information later when we add
	  other kinds of frontiers!
	
	end = new Location(endr,endc,null);
	start = new Location(startr,startc,null);
    }
    */
    public int distance(Location loc) {
	if (isAstar) {
	    return Math.abs(loc.getX() - getEnd().getX()) + Math.abs(loc.getY() - getEnd().getY()) + distanceSoFar;
	} else {
	    return Math.abs(loc.getX() - getEnd().getX()) + Math.abs(loc.getY() - getEnd().getY());
	}
    }

    public String toStringColor(){
	return toStringColor(50);
    }
    
    public String toStringColor(int delay){
	try{
	    Thread.sleep(delay);
	}catch(InterruptedException e){
	    
	}
	return HIDE_CURSOR+CLEAR_SCREEN+go(1,1)+colorize(toString())+SHOW_CURSOR;
    }
    
    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	for(int i = 0; i < maxr * maxc; i++){
	    int row = i/maxc;
	    int col = i%maxc;
	    
	    char c =  maze[row][col];
	    ans+=c;
	    if( col == maxc-1 ){
		ans += "\n";
	    }
	}
	return ans + "\n";
    }

    public char get(int row,int col){
	return maze[row][col];
    }
    public void set(int row,int col, char n){
	maze[row][col] = n;
    }
    public static String colorize(String s){
	String ans = "";
	Scanner in = new Scanner(s);
	while(in.hasNext()){
	    String line ="";
	    for(char c : in.nextLine().toCharArray()){
		if(c == '#'){
		    line+= color(37,47)+c;
		}
		else if(c == '@'){
		    line+= color(33,40)+c;
		}
		else if(c == '?'){
		    line+= color(37,42)+c;
		}
		else if(c == '.'){
		    line+= color(36,40)+c;
		}
		else if(c == ' '){
		    line+= color(35,40)+c;
		}else{
		    line+=color(37,40)+c;
		}

	    }
	    ans += line+color(37,40)+"\n";
	}
	return ans;
    }

   
    
}
