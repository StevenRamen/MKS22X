public class FrontierPriorityQueue implements Frontier {
    
    private MyHeap<Location> data;
    
    public FrontierPriorityQueue() {
	data = new MyHeap<Location>(false);
    }

    public void add(Location loc) {
	data.add(loc);
    }

    public Location next() {
	return data.remove();
    }

    public boolean hasNext() {
	return data.peek() != null;
    }
    
}
