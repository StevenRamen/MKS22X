import java.util.*;

public class Sort{
    
    public static void radixsort(MyLinkedListImproved<Integer> data) {
	int numDigits = countDigit(data.get(data.max()));	
	@SuppressWarnings ("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	for (int i = 0; i < 10; i++){
	    buckets[i] = new MyLinkedListImproved<Integer>();
	}
	for (int i = 0; i < numDigits; i++){
	    for (Integer x : data){
		int digit = (x / ((int)java.lang.Math.pow(10, i))) % 10;
		buckets[digit].add(x);
	    }
	    data.clear();
	    data.add(0);
	    for (int x = 0; x < 10; x++){
		if (buckets[x].size() != 0){
		    data.extend(buckets[x]);
		}
	    }
	    data.remove(0);
	}
    }

   
    //log gets # of digits
    public static int countDigit(int num) {
        int count = 0;
	while (num > 0) {
	    num = num / 10;
	    count ++;
	}
	return count;
    }

    public static int getDigit(int i, Integer num) {
	double digit = num % Math.pow(10, i);
	digit /= Math.pow(10, i - 1);
	return (int)digit;
	//(x / ((int)java.lang.Math.pow(10, counter))) % 10;
    }

    public static void main(String[] args) {
	System.out.println(countDigit(534));
	System.out.println(getDigit(1, 534));
	System.out.println(getDigit(2, 534));
	System.out.println(getDigit(3, 534));

	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();

	for(int i = 0; i < 20; i++  ){
	    int index = (int)(Math.random()*(1 + a.size()));
	    a.add(index,i);
	}

	System.out.println(a);
	radixsort(a);
	System.out.println(a);

    }
    
}   
