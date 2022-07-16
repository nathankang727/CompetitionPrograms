import java.util.*;
import java.math.*;
import java.text.*;
public class BringJohnGlennHome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.0##");
		df.setRoundingMode(RoundingMode.HALF_UP);
		int testCases = sc.nextInt();
		for(int i = 0; i < testCases; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			double h = sc.nextDouble();
			int n = sc.nextInt();
			for(int j = 0; j < n; j++) {
				double newX = h + x;
				double newY = y + h;
				if(x != 0)
					newY = y + h * (Math.sin(x) / x);
				x = newX;
				y = newY;
//				System.out.println(x + " " + y);
			}
			String ans = df.format(y);
			if(ans.substring(ans.length() - 2).equals(".0"))
				ans = ans.substring(0, ans.length() - 2);
			if(ans.equals("-0"))
				ans = "0";
			System.out.println(ans);
		}
		sc.close();
	}
}