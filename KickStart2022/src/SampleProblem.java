import java.util.*;
import java.io.*;
public class SampleProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j = 0; j < n; j++)
				sum += Integer.parseInt(st.nextToken());
			System.out.println("Case #" + (i + 1) + ": " + (sum % m));
		}
		br.close();
	}
}