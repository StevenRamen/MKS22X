public class Driver {

    public static void main (String args[]) {
	Recursion a = new Recursion();
	
	// Factorial Testing
	System.out.println("Factorial");
	
	System.out.println(a.fact(1));
	System.out.println(a.fact(2));
	System.out.println(a.fact(3));
	System.out.println(a.fact(4));
	
	
	// Fib Testing
	System.out.println("Fibonacci");
	
	System.out.println(a.fib(0));
	System.out.println(a.fib(1));
	System.out.println(a.fib(2));
	System.out.println(a.fib(3));
	System.out.println(a.fib(5));
	
	
        // Sqrt Testing
	System.out.println("Sqrt");
	
	System.out.println(a.sqrt(0));
	System.out.println(a.sqrt(1));
	System.out.println(a.sqrt(4));
	System.out.println(a.sqrt(5));
	System.out.println(a.sqrt(9));

	/*
	// Prime Testing
	System.out.println("Prime");

	System.out.println(a.isPrime(1));
	System.out.println(a.isPrime(2));
	System.out.println(a.isPrime(3));
	System.out.println(a.isPrime(5));
	System.out.println(a.isPrime(4));
	*/
	
	// Possible Sum Testing
	System.out.println("Possible Sum");

	System.out.println(a.isPossibleSum(3, 1));
	System.out.println(a.isPossibleSum(2, 17));
	System.out.println(a.isPossibleSum(5, 11));
	System.out.println(a.isPossibleSum(23 , 5));
	System.out.println(a.isPossibleSum(4, 0));
    }
}
