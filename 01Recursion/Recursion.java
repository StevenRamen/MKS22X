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
	return fibhelp(n, 0, 1);
    }

    public int fibhelp(int n, int a, int b) {
        if (n == 0) {
	    return a;
	}
	return fibhelp(n - 1, b, a + b);
    }

    public double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException("input can't be negative");
	}
	if (n == 0) {
	    return n;
	}
	return sqrthelp(n, n / 2);
    }

    public double sqrthelp(double n, double guess) {
        double newGuess = (n / guess + guess) / 2;
	double tolerance = .000000001;
	
	if (Math.abs((guess * guess) - n) / n < tolerance && !(guess * guess < n)) {
	    return guess;
	}
	return sqrthelp(n, newGuess);
    }

    public boolean isPossibleSum(int n, int target) {
	if (n < 0) {
	    throw new IllegalArgumentException("input can't be negative");
	}
	return isPossibleSumhelp(n, target, 0);
    }

    public boolean isPossibleSumhelp(int n, int target, int sum) {
	if (target == sum) {
	    return true;
	}
	if (n < 0) {
	    return target == sum;
	}
	return isPossibleSumhelp(n - 1, target, sum) || isPossibleSumhelp(n - 1, target, sum + n);
	
    }

}
