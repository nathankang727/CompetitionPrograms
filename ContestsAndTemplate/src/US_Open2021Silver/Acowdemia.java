package US_Open2021Silver;
import java.util.*;
import java.io.*;
public class Acowdemia {
	static int n, k, l, c[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		c = new int[n];
		for(int i = 0; i < n; i++)
			c[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(c);
		int low = 0;
		int high = n;
		int mid = 0;
		int ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				low = mid + 1;
			}
			else
				high = mid - 1;
		}
		System.out.println(ans);
		br.close();
	}
	public static boolean check(int mid) {
		int h = 0;
		ArrayList<Integer> notH = new ArrayList<Integer>();
		for(int i = n - 1; i >= 0; i--) {
			if(c[i] >= mid)
				++h;
			else
				notH.add(c[i]);
		}
		Collections.sort(notH, Collections.reverseOrder());
		int max = 0;
		for(int i = 0; i < mid - h; i++)
			max += Math.max(max, mid - notH.get(i));
		return max <= k;
	}
}