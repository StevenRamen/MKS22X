import java.util.*;

public class Stack {

    private ArrayList<double> data;
    
    public Stack() {
	data = new ArrayList<double>();
    }

    public void push(T value) {
	data.add(value);
    }

    public T pop() {
	if (data.size() == 0) {
	    throw new NoSuchElementException();
	}
	return data.remove(data.size() - 1);
    }

    public T peek() {
	
    }
}
