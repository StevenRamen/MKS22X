public class MyLinkedListImproved<T> implements Iterable<T>{

    private class Node {
	
	private Node prev, next;
	private T data;

	public Node(T data) {
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
	
	public T getValue() {
	    return data;
	}
	
	public void setNext(Node next) {
	    this.next = next;
	}
	
	public void setPrev(Node prev) {
	    this.prev = prev;
	}
	
	public void setValue(T data) {
	    this.data = data;
	}
	
	public String toString() {
	    return "" + data;
	}
    }
    
    ///////////////////////////////////////////////////////////////////////////
    private Node start, end;
    private int size;


    public MyLinkedListImproved() {
	size = 0;
	start = null;
	end = null;
    }

    public String toString() {
	String ans = "[";
	if (size == 0){
	    return ans + "]";
	}
	
	Node current = start;
	
	while (current.getNext() != null){
	    ans += current.toString() + ", ";
	    current = current.getNext();
	}
	ans += current.toString() + "]";
	
	return ans;
    }

    public void clear() {
	size = 0;
	start = null;
	end = null;
    }

    public int size() {
	return size;
    }

    public T get(int index) { // exceptions
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    Node current = start;
	    while (index > 0) {
		current = current.getNext();
		index --;
	    }
	    return current.getValue();
	}
    }

    public T set(int index, T value) {
	Node current = start;
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    while (index > 0) {
		current = current.getNext();
		index --;
	    }
	}
	T n = current.getValue();
	current.setValue(value);
	return current.getValue();
    }

    public int indexOf(T value) {
	int index = 0;
	Node current = start;

	while (current != null) {
	    if (current.getValue() == value) {
		return index;
	    }
	    current = current.getNext();
	    index ++;
	}
	
	return -1;
    }

    public boolean add(T value) { // exceptions
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

    public boolean remove(T value) { // exceptions
        int index = indexOf(value);
	if (index == -1) {
	    return false;
	} else if (index == 0) {
	    start = start.getNext();
	    start.setPrev(null);
	} else if (index == size() - 1) {
	    end = end.getPrev();
	    end.setNext(null);
	} // need to do the hard part between 0 and end
	size --;
	return true;
    }

    public boolean remove(int index) {
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}
	return true;
    }

    

    /*public static void main(String[] args) {
	MyLinkedList a = new MyLinkedList();

	System.out.println("Adding values");
	System.out.println(a.toString()+ " Size = "+ a.size());
	a.add(5);
	System.out.println(a.toString()+ " Size = "+ a.size());
	a.add(4);
	System.out.println(a.toString()+ " Size = "+ a.size());
	a.add(6);
	System.out.println(a.toString()+ " Size = "+ a.size());
	a.add(8);
	System.out.println(a.toString()+ " Size = "+ a.size());
	
	System.out.println("indexOf testing");
	System.out.println(a.indexOf(8));
	System.out.println(a.indexOf(6));
	System.out.println(a.indexOf(4));
	System.out.println(a.indexOf(5));

	System.out.println("get testing");
	for (int i = 0; i < a.size(); i ++) {
	    System.out.println(a.get(i));
	}

	System.out.println("set testing");
	for (int i = 0; i < a.size(); i ++) {
	    a.set(i, i);
	    System.out.println(a.toString());
	}

	

	System.out.println("clear");
	a.clear();
	System.out.println(a.toString()+ " Size = "+ a.size());
	}*/
}
