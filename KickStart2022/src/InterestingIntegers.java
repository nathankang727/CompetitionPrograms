import java.util.*;
import java.io.*;
public class InterestingIntegers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			for(long j = a; j <= b; j++) {
				
			}
			System.out.println();
		}
		br.close();
	}
}