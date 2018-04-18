import java.util.*;

public class Stack<T> {
    
    private MyLinkedListImproved<T> data;

    public Stack() {
	data = new MyLinkedListImproved<T>();
    }

    public void push(T value) {
	data.add(0, value);
    }

    public T pop() {
	if (data.size() == 0) {
	    throw new NoSuchElementException();
	}
	return data.remove(0);
    }

    public T peek() {
	
    }
}
