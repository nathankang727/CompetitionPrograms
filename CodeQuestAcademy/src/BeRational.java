import java.util.*;
public class BeRational {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String s = sc.nextLine();
			int j = 1;
			System.out.print((int)(Double.parseDouble(s)));
			s = s.substring(s.indexOf(".") + 1);
			long n = Long.parseLong(s);
			long d = (long)(Math.pow(10, s.length()));
			while(j < 10 && n != 0) {
				System.out.print(" " + (d / n));
				long newN = d - (d / n) * n;
				d = n;
				n = newN;
				++j;
			}
			System.out.println();
		}
		sc.close();
	}
}