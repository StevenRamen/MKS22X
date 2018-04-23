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
	if (size() == data.length - 1) {
	    resize();  
	}

	
	if (size() == 0) {
	    data[0] = element;
	    start = 0;
	    end = 0;
	} else if (start == 0) { // wrap around
	    start = data.length - 1;
	    data[start] = element;
	} else { // normal
	    start --;
	    data[start] = element;
	}
        size ++;
    }

    public void addLast(E element) {
	if (element == null) {
	    throw new NullPointerException();
	}
	if (size() == data.length - 1) {
	    resize();  
	}

	
	if (size() == 0) {
	    data[0] = element;
	    start = 0;
	    end = 0;
	} else if (end == data.length - 1) { // wrap around
	    end = 0;
	    data[end] = element;
	} else { // normal
	    end ++;
	    data[end] = element;
	}
        size ++;
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
	if (end - 1 >= 0) {
	    data[end] = null;
	    end --;
	} else {
	    data[end] = null;
	    
	}
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
	    temp[i] = data[(start + i) % data.length];
	}
	
	data = temp;
	start = 0;
	end = size() - 1;
	
    }
    
    public String toString(){
	String ans = "[";
	if(start < end){
	    for (int i = start; i <= end; i++){
		ans += data[i] + ", ";
	    }
	}
	else{
	    for(int i = start; i < data.length; i++){
		ans += data[i] + ", ";
	    }
	    for(int i = 0; i <= end; i++){
		ans += data[i] + ", ";
	    }
	}
	ans = ans.substring(0, ans.length() - 2) + "]";
	return ans;
    }
    
    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>();

	System.out.println(a.toString());

        a.addFirst("foo");
        a.addFirst("do");
	a.addLast("end");
	a.addLast("first");

	System.out.println(a.toString());
	
	System.out.println(a.getFirst());
	System.out.println(a.getLast());

	a.addLast("def");
	a.addLast("gab");
	a.addLast("leo");
	a.addLast("fas");
	a.addLast("der");
	System.out.println(a.toString());
	//should reisze
	a.addLast("edd");

	System.out.println(a.toString());

	System.out.println(a.removeLast());
	System.out.println(a.toString());

	System.out.println(a.removeFirst());
	System.out.println(a.toString());
    }
    
}
