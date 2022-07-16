import java.util.*;
import java.io.*;
public class d1000000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] s = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				s[j] = Integer.parseInt(st.nextToken());
			Arrays.sort(s);
			int cnt = 0;
			for(int j = 0; j < n; j++)
				if(s[j] >= cnt + 1)
					++cnt;
			System.out.println("Case #" + i + ": " + cnt);
		}
		br.close();
	}
}