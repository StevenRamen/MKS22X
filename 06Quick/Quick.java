import java.util.*;

public class Quick {

    public static int partitionOld(int[] data, int lo, int hi) {
	int pi = (int)(Math.random() * (hi - lo)) + lo;

        swap(data, pi, lo);

	int i = lo + 1;
	int j = hi;

	while (i <= j) {
	    if (data[i] > data[lo]) {
		swap(data, i, j);
		j --;
	    } else {
		i ++;
	    }
	}
	swap(data, j, lo);
	//System.out.println(Arrays.toString(data));
	//System.out.println(j);
	return j;
    }

    public static int partition(int[] data, int lo, int hi) {
	int i = 0;
	int lt = 0;
	int gt = data.length - 1;
	int pi = (int)(Math.random() * (hi - lo)) + lo;

	while (i <= gt) {
	    if (data[i] == data[pi]) {
		i ++;
	    }
	    if (data[i] > data[pi]) {
		swap(data, i, gt);
		gt --;
	    }
	    if (data[i] < data[pi]) {
		swap(data, i, lt);
		lt ++;
		i ++;
	    }
	}
	return i;
    }

    private static void swap(int[] data, int a, int b) {
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }


    public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	
	return 0;
    }

    public static void quickSort(int[] data) {
	quickSortH(data, 0, data.length - 1);
    }

    private static void quickSortH(int[] data, int lo, int hi) {
	if (lo < hi) {
	    int index = partition(data, lo, hi);
	    quickSortH(data, lo, index - 1);
	    quickSortH(data, index + 1, hi);
	}
    }
	

    public static void main(String[] args) {
	int[] data = {7, 2, 1, 8, 6, 3, 5, 4};
	System.out.println(Arrays.toString(data));
	System.out.println(partition(data, 0, data.length - 1));
        //quickSort(data);
	System.out.println(Arrays.toString(data));
    }
}
