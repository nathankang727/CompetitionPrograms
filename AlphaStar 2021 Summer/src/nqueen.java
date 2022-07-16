import java.io.*;
public class nqueen {
	static int n, res, x[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		res = 0;
		x = new int[n];
		dfs(0);
		System.out.println(res);
		br.close();
	}
	public static void dfs(int i) {
		if(i == n) {
			++res;
			return;
		}
		for(int j = 0; j < n; j++) {
			x[i] = j;
			if(works(i))
				dfs(i + 1);
		}
	}
	public static boolean works(int i) {
		for(int j = 0; j < i; j++)
			if(x[i] == x[j] || Math.abs(i - j) == Math.abs(x[i] - x[j]))
				return false;
		return true;
	}
}