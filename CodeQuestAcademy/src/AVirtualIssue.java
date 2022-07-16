import java.util.*;
public class AVirtualIssue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			double f = sc.nextDouble();
			double m = sc.nextDouble();
			double l = sc.nextDouble();
			int lvl = sc.nextInt();
			double low = 7.777777777777778;
			double extra = 9.444444444444444;
			double high = 10.0;
			if(l > high)
				System.out.println(check(lvl - 2));
			else if(l > extra) {
				double linear = Math.max(f + 1.5 * (l - f), m + 2 * (l - m));
				if(linear > high)
					System.out.println(check(lvl - 2));
				else
					System.out.println(check(lvl));
			}
			else if(f < low && m < low && l < low)
				System.out.println(check(lvl + 1));
			else
				System.out.println(check(lvl));
		}
		sc.close();
	}
	public static int check(int n) {
		if(n < 1)
			return 1;
		if(n > 10)
			return 10;
		return n;
	}
}