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
	int left = 0;
	int right = 0;
	int inc = 0;
	
	while (lo + left < mid + 1 && mid + 1 + right < hi + 1){
	    
	    if (temp[lo + left] < temp[mid + 1 + right]){
		data[lo + inc] = temp[lo + left];
		left ++;
		
	    }else{
		
		data[lo + inc] = temp[mid + 1 + right];
		right ++;
	    }
	    
	    inc ++;
	}

	while (mid + 1 + right < hi + 1){
	    data[lo + inc] = temp[mid + 1 + right];
	    right ++;
	    inc ++;
	}
		
	while (lo + left < mid + 1){
	    
	    data[lo + inc] = temp[lo + left];
	    left ++;
	    inc ++;

	}
	
    }

    public static void insertionSort(int[] data, int lo, int hi) {
	for (int i = lo + 1; i <= hi; i++) {
	    int key = data[i];
	    int x = i;
	    while (x > lo && data[x - 1] > key) {
		data[x] = data[x - 1];
		x = x - 1;
	    }
	    data[x] = key;
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
	if (hi - lo <= 35) {
	    insertionSort(data, lo, hi);
	} else {
	    for (int i = lo; i <= hi; i ++) {
		temp[i] = data[i];
	    }
	    
	    int mid = lo / 2 + hi / 2;
	    
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
	int[] data2 = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80};
	//Merge.insertionSort(data1, 0, data1.length - 1);
	Merge.mergesort(data2);
	System.out.println(Arrays.toString(data2));
    }
    
}
