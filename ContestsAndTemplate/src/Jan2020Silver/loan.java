package Jan2020Silver;
import java.util.*;
import java.io.*;
public class loan {
	static long n, k, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("loan.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("loan.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		long low = 1;
		long high = (long)(Math.pow(10, 12));
		long mid = 0;
		long ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				low = mid + 1;
				ans = mid;
			}
			else {
				high = mid - 1;
			}
		}
		pw.println(ans);
		br.close();
		pw.close();
	}
	public static boolean check(long x) {
		long g = 0;
		for(int i = 0; i < k; i++) {
			long y = (n - g) / x;
			if(y < m)
				y = m;
			g += y;
		}
		return g >= n;
	}
}