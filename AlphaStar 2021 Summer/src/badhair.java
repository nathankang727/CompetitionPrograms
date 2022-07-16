import java.util.*;
import java.io.*;
public class badhair {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] h = new int[n];
		for(int i = 0; i < n; i++)
			h[i] = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<Integer>();
		long cnt = 0;
		for(int i = 0; i < n; i++) {
			while(!s.isEmpty() && s.peek() <= h[i])
				s.pop();
			cnt += s.size();
			s.push(h[i]);
		}
		System.out.println(cnt);
		br.close();
	}
}