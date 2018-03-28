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
    private Node first, last;
    private int length;


    public MyLinkedList() {
	length = 0;
    }
    /*
    public Iterator<Integer> iterator() {
	
    }
    */
    public void add(int value) {
	length ++;
	
    }
    
    public void add(int index, int value) {
	length ++;
    }

    public void remove(int index) {
	length --;
    }

    public String toString() {
        String ans = "[";
	for (int i = 0; i < length; i ++) {
	    if () {  
		
	    } else {
		//node get value
	    }
	}
	return ans;
    }

    public int get(int index) {
	node = first;
	while (node != null) {
	    //do stuff with value_of_node
	    node = next_node;
	}
	return 0;
    }
    
    public void set(int index, int newValue) {
	
    }

    public int size() {
	return length;
    }
}
