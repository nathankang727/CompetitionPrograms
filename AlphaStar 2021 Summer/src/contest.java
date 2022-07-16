import java.util.*;
import java.io.*;
public class contest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] a = new boolean[n + 1][n + 1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u][v] = true;
		}
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				if(a[j][i])
					for(int k = 1; k <= n; k++)
						a[j][k] = a[j][k] || a[j][i] && a[i][k];
		int[] rowSum = new int[n + 1];
		int[] colSum = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(a[i][j]) {
					++rowSum[i];
					++colSum[j];
				}
			}
		}
		int result = 0;
		for(int i = 1; i <= n; i++)
			if(rowSum[i] + colSum[i] + 1 == n)
				++result;
		System.out.println(result);
		br.close();
	}
}