package Training1_5;
/*
ID: nathank3
LANG: JAVA
TASK: milk3
*/
import java.util.*;
import java.io.*;
public class milk3 {
	static int A, B, C;
	static boolean memo[][][];
	static TreeSet<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("milk3.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("milk3.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		memo = new boolean[21][21][21];
		memo[0][0][C] = true;
		set = new TreeSet<Integer>();
		dfs(0, 0, C);
		Set<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < 21; i++)
			for(int j = 0; j < 21; j++)
				if(memo[0][i][j])
					set.add(j);
		boolean b = false;
		for(int i : set) {
			if(!b) {
				pw.print(i);
				b = true;
			}
			else
				pw.print(" " + i);
		}
		pw.println();
		br.close();
		pw.close();
	}
	public static void dfs(int a, int b, int c) {
		int aa = a;
		int bb = b;
		int cc = c;
		int diff = 0;
		if(a > 0 && b < B) {
			diff = Math.min(a, B - b);
			b += diff;
			a -= diff;
			if(!memo[a][b][c]) {
				memo[a][b][c] = true;
				dfs(a, b, c);
			}
		}
		a = aa;
		b = bb;
		c = cc;
		if(a > 0 && c < C) {
			diff = Math.min(a, C - c);
			c += diff;
			a -= diff;
			if(!memo[a][b][c]) {
				memo[a][b][c] = true;
				dfs(a, b, c);
			}
		}
		a = aa;
		b = bb;
		c = cc;
		if(b > 0 && c < C) {
			diff = Math.min(b, C - c);
			c += diff;
			b -= diff;
			if(!memo[a][b][c]) {
				memo[a][b][c] = true;
				dfs(a, b, c);
			}
		}
		a = aa;
		b = bb;
		c = cc;
		if(b > 0 && a < A) {
			diff = Math.min(b, A - a);
			a += diff;
			b -= diff;
			if(!memo[a][b][c]) {
				memo[a][b][c] = true;
				dfs(a, b, c);
			}
		}
		a = aa;
		b = bb;
		c = cc;
		if(c > 0 && a < A) {
			diff = Math.min(c, A - a);
			a += diff;
			c -= diff;
			if(!memo[a][b][c]) {
				memo[a][b][c] = true;
				dfs(a, b, c);
			}
		}
		a = aa;
		b = bb;
		c = cc;
		if(c > 0 && b < B) {
			diff = Math.min(c, B - b);
			b += diff;
			c -= diff;
			if(!memo[a][b][c]) {
				memo[a][b][c] = true;
				dfs(a, b, c);
			}
		}
	}
}