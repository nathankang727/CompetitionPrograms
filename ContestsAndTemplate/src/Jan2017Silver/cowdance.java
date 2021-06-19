package Jan2017Silver;
import java.util.*;
import java.io.*;
public class cowdance {
	static int n, t, cows[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("cowdance.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("cowdance.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		cows = new int[n];
		for(int i = 0; i < n; i++)
			cows[i] = Integer.parseInt(br.readLine());
		int low = 1;
		int high = n;
		int mid = 0;
		int ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		pw.println(ans);
		br.close();
		pw.close();
	}
	public static boolean check(int num) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < num; i++)
			pq.add(cows[i]);
		for(int i = num; i < n; i++)
			pq.add(pq.poll() + cows[i]);
		int size = pq.size();
		for(int i = 0; i < size; i++)
			if(pq.poll() > t)
				return false;
		return true;
	}
}