import java.util.*;
import java.io.*;
public class TandemBicycle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean q = Integer.parseInt(br.readLine()) == 1 ? true : false;
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] d = new int[n];
		for(int i = 0; i < n; i++)
			d[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(d);
		st = new StringTokenizer(br.readLine());
		int[] p = new int[n];
		for(int i = 0; i < n; i++)
			p[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(p);
		int ans = 0;
		if(q)
			for(int i = 0; i < n; i++)
				ans += Math.max(d[i], p[i]);
		else
			for(int i = 0; i < n; i++)
				ans += Math.max(d[i], p[n - i - 1]);
		System.out.println(ans);
		br.close();
	}
}