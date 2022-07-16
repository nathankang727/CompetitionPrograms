import java.util.*;
import java.io.*;
public class censor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		char[] t = br.readLine().toCharArray();
		ArrayList<Character> ans = new ArrayList<Character>();
		for(int i = 0; i < s.length; i++) {
			ans.add(s[i]);
			boolean didBreak = false;
			for(int j = 0; j < t.length; j++) {
				if(ans.size() < t.length || ans.get(ans.size() - t.length + j) != t[j]) {
					didBreak = true;
					break;
				}
			}
			if(!didBreak)
				for(int j = 0; j < t.length; j++)
					ans.remove(ans.size() - 1);
		}
		for(int i = 0; i < ans.size(); i++)
			System.out.print(ans.get(i));
		br.close();
	}
}