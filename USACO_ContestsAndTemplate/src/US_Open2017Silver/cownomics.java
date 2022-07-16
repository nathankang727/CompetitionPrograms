package US_Open2017Silver;
import java.util.*;
import java.io.*;
public class cownomics {
	static int n, m;
	static String s[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("cownomics.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("cownomics.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = new String[n * 2];
		for(int i = 0; i < n * 2; i++)
			s[i] = br.readLine();
		int ans = 0;
		for(int i = 0; i < m - 2; i++)
			for(int j = i + 1; j < m - 1; j++)
				for(int k = j + 1; k < m; k++)
					if(check(i, j, k))
						++ans;
		pw.println(ans);
		br.close();
		pw.close();
	}
	public static boolean check(int i, int j, int k) {
		Set<String> set = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		for(int x = 0; x < n; x++)
			set.add("" + s[x].charAt(i) + s[x].charAt(j) + s[x].charAt(k));
		for(int x = n; x < n * 2; x++)
			set2.add("" + s[x].charAt(i) + s[x].charAt(j) + s[x].charAt(k));
		for(String s : set)
			if(set2.contains(s))
				return false;
		return true;
	}
}