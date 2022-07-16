import java.util.*;
import java.math.*;
import java.text.*;
public class MoneyMoneyMoney {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0");
		df.setRoundingMode(RoundingMode.HALF_UP);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String name = sc.nextLine();
			int n = Integer.parseInt(sc.nextLine());
			Data[] d = new Data[n];
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				double money = Double.parseDouble(st.nextToken()) / 1000;
				int year = Integer.parseInt(st.nextToken());
				d[j] = new Data(year, Double.parseDouble(df.format(money)));
			}
			Arrays.sort(d);
			System.out.println(name + ":");
			for(int j = 0; j < n; j++) {
				System.out.print(d[j].y + " ");
				for(int k = 0; k < d[j].m; k++)
					System.out.print("*");
				System.out.println();
			}
		}
		sc.close();
	}
	static class Data implements Comparable<Data> {
		public int y;
		public double m;
		public int compareTo(Data d) {
			return this.y - d.y;
		}
		public Data(int yy, double mm) {
			this.y = yy;
			this.m = mm;
		}
	}
}