import java.util.*;
import java.io.*;
public class herding {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] cows = new long[n];
		for(int i = 0; i < n; i++)
			cows[i] = Long.parseLong(br.readLine());
		Arrays.sort(cows);
		int j = 0, k = 0;
		for(int i = 0; i < n - 1; i++) {
			while(j < n - 1 && cows[j + 1] - cows[i] < n)
				++j;
			k = Math.max(k, j - i + 1);
		}
		if(cows[n - 2] - cows[0] == n - 2 && cows[n - 1] - cows[n - 2] > 2 || cows[n - 1] - cows[1] == n - 2 && cows[1] - cows[0] > 2)
			System.out.println(2);
		else
			System.out.println(n - k);
		long a = cows[n - 1] - cows[n - 2] - (long)(1);
		long b = cows[1] - cows[0] - (long)(1);
		long spaces = 0;
		for(int i = 0; i < n - 1; i++)
			spaces += cows[i + 1] - cows[i] - (long)(1);
		System.out.println(spaces - (long)(Math.min(a, b)));
		br.close();
	}
}