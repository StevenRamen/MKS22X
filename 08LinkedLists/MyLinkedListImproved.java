// class fru <T extends Comparable<T>>

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T> {

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

    public Iterator<T> iterator() {
	return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T>{
	private node index;

	public ListIterator(Node first) {
	    index = first;
	}

	public boolean hasNext() {
	    return node != null;
	}

	public T next() {
	    if (this.hasNext()) {
		//middle part
	    }
	    throw new NoSuchElementException();
	}
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
	if (index < 0 || index > size() - 1) {
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getValue();
    }

    public T set(int index, T value) {
	Node current = start;
	if (index < 0 || index > size() - 1) {
	    throw new IndexOutOfBoundsException();
	}
	   
	getNode(index).setValue(value);
	return value;
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

    public void add(int index, T value) {
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}
	Node add = new Node(value);
		    
	if (size() == 0) {
	    start = add;
	    end = add;
	    size ++;
	    return;
	} else if (index == 0) {
	    start.setPrev(add);
	    add.setNext(start);
	    start = add;
	    size ++;
	    return;
	} else if (index == size()) {
	    add(value);
	    return;
	}
	
        getNode(index).setPrev(add);

	add.setPrev(getNode(index - 1));
	add.setNext(getNode(index));

	getNode(index).setPrev(add);
	getNode(index - 1).setNext(add);

	size ++;
    }
	
    public Node getNode(int index) {
	Node current = start;
	for (int i = 0; i < size(); i ++) {
	    if (i == index) {
		return current;
	    }
	    current = current.getNext();
	}
	return null;
    }
    
    public boolean remove(T value) { // exceptions
        int index = indexOf(value);
        if (index >= 0) {
	    remove(index);
	    return true;
	}
	return false;
    }

    public T remove(int index) {
	Node node = null;
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}
        
	if (index == 0) {
	    node = start;
	    start = start.getNext();
	    start.setPrev(null);
	    size --;
	} else if (index == size() - 1) {
	    node = end;
	    end = end.getPrev();
	    end.setNext(null);
	    size --;
	} else { // add middle part
	    node = getNode(index);
	    node.getPrev().setNext(node.getNext());
	    node.getNext().setPrev(node.getPrev());
	    size --;
	}
	return node.getValue();
    }

    
    public void extend(MyLinkedListImproved<T> other){
        //in O(1) runtime, move the elements from other onto the end of this
        //The size of other is reduced to 0
        //The size of this is now the combined sizes of both original lists

	
    }
}
