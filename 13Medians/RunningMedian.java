public class RunningMedian {

    private MyHeap<Integer> min;
    private MyHeap<Integer> max;
    private int median;
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
	if (size() == 0) {
	    min.add(num);
	} else {
	    max.add(num);
	}

	if (min.size() - max.size() > 1) {
	    double temp = min.remove();
	    max.add(temp);
	}
	if (max.size() - min.size() > 1) {
	    double temp = max.remove();
	    min.add(temp);
	}
	size ++;
	
    }
    
    public Double getMedian() {
	
    }
    
    public int size() {
	return size;
    }
    
}
