import java.util.*;
public class BiggerIsBetter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int max = 0;
			while(st.hasMoreTokens())
				max = Math.max(max, Integer.parseInt(st.nextToken()));
			System.out.println(max);
		}
		sc.close();
	}
}