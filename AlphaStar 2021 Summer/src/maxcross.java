import java.util.*;
import java.io.*;
public class maxcross {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] lights = new int[n];
		for(int i = 0; i < n; i++)
			lights[i] = 1;
		for(int i = 0; i < b; i++)
			lights[Integer.parseInt(br.readLine()) - 1] = 0;
		int[] prefixSums = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += lights[i];
			prefixSums[i] = sum;
		}
		int max = 0;
		for(int i = 0; i < n - k; i++)
			max = Math.max(max, prefixSums[i + k] - prefixSums[i]);
		System.out.println(max >= k ? 0 : k - max);
		br.close();
	}
}