// n - 1 / 2 - parent
// 2n 2n + 1 - children
import java.util.*;

public class MyHeap <T extends Comparable<T>> {

    private T[] data;
    private int size;
    private boolean max;

    @SuppressWarnings("unchecked")
    public MyHeap() {
	data = (T[]) new Comparable[10];
	size = 0;
	max = true;
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean E) {
	data = (T[]) new Comparable[10];
	size = 0;
	max = E;
    }
    
    public void add(T s) {
	if (size() == data.length) {
	    resize();
	}
	data[size()] = s;
	int j = size();
	if (size() < 0) {
	    if (max) {
		for (int i = (size() - 1) / 2; s.compareTo(data[i]) < 0; i = (i - 2)/ 2) {
		    swap(i, j);
		    j = i;
		}
	    } else {
	    for (int i = (size() - 1) / 2; s.compareTo(data[i]) < 0; i = (i - 2)/ 2) {
		    swap(i, j);
		    j = i;
		}
	    }
	}
	size ++;
    }

    public void pushUp(int n) {
        int parent = (n - 1) / 2;
	if (max && data[parent].compareTo(data[n]) < 0 || !max && data[parent].compareTo(data[n]) > 0){
	    swap(parent, n);
	    pushUp(parent);
	}
    }
    
    public T remove() {
        T x = data[0];
	swap(0 , size() - 1);
	data[size() - 1] = null;
	size --;
	pushDown(0);
	return x;
    }

    public void pushDown(int n) {
	int left = n;
	int right = 2 * n + 1;
	T leaf = data[n];
	
	if (max) {
	    //System.out.println(data[left]);
	    //System.out.println(data[n]);
	    while (right < data.length && right + 1 < data.length && data[right] != null && leaf.compareTo(data[right]) < 0 || leaf.compareTo(data[right + 1]) < 0) {
		if (/*left < data.length && */data[right + 1].compareTo(data[right]) > 0) {
		    swap(right + 1, left);
		    left = right + 1;
		} else {
		    swap(left, right);
		    left = right;
		}
		right = 2 * left + 1;
	    }
	    
	    if (right + 1 < data.length && data[right] != null && data[right + 1] == null && leaf.compareTo(data[right]) < 0) {
		swap(left, right);
	    }
	} else {
	    while (right < data.length && right + 1 < data.length && data[right] != null && leaf.compareTo(data[right]) > 0 || leaf.compareTo(data[right + 1]) > 0) {
		if (/*left < data.length && */data[right + 1].compareTo(data[right]) < 0) {
		    swap(right + 1, left);
		    left = right + 1;
		} else {
		    swap(left, right);
		    left = right;
		}
		right = 2 + left + 1;
	    }
	    
	    if (right + 1 < data.length && data[right] != null && data[right + 1] == null && leaf.compareTo(data[right]) > 0) {
		swap(left, right);
	    }
	}
	
    }

    public T peek() {
	return data[0];
    }

    public int size() {
	return size;
    }
    
    private void swap(int a, int b) {
	T temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] temp  = (T[]) new Comparable[2 * data.length + 1];
	for (int i = 0; i < data.length; i ++) {
	    temp[i] = data[i];
	}
	data = temp;
    }

    public String toString() {
	String ans = "(";
	for (int i = 0; i < data.length; i ++) {
	    if (data[i] != null) {
		ans += data[i] + ", ";
	    }
	}
	return ans + ")";
    }
    /*
    public static void main(String[] args) {
	// max
        MyHeap<Integer> a = new MyHeap<>();
	for (int i = 0; i < 10; i ++) {
	    a.add((int) (Math.random() * (50 - 10)) + 10);
	}
	//System.out.println(a.toString());

	//min
	MyHeap<Integer> b = new MyHeap<>(false);
	for (int i = 0; i < 10; i ++) {
	    b.add((int) (Math.random() * (50 - 10)) + 10);
	}
	//System.out.println(b.toString());

	// remove
	System.out.println(a.toString());
	System.out.println(a.size());
	System.out.println(a.remove());
	System.out.println(a.toString());
    }
    */
}
