import java.util.*;

public class FrontierQueue implements Frontier {
    
    private LinkedList<Location> locations;
    private int size;

    public FrontierQueue() {
	locations = new LinkedList<>();
	size = 0;
    }

    public int size() {
	return size;
    }
    
    public void add(Location loc) {
	locations.add(loc);
	size ++;
    }
    
    public Location next() {
	size --;
	return locations.remove();
    }

    public boolean hasNext() {
	return locations.peek() != null;
    }
	
    
}
