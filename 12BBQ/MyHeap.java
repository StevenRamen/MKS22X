// n - 1 / 2 - parent
// 2n 2n + 1 - children

public class MyHeap <t extends Comparable<T>> {

    private T[] data;
    private int size;
    private boolean max;

    @SupressWarnings("unchecked")
    public MyHeap() {
	data = (T[]) new Comparable[10];
	size = 0;
	max = true;
    }

    @SupressWarnings("unchecked")
    public myHeap(boolean E) {
	data = (T[]) new Comparable[10];
	size = 0;
	max = E;
    }
    
    public void add(T s) {
	if (size() == data.length) {
	    resize();
	}
	data[size()] = s;
	addHelper(s, size());
	size ++;
    }

    public void addHelper(T s, int x) {
	if (s 
    }

    public String remove() {

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
    
    
}
