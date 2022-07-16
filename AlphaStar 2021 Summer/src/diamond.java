import java.util.*;
import java.io.*;
public class diamond {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] diamonds = new int[n + 1];
		for(int i = 0; i < n; i++)
			diamonds[i] = Integer.parseInt(br.readLine());
		diamonds[n] = Integer.MAX_VALUE;
		Arrays.sort(diamonds);
		int[] length = new int[n];
		int index1 = 0;
		int index2 = 1;
		while(index1 < n) {
			if(diamonds[index2] - diamonds[index1] > k) {
				length[index1] = index2 - index1;
				++index1;
			}
			else
				++index2;
		}
		int[] max = new int[n + 1];
		int maxLength = 0;
		for(int i = n - 1; i >= 0; i--) {
			maxLength = Math.max(maxLength, length[i]);
			max[i] = maxLength;
		}
		int ans = 0;
		for(int i = 0; i < n; i++)
			ans = Math.max(ans, length[i] + max[i + length[i]]);
		System.out.println(ans);
		br.close();
	}
}