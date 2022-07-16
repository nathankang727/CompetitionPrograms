import java.util.*;
public class CollatzConjecture {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			long n = sc.nextLong();
			System.out.print(n + ":");
			int cnt = 1;
			while(n != 1) {
				if(n % 2 == 0)
					n /= 2;
				else
					n = 3 * n + 1;
				++cnt;
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}