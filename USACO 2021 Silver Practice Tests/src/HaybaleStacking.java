import java.util.*;
import java.io.*;
public class HaybaleStacking {
	static int n, m;
	static long bales[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		bales = new long[n];
		for(int i = 0; i < n; i++)
			bales[i] = Long.parseLong(st.nextToken());
		long low = 1;
		long high = (long)(10000000) * (long)(10000000) * (long)(10);
		long mid = 0;
		long ans = -1;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				high = mid - 1;
			}
			else
				low = mid + 1;
		}
		if(ans == -1)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(ans);
		br.close();
	}
	public static boolean check(long h) {
		ArrayList<Long> stacks = new ArrayList<Long>();
		ArrayList<Long> tops = new ArrayList<Long>();
		for(int i = 0; i < n; i++) {
			if(stacks.size() == 0) {
				stacks.add(bales[i]);
				tops.add(bales[i]);
			}
			else if(tops.get(tops.size() - 1) >= bales[i] && stacks.get(tops.size() - 1) + bales[i] <= h) {
				stacks.set(stacks.size() - 1, stacks.get(tops.size() - 1) + bales[i]);
				tops.set(tops.size() - 1, bales[i]);
			}
			else {
				stacks.add(bales[i]);
				tops.add(bales[i]);
			}
			if(h == 13)
				System.out.println(stacks.toString() + "\n" + tops.toString() + "\n");
			if(stacks.size() > m)
				return false;
		}
		return true;
	}
}