import java.util.*;
import java.io.*;
public class stacking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] ranges = new int[n + 1];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			++ranges[Integer.parseInt(st.nextToken()) - 1];
			--ranges[Integer.parseInt(st.nextToken())];
		}
		int[] nums = new int[n];
		int temp = 0;
		for(int i = 0; i < n; i++) {
			temp += ranges[i];
			nums[i] = temp;
		}
		Arrays.sort(nums);
		System.out.println(nums[nums.length / 2]);
		br.close();
	}
}