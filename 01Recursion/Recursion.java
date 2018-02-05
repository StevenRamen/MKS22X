public class Recursion {

    public int fact(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException("input can't be negative");
	}
	if (n == 0) {
	    return 1;
	}
	return n * fact(n - 1);
    }

    public int fib(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException("input can't be negative");
	}
	if (n == 0) {
	    return n;
	}
	return fibhelp(n, 0, 1);
    }

    public int fibhelp(int n, int a, int b) {
        if (n == 0) {
	    return b;
	}
	return fibhelp(n - 1, b, a + b);
    }

    public double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException("input can't be negative");
	}
	if (n == 0 || n == 1) {
	    return n;
	}
	return sqrthelp(n, n / 2);
    }

    public double sqrthelp(double n, double guess) {
        double newGuess = (n / guess + guess) / 2;
	
	if (n / guess >= guess - .00000000001 && n / guess <= guess + .00000000001) {
	    return guess;
	}
	return sqrthelp(n, newGuess);
    }

}
