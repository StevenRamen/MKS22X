public class MazeSolver{
    private static final String CLEAR_SCREEN =  "\033[2J";

    private Maze maze;
    private Frontier frontier;
    private boolean animate;
    
    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
	animate = true;
    }
    
    //Default to BFS
    public boolean solve(){ return solve(0); }
    
    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false

	if (mode == 0) {
	    frontier = new FrontierQueue();
	    Location current = maze.getStart();
	    frontier.add(current);
	
	    while(frontier.hasNext()){
	    
		if(animate){
		    clearTerminal();
		    System.out.println(this);
		    wait(100);
		}
	    
		Location next = frontier.next();
		maze.makePath(next, '.');
	    
		if(next.compareTo(maze.getEnd()) == 0){
		
		    while(next.getPrev()!=null){
			maze.makePath(next, '@');
			next = next.getPrev();
		    }
		
		    maze.makePath(maze.getStart(),'S');
		    maze.makePath(maze.getEnd(),'E');
		
		    return true;
		}
	    
		if(hasNeighbors(next)){
		
		    for(int i = 0; i < 4; i++){
		    
			if(maze.getNeighbors(next)[i] != null){
			    frontier.add(maze.getNeighbors(next)[i]);
			    maze.makePath(maze.getNeighbors(next)[i], '?');
			}
		    
		    }
		
		}
	    
	    }
	    return false;
	}

	
	if (mode == 1) {
	    frontier = new FrontierStack();

	    Location current = maze.getStart();
	    frontier.add(current);
	
	    while(frontier.hasNext()){
	    
		if(animate){
		    clearTerminal();
		    System.out.println(this);
		    wait(100);
		}
	    
		Location next = frontier.next();
		maze.makePath(next, '.');
	    
		if(next.compareTo(maze.getEnd()) == 0){
		
		    while(next.getPrev()!=null){
			maze.makePath(next, '@');
			next = next.getPrev();
		    }
		
		    maze.makePath(maze.getStart(),'S');
		    maze.makePath(maze.getEnd(),'E');
		
		    return true;
		}
	    
		if(hasNeighbors(next)){
		
		    for(int i = 0; i < 4; i++){
		    
			if(maze.getNeighbors(next)[i] != null){
			    frontier.add(maze.getNeighbors(next)[i]);
			    maze.makePath(maze.getNeighbors(next)[i], '?');
			}
		    
		    }
		
		}
	    
	    }
	    return false;
	}
	// Priority Queue
	if (mode == 2) {
	    frontier = new FrontierPriorityQueue();

	    Location current = maze.getStart();
	    frontier.add(current);
	
	    while(frontier.hasNext()){
	    
		if(animate){
		    clearTerminal();
		    System.out.println(this);
		    wait(100);
		}
	    
		Location next = frontier.next();
		maze.makePath(next, '.');
	    
		if(next.compareTo(maze.getEnd()) == 0){
		
		    while(next.getPrev()!=null){
			maze.makePath(next, '@');
			next = next.getPrev();
		    }
		
		    maze.makePath(maze.getStart(),'S');
		    maze.makePath(maze.getEnd(),'E');
		
		    return true;
		}
	    
		if(hasNeighbors(next)){
		
		    for(int i = 0; i < 4; i++){
		    
			if(maze.getNeighbors(next)[i] != null){
			    frontier.add(maze.getNeighbors(next)[i]);
			    maze.makePath(maze.getNeighbors(next)[i], '?');
			}
		    
		    }
		
		}
	    
	    }
	    return false;
	}
	if (mode == 3) {
	    frontier = new FrontierPriorityQueue();
	    maze.setAstar(true);
	}
	
	return false;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    private void wait(int millis){
        try {
	    Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    
    private boolean hasNeighbors(Location loc) {
	Location[] neighbors = maze.getNeighbors(loc);
	int count = 0;
	for (int i = 0; i < 4; i ++) {
	    if (neighbors[i] != null) {
	       count ++;
	    }
	}
	return count != 0;
    }
    
    public String toString(){
	return maze.toString();
    }

    public static void main(String[] args) {
	MazeSolver a = new MazeSolver("data2.dat");

	//System.out.println(a.solve(0));
	System.out.println(a.solve(1));
	//System.out.println(a.solve(2));
	//System.out.println(a.solve(3));
    }
}
