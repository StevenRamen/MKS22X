import java.util.*;

public class FrontierStack implements Frontier {
    
    private Stack<Location> locations;

    public void add(Location loc) {
	locations.push(loc);
    }

    public Location next() {
	return locations.pop();
    }

    public boolean hasNext() {
	return locations.size() != 0;
    }
    
}
