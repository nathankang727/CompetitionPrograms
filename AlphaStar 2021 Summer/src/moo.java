import java.io.*;
public class moo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(dfs(n));
		br.close();
	}
	public static char dfs(int n) {
		if(n == 1)
			return 'm';
		if(n == 2 || n == 3)
			return 'o';
		int length = 3;
		int midLength = 3;
		while(length <= n) {
			++midLength;
			length = 2 * length + midLength;
		}
		int preLength = (length - midLength) / 2;
		if(n > preLength + midLength)
			return dfs(n - (preLength + midLength));
		if(n == preLength + 1)
			return 'm';
		return 'o';
	}
}