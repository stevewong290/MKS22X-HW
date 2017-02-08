public class Recursion {

    public static String name() {
	return "Wong, Steve";
    }
	
    public static double sqrt (double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}

	if (n == 0.0) {
	    return 0;
	}

	return tracker(n, 25);
    }

    public static double tracker(double n, double guess) {
	if (n == 0 && (guess * guess) == 0) {
	    return guess;
	}
	if (n <= .0000000000001 + guess*guess && n >= guess*guess - .0000000000001) {
	    return guess;
	}
	return tracker(n, (n / guess + guess) / 2);}
    /*    
    public static void main(String[] args) {
	System.out.println(sqrt(81));
	System.out.println(sqrt(2));
	System.out.println(name());
    }
    */

    
}

