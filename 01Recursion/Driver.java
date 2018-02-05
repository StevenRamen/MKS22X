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
	
    }
}
