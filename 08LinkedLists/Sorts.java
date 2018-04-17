import java.util.*;

public class Sort{
    
    public static void radixsort(MyLinkedListImproved<Integer> data) {
	int numDigits = countDigit(data.get(data.max())); // for neg need to negate this fix later 	
	@SuppressWarnings ("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	@SuppressWarnings ("unchecked") MyLinkedListImproved<Integer>[] bucketsNeg = new MyLinkedListImproved[10];

	for (int i = 0; i < 10; i++){
	    buckets[i] = new MyLinkedListImproved<Integer>();
	    bucketsNeg[i] = new MyLinkedListImproved<Integer>();
	}
	for (int i = 0; i < numDigits; i++){
	    for (Integer x : data){
		//int digit = (x / ((int)java.lang.Math.pow(10, i))) % 10;
		if (x > 0) {
		    int digit = (x / ((int)Math.pow(10, i))) % 10;
		    buckets[digit].add(x);
		} else {
		    int digit = (-1 * (x / ((int)Math.pow(10, i)))) % 10;
		    bucketsNeg[digit + 9].add(x);
		}
	    }
	    System.out.println(data.toString());
	    data.clear();
	    data.add(0);
	    for (int x = 0; x < 10; x++){
		data.extend(bucketsNeg[x]);
	    }
	    for (int x = 0; x < 10; x++){
		data.extend(buckets[x]);
	    }
	    data.remove(0);
	}
    }

    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	//either blank method
	//OR
	radixsort(data);
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
	/*
	System.out.println(countDigit(534));
	System.out.println(getDigit(1, 534));
	System.out.println(getDigit(2, 534));
	System.out.println(getDigit(3, 534));
	*/
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();

	for(int i = 0; i < 20; i++  ){
	    int index = (int)(Math.random()*(1 + a.size()));
	    a.add(index,i);
	}

	System.out.println(a);
	radixsort(a);
	System.out.println(a);
	
	MyLinkedListImproved<Integer> b = new MyLinkedListImproved<>();

	for(int i = -10; i != 0; i++  ){
	    int index =(int)(Math.random()*(1 + b.size()));
	    b.add(index,i);
	}
	/*
	for(int i = 0; i < 10; i++  ){
	    int index = (int)(Math.random()*(1 + b.size()));
	    b.add(index,i);
	}
	*/
	System.out.println(b);
	radixsort(b);
	System.out.println(b);

    }
    
}   
