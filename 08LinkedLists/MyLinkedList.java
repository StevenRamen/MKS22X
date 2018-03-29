public class MyLinkedList {

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
    private int size;


    public MyLinkedList() {
	size = 0;
    }

    public String toString() {
	
        String ans = "[";
	for (int i = 0; i < size; i ++) {
	    if (n.getNext().equals(null)) {  
		return ans + "]";
	    } else {
		n.getValue();//node get value
	    }
	}
	return ans + "]";
    }

    public void clear() {
	
    }

    public int size() {
	return size;
    }

    public Integer get(int index) { // exceptions
	Node node = first;
	while (node != null) {
	    //do stuff with value_of_node
	    node = node.getNext();
	}
	return 0;
    }

    public Integer set(int index, Integer value) {
	return value;
    }

    public int indexOf(Integer value) {
	return 0;
    }

    public boolean add(Integer value) { // exceptions
	return true;
    }

    public boolean remove(Integer value) { // exceptions
	return true;
    }

    public boolean remove(int index) {
	return true;
    }
    
}
