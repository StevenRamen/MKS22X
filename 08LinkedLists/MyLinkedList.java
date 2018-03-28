import java.util.*;

public class MyLinkedList implements Iterable<Integer> {

    private class Node {
	
	private Node next, prev;
	private int data;
	
	public Node getNext() {
	    return next;
	}

	public Node getPrev() {
	    return prev;
	}
	
	public int getValue() {
	    return data;
	}
	
	public void setNext(Node next) {
	    this.next = next;
	}
	
	public void setPrev(Node prev) {
	    this.prev = prev;
	}
	
	public void setValue(int data) {
	    this.data = data;
	}
	
	private String toString() {
	    return "";
	}
    }
    
    ///////////////////////////////////////////////////////////////////////////
    public Iterator<Integer> iterator() {
	
    }


    private Node first, last;
    private int length;

    public void add(int index, int value) {
	
    }

    public void remove(int index) {
	
    }

    public String toString() {
	return "";
    }

    public int get() {
	return 0;
    }

    public void set(int index, int value) {

    }

    public int size() {
	return length;
    }
}
