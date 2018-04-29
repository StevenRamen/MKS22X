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
	pushUp(size());
	size ++;
    }

    public void pushUp(int n) {
        int parent = (n - 1) / 2;
	if (n == 0){
	    return;
	}
	if (max && data[parent].compareTo(data[n]) < 0 || !max && data[parent].compareTo(data[n]) > 0){
	    swap(parent, n);
	    pushUp(parent);
	}
    }
    
    public String remove() {
	return "";
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

    private void resize() {
        T[] temp  = (T[]) new Comparable[2 + data.length + 1];
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
    
    public static void main(String[] args) {
	MyHeap<Integer> a = new MyHeap<>();
	/*Integer[] data = new Integer[10];
	for (int i = 0; i < data.length; i ++) {
	    data[i] = i;
	}*/
	System.out.println(a.size());
	a.add(0);
	System.out.println(a.size());
        System.out.println(a.toString());
	a.add(1);
	System.out.println(a.size());
        System.out.println(a.toString());
	a.add(3);
	System.out.println(a.size());
        System.out.println(a.toString());
	a.add(4);
	System.out.println(a.size());
        System.out.println(a.toString());
	a.add(2);
	System.out.println(a.size());
        System.out.println(a.toString());
	a.add(5);
	System.out.println(a.size());
        System.out.println(a.toString());
	a.add(11);
	System.out.println(a.size());
        System.out.println(a.toString());
    }
}
