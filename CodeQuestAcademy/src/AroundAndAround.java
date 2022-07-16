import java.util.*;
import java.text.*;
import java.math.*;
public class AroundAndAround {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.HALF_UP);
		for(int i = 0; i < t; i++)
			System.out.println(df.format(2.0 * Math.PI * ((40075.0 / (2.0 * Math.PI)) + sc.nextInt())));
		sc.close();
	}
}