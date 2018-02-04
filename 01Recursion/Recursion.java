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
	if (n == 0) {
	    return n;
	}
	return fibhelp(n, 0, 1);
    }

    public static int fibhelp(int n, int a, int b) {
        if (n == 0) {
	    return b;
	}
	return fibhelp(n - 1, b, a + b);
    }

    public static double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException("input can't be negative");
	}
	return 0;
    }

    public static double sqrthelp(double n, double guess) {
	return 0;
    }
    
    
    public static void main (String args[]) {
	
	/* Factorial Testing
	   System.out.println(fact(1));
	   System.out.println(fact(2));
	   System.out.println(fact(3));
	   System.out.println(fact(4));
	*/

	/* Fib Testing 
	 */
	   System.out.println(fib(0));
	   System.out.println(fib(1));
	   System.out.println(fib(2));
	   System.out.println(fib(3));
	   System.out.println(fib(5));
	//*/
	
	/* Sqrt Testing
	   System.out.println(sqrt(1));
	   System.out.println(sqrt(4));
	   System.out.println(sqrt(5));
	   System.out.println(sqrt(9));
	*/
	
    }

}
