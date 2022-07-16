import java.util.*;
import java.io.*;
public class angry {
	static int n, k, haybales[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		haybales = new int[n];
		for(int i = 0; i < n; i++)
			haybales[i] = Integer.parseInt(br.readLine());
		Arrays.sort(haybales);
		int low = 0;
		int high = (haybales[n - 1] - haybales[0] + 1) / 2;
		int mid = 0;
		int ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				high = mid - 1;
			}
			else
				low = mid + 1;
		}
		System.out.println(ans);
		br.close();
	}
	public static boolean check(int radius) {
		ArrayList<Boolean> bombed = new ArrayList<Boolean>();
		for(int i = 0; i < n; i++)
			bombed.add(false);
		int cowsUsed = 0;
		while(bombed.contains(false)) {
			int index = bombed.indexOf(false);
			int start = index;
			int end = Arrays.binarySearch(haybales, haybales[start] + 2 * radius);
			if(end >= 0)
				for(int i = start; i <= end; i++)
					bombed.set(i, true);
			else {
				end = -(Arrays.binarySearch(haybales, haybales[start] + 2 * radius) + 1);
				for(int i = start; i < end; i++)
					bombed.set(i, true);
			}
			++cowsUsed;
		}
		return cowsUsed <= k;
	}
}