import java.io.*;
public class TowerOfHanoi {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int z = 0; z < t; z++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(n);
			solve(n, "A", "B", "C");
		}
		br.close();
	}
	public static void solve(int n, String start, String helper, String end) {
		if(n == 1)
			System.out.println(start + "->" + end);
		else {
			solve(n - 1, start, end, helper);
	        System.out.println(start + "->" + end);
	        solve(n - 1, helper, start, end);
		}
	}
}