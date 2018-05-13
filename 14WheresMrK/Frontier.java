public interface Frontier {

    public Location next();
    public void add(Location loc);
    public boolean hasNext();
    
}
