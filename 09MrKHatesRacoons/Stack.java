import java.util.*;

public class Stack {

    private ArrayList<Double> data;
    
    public Stack() {
	data = new ArrayList<Double>();
    }

    public void push(double value) {
	data.add(value);
    }

    public double pop() {
	if (data.size() == 0) {
	    throw new NoSuchElementException();
	}
	return data.remove(data.size() - 1);
    }

    public double peek() {
	return 0;
    }
}
