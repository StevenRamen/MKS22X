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

    public static int[] partition(int[] data, int lo, int hi) {
	int i = lo;
	int lt = lo;
	int gt = hi;
	int pi = (int)(Math.random() * (hi - lo)) + lo;
	int pivot = data[pi];

	while (i <= gt) {
	    if (data[i] == pivot) {
		i ++;
	    } else if (data[i] > pivot) {
		swap(data, i, gt);
		gt --;
	    } else if (data[i] < pivot) {
		swap(data, i, lt);
		lt ++;
		i ++;
	    }
	}
	int[] ans = {lt, i};
	return ans;
    }

    private static void swap(int[] data, int a, int b) {
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }


    public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	if (k < data.length) {
	    int lo = 0;
	    int hi = data.length - 1;
	    //int[] index = partition(data, 0, data.length - 1);
	    /*
	      while (index[0] > k || index[1] < k) {
	      if (index[0] > k) {
	      hi = index[0] - 1;
	      index = partition(data, lo, hi);
	      } else {
	      lo = index[1] + 1;
	      index = partition(data, lo, hi);
	      }
	      }
	    */
	    int index = partitionOld(data, lo, hi);
	    while (lo < hi && k != index) {
		if (index > k) {
		    hi = index -1;
		} else if (index < k) {
		    lo = index + 1;
		}
		index = partitionOld(data, lo, hi);
	    }
	    
	    //return data[index[0]];
	    return data[k];
	}
	return -1;
    }

    public static void quickSort(int[] data) {
	quickSortH(data, 0, data.length - 1);
    }

    private static void quickSortH(int[] data, int lo, int hi) {
	if (lo < hi) {
	    int[] index = partition(data, lo, hi);
	    quickSortH(data, lo, index[0]);
	    quickSortH(data, index[1], hi);
	}
    }
	

    public static void main(String[] args) {
	//int[] data = {0, 1, 2, 1, 1, 0, 0, 2, 2, 2, 1, 0, 1, 2, 0, 1, 2, 2};
	int[] data = {7, 2, 1, 8, 6, 3, 5, 4};
	System.out.println(Arrays.toString(data));
	//System.out.println(partition(data, 0, data.length - 1));
        quickSort(data);
	//System.out.println(quickselect(data, 8));
	System.out.println(Arrays.toString(data));

    }
}
