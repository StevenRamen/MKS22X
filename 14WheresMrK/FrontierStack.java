import java.util.*;

public class FrontierStack implements Frontier {
    
    private Stack<Location> locations;
    private int size;

    public FrontierStack() {
	locations = new Stack<>();
    }

    public int size() {
	return size;
    }
    
    public void add(Location loc) {
	locations.push(loc);
	size ++;
    }

    public Location next() {
	size --;
	return locations.pop();
    }

    public boolean hasNext() {
	return locations.size() != 0;
    }
    
}
