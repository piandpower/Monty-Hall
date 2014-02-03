import java.math.BigInteger;
/**
 * @author sramados
 *
 */

public class Factorial {
	public static void main(String args[]) {
		// Calculate factorials with an int
		// When i goes past 13, problems arise, do you see?
		int factorial = 1;
		for (int i = 2; i <= 40; i++) {
			factorial *= i;
			System.out.println(i + "! = " + factorial);
			}
		System.out.println("Now try it with BigIntegers");
		// Calculate factorials with a BigInteger
		BigInteger bigFactorial = new BigInteger("1");
		for (int i=2; i <= 40; i++) {
			bigFactorial = bigFactorial.multiply(BigInteger.valueOf(i));
			System.out.println(i + "! = " + bigFactorial);
		}
}
}