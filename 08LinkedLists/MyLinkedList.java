public class MyLinkedList {

    private class Node {
	
	private Node prev, next;
	private int data;

	public Node(int data) {
	    setValue(data);
	    prev = null;
	    next = null;
	}
	
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
	    return String.valueof(data);
	}
    }
    
    ///////////////////////////////////////////////////////////////////////////
    private Node start, end;
    private int size;


    public MyLinkedList() {
	size = 0;
	start = null;
	end = null;
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
	size = 0;
	start = null;
	end = null;
    }

    public int size() {
	return size;
    }

    public Integer get(int index) { // exceptions
	if (!(index < 0 || index > size)) {
	    Node current = start;
	    while (index > 0) {
		current = current.getNext();
		index --;
	    }
	    return current;
	}
    }

    public Integer set(int index, Integer value) {
	return value;
    }

    public int indexOf(Integer value) {
	int index = 0;
	Node current = start;

	while (current != null) {
	    if (current.getValue() == value) {
		return current;
	    }
	    current = current.getNext();
	}
	
	return 0;
    }

    public boolean add(Integer value) { // exceptions
	if (size == 0) {
	    Node x = new Node(value);
	    start = x;
	    end = x;
	} else {
	    Node x = new Node(value);
	    x.setPrev(end);
	    end.setNext(x);
	    end = x;
	}
	size ++;
	return true;
    }

    public boolean remove(Integer value) { // exceptions
	if (size == 1) {
	    
	}
	return true;
    }

    public boolean remove(int index) {
	return true;
    }
    
}
