import java.util.*;

public class Quick {

    public static int partition(int[] data, int start, int end) {
	int pivotIndex = (int)(Math.random() * (end - start)) + start;

        int i = -1;
	int j = 0;

	while (j < data.length) {
	    if (data[j] > data[pivotIndex]) {
		j ++;
	    }
	    if (data[j] <= data[pivotIndex]) {
		i ++;
		swap(data, i, j);
		j ++;
	    }
	}
	// pivot should now be at i + 1
	// need to shift everything down
	return 0;
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

    public static void main(String[] args) {
	
    }
}
