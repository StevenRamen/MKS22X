import java.util.*;

public class Sort {
    
    public static void heapSort(Integer[] data) {
	MyHeap<Integer> a = new MyHeap<>();
	int i = data.length - 1;
        a.toHeap(data);
	
	while(i >= 0) {
	    data[i] = a.remove(i);;
	    i --;
	}
	
    }

    public static void main(String[] args){
	Integer[] a ={1,54,23,3,53,23,455,234,31};
	Sort.heapSort(a);
	System.out.println(Arrays.toString(a));
    }
}
