import java.util.*;

public class RunningMedian {

    private MyHeap<Double> min;
    private MyHeap<Double> max;
    private Double median;
    private int size;
    /*
    RunningMedian.java
    -RunningMedian() - makes an empty container for Doubles.
    -void add(Double) - insert a Double into the data structure.
    -Double getMedian() - return the current median, 
                          throws NoSuchElementException when size is 0.
    -int size()
    */

    
    public RunningMedian() {
	min = new MyHeap<Double>(false);
	max = new MyHeap<Double>(true);
	size = 0;
    }

    public void add(Double num) {
	if (min.size() == 0 && max.size() == 0) {
	    median = num;
	    max.add(num);
	    size ++;
	    return;
	}
	if (num <= median) {
	    max.add(num);
	} else {
	    min.add(num);
	}
	if (min.size() - max.size() > 1){
	    double temp = min.remove();
	    max.add(temp);
	}
	if (max.size() - min.size() > 1){
	    double temp = max.remove();
	    min.add(temp);
	}
	size ++;
	System.out.println(min.toString());
	System.out.println(max.toString());
    }
    
    public Double getMedian() {
	//System.out.println(size());
	//System.out.println(min.size());
	//System.out.println(max.size());
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	if (min.size() - max.size() == 1) {
	    median = min.peek();
	}
	if (max.size() - min.size() == 1) {
	    median = max.peek();
	}
	if (min.size() == max.size()) {
	    median = (max.peek() + min.peek()) / 2;
	}
	return median;
    }
    
    public int size() {
	return size;
    }

    public static void main(String[] args){
	RunningMedian test = new RunningMedian();
	//System.out.println(test.getMedian());
	test.add(2.0);
	System.out.println(test.getMedian());
	
	test.add(4.0);
	System.out.println(test.getMedian());
	
	test.add(6.0);
	System.out.println(test.getMedian());
	
	test.add(8.0);
	System.out.println(test.getMedian());
	
	System.out.println(test.size());

    }
    
}
