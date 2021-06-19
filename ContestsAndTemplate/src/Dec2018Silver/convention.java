package Dec2018Silver;
import java.util.*;
import java.io.*;
public class convention {
	static int n, m, c;
	static int[] data;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("convention.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("convention.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		data = new int[n];
		for(int i = 0; i < n; i++)
			data[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(data);
		int low = 0;
		int high = 1000000000;
		int mid = 0;
		int ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				high = mid - 1;
				ans = mid;
			}
			else
				low = mid + 1;
		}
		pw.println(ans);
		br.close();
		pw.close();
	}
	public static boolean check(int mid) {
		int bus = 1;
		int cow = 0;
		int start = data[0];
		for(int i = 0; i < n; i++) {
			int wait = data[i] - start;
			++cow;
			if(wait > mid || cow > c) {
				++bus;
				start = data[i];
				cow = 1;
			}
		}
		return bus <= m;
	}
}