import java.util.*;

public class StackCalc {





    public static boolean isOperational(String str){
	if(str.equals("+") ||
	   str.equals("-") ||
	   str.equals("*") ||
	   str.equals("/")){
	    return true;
	}
	else {
	    return false;
	}
    }

    public static String theBigRedButton(Double a , Double b, String op){
	if(op.equals("+")) {
	    return Double.toString(a + b);
	}
	else if(op.equals("-")){
	    return Double.toString(a - b);
	}
	else if(op.equals("*")){
	    return Double.toString(a * b);
	}
	else {
	    return Double.toString(a / b);
	}
    }

    public static double eval(String str){
	String[] theUSofA = str.split(" ");
	Stack<String> theUSSR = new Stack<>();
	for(String nukes : theUSofA){
	    if (isOperational(nukes)) {
		double nuke2 = Double.parseDouble(theUSSR.pop());
		double nuke1 = Double.parseDouble(theUSSR.pop());
		theUSSR.push(theBigRedButton(nuke1, nuke2, nukes));
	    }
	    else {
		theUSSR.push(nukes);
	    }
	}
	return Double.parseDouble(theUSSR.pop());
    }

    public static void main(String[] args){
	System.out.println(eval("10 2.0 +"));
	System.out.println(eval("11 3 - 4 + 2.5 *"));
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));

    }
}
