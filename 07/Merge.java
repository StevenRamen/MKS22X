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
    
    public static void main(String[] args) {
	int[] data1 = {1, 3, 5, 7, 9, 11, 34, 54, 234, 321};
	int[] data2 = {2, 4, 6, 8, 82, 87, 97, 101, 234, 322};
	System.out.println(Arrays.toString(merge(data1, data2)));
    }
    
}
