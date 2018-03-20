import java.util.*;

public class Merge {
    
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
    
    public static void merge(int[] data, int[] temp, int lo, int hi) {
	int mid = (lo + hi) / 2;

	for (i
    }
    
    public static void mergesort(int[] data) {
	int[] temp = new int[data.length];

	msort(data, temp, 0, data.length - 1);
    }

    public static void msort(int[] data, int[] temp, int lo, int hi) {
	int mid = (lo + hi) / 2;

	msort(temp, data, lo, mid);
	msort(temp, data, mid + 1, hi);

	merge(data, temp, lo, hi);
    }
    
    public static void main(String[] args) {
	int[] data1 = {1, 56, 85, 3, 54, 234, 321};
	int[] data2 = {2, 4, 6, 8, 82, 87, 97, 101, 234, 322};
	System.out.println(Arrays.toString(merge(data1, data2)));
    }
    
}
