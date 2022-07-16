package Jan2016Silver;
import java.util.*;
import java.io.*;
public class angry {
	static int n, k;
	static int[] haybales;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("angrySilver.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("angrySilver.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		haybales = new int[n];
		for(int i = 0; i < n; i++)
			haybales[i] = Integer.parseInt(br.readLine());
		Arrays.sort(haybales);
		int low = 1;
		int high = (haybales[n - 1] + 1) / 2;
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
		pw.println(ans);
		br.close();
		pw.close();
	}
	public static boolean check(int radius) {
		ArrayList<Boolean> nuked = new ArrayList<Boolean>();
		for(int i = 0; i < n; i++)
			nuked.add(false);
		int cowsUsed = 0;
		while(nuked.contains(false)) {
			int index = nuked.indexOf(false);
			int start = index;
			int end = Arrays.binarySearch(haybales, haybales[start] + 2 * radius);
			if(end >= 0)
				for(int i = start; i <= end; i++)
					nuked.set(i, true);
			else {
				end = -(Arrays.binarySearch(haybales, haybales[start] + 2 * radius) + 1);
				for(int i = start; i < end; i++)
					nuked.set(i, true);
			}
			++cowsUsed;
		}
		return cowsUsed <= k;
	}
}