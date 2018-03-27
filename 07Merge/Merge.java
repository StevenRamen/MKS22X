import java.util.*;

public class Merge {
    /*
    public static int[] merge(int[] data1, int[] data2) {
	int[] output = new int[data1.length + data2.length];

	int index1 = 0;
	int index2 = 0;
	int outputIndex = 0;
	while (index1 < data1.length && index2 < data2.length) {
	    if (data1[index1] <= data2[index2]) {
		output[outputIndex] = data1[index1];
		index1 ++;
	    } else if (data1[index1] > data2[index2]) {
		output[outputIndex] = data2[index2];
		index2 ++;
	    }
	    outputIndex ++;
	}
	if (index1 < data1.length) {
	    for (int i = index1; i < data1.length; i ++) {
		output[outputIndex] = data1[i];
		outputIndex ++;
	    }
	}
	if (index2 < data2.length) {
	    for (int i = index2; i < data2.length; i ++) {
		output[outputIndex] = data2[i];
		outputIndex ++;
	    }
	}
	return output;
    }
    */
    
    public static void merge(int[] data, int[] temp, int lo, int mid, int hi) {
	int index1 = lo;
	int index2 = mid + 1;
	int outputIndex = lo;
	
	while (index1 <= mid || index2 <= hi) {
	    if (index1 > mid) {
		data[outputIndex] = temp[index2];
		index2 ++;
	    } else if (index2 > hi) {
		data[outputIndex] = temp[index1];
		index1 ++;
	    } else if (temp[index1] <= temp[index2]) {
		data[outputIndex] = temp[index1];
		index1 ++;
	    } else {
		data[outputIndex] = temp[index2];
		index2 ++;
	    }
	    outputIndex ++;
	}

	
    }

    public static void insertionSort(int[] data, int lo, int hi) {
	for (int i = lo + 1; i < hi; i++) {
	    int key = data[i];
	    int x = i - 1;
	    while (x >= 0 && data[x] > key) {
		data[x + 1] = data[x];
		x = x - 1;
	    }
	    data[x + 1] = key;
	}
    }
    
    public static void mergesort(int[] data) {
	int[] temp = new int[data.length];

	msort(data, temp, 0, data.length - 1);
    }

    public static void msort(int[] data, int[] temp, int lo, int hi) {
	if (lo >= hi) {
	    return;
	}
	if (hi - lo <= 10) {
	    insertionSort(data, lo, hi);
	} else {
	    for (int i = lo; i <= hi; i ++) {
		temp[i] = data[i];
	    }
	    
	    int mid = (lo + hi) / 2;
	    
	    msort(temp, data, lo, mid);
	    msort(temp, data, mid + 1, hi);
	    
	    merge(data, temp, lo, mid, hi);
	}
    }
    
    public static void main(String[] args) {
	//int[] data1 = {1, 56, 85, 3, 54, 234, 321};
	//int[] data2 = {2, 4, 6, 8, 82, 87, 97, 101, 234, 322};
	//System.out.println(Arrays.toString(merge(data1, data2)));
	int[] data = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2};
	int[] data1 = {1, 5, 7, 2, 76, 213, 876, 32, 2, 76, 54, 303, 4534, 2435, 5453};
	int[] data2 = {89, 65, 54, 34, 32, 23, 12, 1};
	//Merge.insertionSort(data1, 0, data1.length - 1);
	Merge.mergesort(data2);
	System.out.println(Arrays.toString(data2));
    }
    
}
