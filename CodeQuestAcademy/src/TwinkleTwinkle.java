import java.util.*;
import java.math.*;
import java.text.*;
public class TwinkleTwinkle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int xc = sc.nextInt();
			int yc = sc.nextInt();
			int p = sc.nextInt();
			int r1 = sc.nextInt();
			int r2 = sc.nextInt();
			double alpha = Math.PI / (double)(p);
			String result = "";
			for(int j = 0; j < 2 * p; j++) {
				int r = j % 2 == 0 ? r1 : r2;
				double theta = (Math.PI / 2) + ((double)(j) * alpha);
				double x = (double)(r) * Math.cos(theta) + (double)(xc);
				double y = (double)(r) * Math.sin(theta) + (double)(yc);
				String s1 = df.format(x);
				String s2 = df.format(y);
				if(s1.equals("-0.00"))
					s1 = "0.00";
				if(s2.equals("-0.00"))
					s2 = "0.00";
				result += s1 + "," + s2 + " ";
			}
			System.out.println(result.trim());
		}
		sc.close();
	}
}