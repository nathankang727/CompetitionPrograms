import java.io.*;
public class bigdance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(dfs(n, 1));
		br.close();
	}
	public static int dfs(int n, int x) {
		if(n == 1)
			return 0;
		else if(n == 2)
			return x * (x + 1);
		if(n % 2 == 1)
			return dfs(n / 2 + 1, x) + dfs(n / 2, x + n / 2 + 1);
		return dfs(n / 2, x) + dfs(n / 2, x + n / 2);
	}
}