import java.util.*;

public class Sort {
    
    public static void heapSort(Integer[] data) {
	MyHeap<Integer> a = new MyHeap<>();
	
	a.Heap(data);

	for (int i = data.length - 1; i >= 0; i --) {
	    data[i] = a.remove(i);
	}
	
    }
}
