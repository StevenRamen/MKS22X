import java.util.Arrays;

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
	    //operators
	    if (current.equals("+")) {
		double num1 = S.pop();
		double num2 = S.pop();

		S.push(first + second);
	    } else if (current.equals("-")) {
		
	    } else if (current.equals("*")) {
		
	    } else if (current.equals("/")) {
		
	    } else if (current.equals("%")) {
		
	    } else {
		S.push(Double.parseDouble(current)); // if it's a number
	    }
	}

	//return ans
	return 0;
    }

    public static void main(String[] args) {
	System.out.println(Arrays.toString(eval("123 534 +")));
    }
}
