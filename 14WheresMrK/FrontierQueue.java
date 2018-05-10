import java.util.*;

public class FrontierQueue implements Frontier {
    
    private MyHeap<Location> locations;

    public void add(Location loc) {
	locations.push(loc);
    }
    
    public Location next() {
	return locations.pop();
    }

    public boolean hasNext() {
	return locations.peek() != null;
    }
    
}
