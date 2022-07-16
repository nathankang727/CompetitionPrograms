import java.util.*;
import java.io.*;
public class dna2 {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < n; i++)
			list.add(br.readLine());
		dfs(list);
		System.out.println(answer);
		br.close();
	}
	public static void dfs(ArrayList<String> list) {
		if(list.size() == 1) {
			answer = Math.min(answer, list.get(0).length());
			return;
		}
		for(int i = 0; i < list.size(); i++) {
			for(int j = i + 1; j < list.size(); j++) {
				if(i == j)
					continue;
				String a = list.get(i);
				String b = list.get(j);
				String c = merge(a, b);
				String d = merge(b, a);
				String e = "";
				if(c.length() < d.length())
					e = c;
				else
					e = d;
				ArrayList<String> temp = new ArrayList<String>();
				for(int k = 0; k < list.size(); k++) {
					if(i == k || j == k)
						continue;
					temp.add(list.get(k));
				}
				temp.add(e);
				dfs(temp);
			}
		}
	}
	public static String merge(String a, String b) {
		String overlap = a + b;
		for(int i = 0; i < a.length(); i++) {
			String temp = a.substring(i, a.length());
			if(temp.length() <= b.length() && temp.equals(b.substring(0, temp.length()))) {
				overlap = a + b.substring(temp.length());
				break;
			}
		}
		return overlap;
	}
}