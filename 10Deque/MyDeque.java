import java.util.*;

public class MyDeque<E> {

    private E[] data;
    private int start;
    private int end;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = (E[])new Object[10];
	size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity) {
	if (initialCapacity < 0) {
	    throw new IllegalArgumentException();
	}
	data = (E[])new Object[initialCapacity];
	size = 0;
    }

    public int size() {
	return size;
    }

    //NullPointerException
    public void addFirst(E element) {
	if (element == null) {
	    throw new NullPointerException();
	}
	if (start == 0) {
	    if (end == data.length - 1) {
		resize();
		start --;
		data[start] = element;
	    }
	}
	if (size() == data.length) {
	    resize();
	    
	}
	
    }

    public void addLast(E element) {
	if (element == null) {
	    throw new NullPointerException();
	}
	
    }

    //NoSuchElementException
    public E removeFirst() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	E element = data[start];
	data[start] = null;
	start ++;
	return element;
	
    }

    public E removeLast() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	E element = data[end];
	data[end] = null;
	end --;
	return element;
    }

    //NoSuchElementException
    public E getFirst() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public E getLast() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	return data[end];
    }

    @SuppressWarnings("unchecked")
    public void resize() {
	E[] temp = (E[])new Object[data.length * 2];

	for (int i = 0; i < size(); i ++) {
	    if (start + i < data.length) {
		temp[start + i] = data[start + i];
	    } else {
		temp[start + i] = data[(start + size()) - data.length];
	    }
	}
	
	data = temp;
    }

    public static void main(String[] args) {
	
    }

}
