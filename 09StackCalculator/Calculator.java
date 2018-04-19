public class Calculator {
    
    // pre condition - valid string?
    public static double eval(String input) {
	Stack x = new Stack();

	String[] tokens = input.split(" ");

	
	for (int i = 0; i < tokens.length; i++) {
	    // if # or operations
	         // number --> check for operation
	    // do math stuff
	    String current = tokens[i];
	    double num1;
	    double num2;
	    //operators
	    if (current.equals("+")) {
	        num1 = x.pop();
		num2 = x.pop();

		x.push(num1 + num2);
	    } else if (current.equals("-")) {
		num1 = x.pop();
		num2 = x.pop();

		x.push(num1 - num2);
	    } else if (current.equals("*")) {
		num1 = x.pop();
		num2 = x.pop();

		x.push(num1 * num2);
	    } else if (current.equals("/")) {
		num1 = x.pop();
		num2 = x.pop();

		x.push(num1 / num2);
	    } else if (current.equals("%")) {
		num1 = x.pop();
		num2 = x.pop();

		x.push(num1 % num2);
	    } else {
		x.push(Double.parseDouble(current));
	    }
	}
	return x.peek();

	//return ans
    }

    public static void main(String[] args) {
	System.out.println(Calculator.eval("1 2 +"));
    }
}
