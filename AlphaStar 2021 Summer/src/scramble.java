import java.util.*;
import java.io.*;
public class scramble {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Data> names = new ArrayList<Data>();
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			names.add(new Data(sort(input), i, true));
			names.add(new Data(reverse(input), i, false));
		}
		Collections.sort(names);
		int[][] ans = new int[n][2];
		int sorted = 1;
		int reversed = 1;
		for(int i = 0; i < n * 2; i++) {
			if(names.get(i).b) {
				++sorted;
				ans[names.get(i).i][0] = reversed;
			}
			else {
				++reversed;
				ans[names.get(i).i][1] = sorted - 1;
			}
		}
		for(int i = 0; i < n; i++)
			System.out.println(ans[i][0] + " " + ans[i][1]);
		br.close();
	}
	static class Data implements Comparable<Data> {
		public String n;
		public int i;
		public boolean b;
		public int compareTo(Data d) {
			return this.n.compareTo(d.n);
		}
		public Data(String name, int index, boolean isSorted) {
			this.n = name;
			this.i = index;
			this.b = isSorted;
		}
	}
	public static String sort(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		String res = "";
		for(int i = 0; i < c.length; i++)
			res += c[i];
		return res;
	}
	public static String reverse(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		String res = "";
		for(int i = c.length - 1; i >= 0; i--)
			res += c[i];
		return res;
	}
}