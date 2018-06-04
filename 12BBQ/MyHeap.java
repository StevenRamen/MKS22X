// n - 1 / 2 - parent
// 2n 2n + 1 - children
import java.util.*;

public class MyHeap <T extends Comparable<T>> {

    private T[] data;
    private int size;
    private boolean max;

    @SuppressWarnings("unchecked")
    public MyHeap() {
	data = (T[]) new Comparable[15];
	size = 0;
	max = true;
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean E) {
	data = (T[]) new Comparable[15];
	size = 0;
	max = E;
    }
    
    public void add(T s) {
	if (size() == data.length) {
	    resize();
	}
	data[size()] = s;
	int j = size();
	if (size() > 0) {
	    if (max) {
		for (int i = (size() - 1) / 2; s.compareTo(data[i]) > 0; i = (i - 1)/ 2) {
		    swap(i, j);
		    j = i;
		}
	    } else {
		for (int i = (size() - 1) / 2; s.compareTo(data[i]) < 0; i = (i - 1)/ 2) {
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
	pushDown(data, 0);
	return x;
    }

    public T remove(int n) {
	T x = data[0];
	swap(0, size() - 1);
	data[size() - 1] = null;
	size --;
	pushDown(data, 0, n);
	return x;
    }

    public void pushDown(T[] dat, int index, int n) {
	T current = dat[index];
	int i = 2 * index + 1;
	int j = index;
	if (max) {
	    while (i < n && dat[i] != null && dat[i + 1] != null && (current.compareTo(dat[i]) < 0 || current.compareTo(dat[i + 1]) < 0)) {
		if (dat[i + 1].compareTo(dat[i]) < 0) {
		    swap(i + 1, j);
		    j = i + 1;
		} else {
		    swap(i, j);
		    j = i;
		}
		i = 2 * j + 1;
	    }
	    if (i + 1 < dat.length && dat[i] != null && dat[i + 1] == null && current.compareTo(dat[i]) < 0) {
		swap(i, j);
	    }
	}
	else {
	    while (i < dat.length && dat[i] != null && dat[i + 1] != null && (current.compareTo(dat[i]) > 0 || current.compareTo(dat[i + 1]) > 0)) {
		if (data[i + 1].compareTo(dat[i]) < 0) {
		    swap(i + 1, j);
		    j = i + 1;
		} else {
		    swap(i, j);
		    j = i;
		}
		i = 2 * j + 1;
	    }
	}
    }
    
    public void pushDown(T[] dat, int index) {;
	T current = dat[index];
	int i = 2 * index + 1;
	int j = index;
	// System.out.println(index);
	// System.out.println(data.length);
	// System.out.println(current);
	// System.out.println(i + " " + j);
	// System.exit(0);
	if (max) {

	    while (i < dat.length && dat[i] != null && dat[i + 1] != null && (current.compareTo(dat[i]) < 0 || current.compareTo(dat[i + 1]) < 0)) {
		if (dat[i + 1].compareTo(dat[i]) < 0) {
		    swap(i + 1, j);
		    j = i + 1;
		} else {
		    swap(i, j);
		    j = i;
		}
		i = 2 * j + 1;
	    }
	    if (i + 1 < dat.length && dat[i] != null && dat[i + 1] == null && current.compareTo(dat[i]) < 0) {
		swap(i, j);
	    }
	}
	else {
	    while (i < dat.length && dat[i] != null && dat[i + 1] != null && (current.compareTo(dat[i]) > 0 || current.compareTo(dat[i + 1]) > 0)) {
		if (dat[i + 1].compareTo(dat[i]) < 0) {
		    swap(i + 1, j);
		    j = i + 1;
		} else {
		    swap(i, j);
		    j = i;
		}
		i = 2 * j + 1;
	    }
	    if (i + 1 < dat.length && dat[i] != null && dat[i + 1] == null && current.compareTo(dat[i]) > 0) {
		swap(i, j);
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

    public void toHeap(T[] arry) {
	for (int i = arry.length - 1; i >= 0; i --) {
	    pushDown(arry, i);
	}
	size = arry.length;
	data = arry;
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
