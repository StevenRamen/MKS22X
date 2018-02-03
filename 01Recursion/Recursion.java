public class Recursion {

    public static int fact(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException("input can't be negative");
	}
	if (n == 0) {
	    return 1;
	}
	return n * fact(n - 1);
    }

    public static int fib(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException("input can't be negative");
	}


	
	return 0;
    }

    public static double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException("input can't be negative");
	}


	
	return 0;
    }
    
    public static void main (String args[]) {
	/* Factorial Testing
	System.out.println(fact(1));
	System.out.println(fact(2));
	System.out.println(fact(3));
	System.out.println(fact(4));
	*/
	
	
	
	
    }

}
