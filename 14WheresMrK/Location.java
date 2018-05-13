import java.util.*;

public class Location implements Comparable<Location>{
    private int x, y;
    private Location previous;
    private int distance;

    public Location(int _x, int _y, Location prev) {
	x = _x;
	y = _y;
	previous = prev;
    }
    
    public Location(int _x, int _y, Location prev, int distance) {
	x = _x;
	y = _y;
	previous = prev;
	this.distance = distance;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public Integer getDistance() {
	return distance;
    }

    public Location getPrev() {
	return previous;
    }
    
    public int compareTo(Location other) {
	return getDistance().compareTo(other.getDistance());
    }

}
