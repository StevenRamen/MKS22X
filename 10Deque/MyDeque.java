public class MyDeque<E> {

    private E[] data;
    private int start;
    private int end;
    private int size;

    public MyDeque() {
	data = new E[10];
	size = 0;
    }

    public MyDeque(int initialCapacity) {
	if (initialCapacity < 0) {
	    throw new IllegalArgumentException();
	}
	data = new E[initialCapacity];
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

    

}
