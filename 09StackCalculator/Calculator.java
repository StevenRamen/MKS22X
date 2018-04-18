import java.util.Arrays;

public class Calculator {

    public static double eval(String input) {
	Stack x = new Stack();

	String[] tokens = input.split(" ");

	for (int i = 0; i < tokens.length; i++) {
	    double num1 = Double.parseDouble
	    // if # or operations
	         // number --> check for operation
	    // do math stuff
	}

	//return ans
	return 0;
    }

    public static void main(String[] args) {
	System.out.println(Arrays.toString(eval("123 534 +")));
    }
}
