import java.util.*;

public class Sort {
    
    public static void heapSort(Integer[] data) {
	MyHeap<Integer> a = new MyHeap<>();
	/*
	a.Heap(data);

	for (int i = data.length - 1; i >= 0; i --) {
	    data[i] = a.remove(i);
	}
	*/
	for (int i = 0; i < data.length; i ++) {
	    a.add(data[i]);
	}

	while (a.size() > 0) {
	    data[a.size() - 1] = a.remove();
	}
	
    }

    public static void main(String[] args){
	Integer[] a ={1,54,23,3,53,23,455,234,31};
	heapSort(a);
	System.out.println(Arrays.toString(a));
    }
}
