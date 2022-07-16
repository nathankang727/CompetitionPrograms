import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
public class DivideByZero {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.HALF_UP);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			String s1 = sc.next();
			if(valid(s1)) {
				String s2 = sc.next();
				if(valid(s2)) {
					double d1 = Double.parseDouble(s1);
					double d2 = Double.parseDouble(s2);
					if(d2 == 0.0)
						System.out.println("Divide By Zero");
					else
						System.out.println(df.format(d1 / d2));
				}
				else
					System.out.println("Invalid Divisor");
			}
			else {
				sc.next();
				System.out.println("Invalid Dividend");
			}
		}
		sc.close();
	}
	public static boolean valid(String s) {
		String digits = "0123456789";
		boolean seenDot = false;
		for(int i = 0; i < s.length(); i++) {
			if(i != 0 && s.charAt(i) == '-')
				return false;
			else if(i == 0 && s.charAt(i) == '-')
				continue;
			else if(seenDot && s.charAt(i) == '.')
				return false;
			else if(!seenDot && s.charAt(i) == '.')
				seenDot = true;
			else if(!digits.contains(s.substring(i, i + 1)))
				return false;
		}
		return true;
	}
}