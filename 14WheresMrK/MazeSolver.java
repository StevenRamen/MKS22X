public class MazeSolver{
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
	    frontier.add(maze.getStart());
	}
	if (mode == 1) {
	    frontier = new FrontierStack();
	    frontier.add(maze.getStart());
	}
	// Priority Queue
	/*if (mode == 2) {

	}
	*/

        while(frontier.hasNext()) {
	    
	    if (animate) {
		clearTerminal();
		System.out.println(this);
		wait(50);
	    }
	    Location next = frontier.next();
	    getNeighbors(next);

	    for (int i = 0; i < 4; i ++) {
		if (getNeighbors[i] ;
		    }
	    
	}
	
	return false;
    }
    
    public String toString(){
	return maze.toString();
    }
}
