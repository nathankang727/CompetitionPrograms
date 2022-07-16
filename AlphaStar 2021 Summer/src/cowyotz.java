import java.util.*;
import java.io.*;
public class cowyotz {
	static int n, s, e, exp[][], cnt[], res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		exp = new int[e][s + 1];
		cnt = new int[s + 1];
		res = 0;
		for(int i = 0; i < e; i++) {
			String[] input = br.readLine().replace("+", " ").split(" ");
			for(int j = 0; j < input.length; j++) {
				String[] input2 = input[j].replace("x", " ").split(" ");
				exp[i][Integer.parseInt(input2[1])] = Integer.parseInt(input2[0]);
			}
		}
		check(1);
		System.out.println(res);
		br.close();
	}
	public static void check(int i) {
		if(i > n) {
			if(works())
				++res;
			return;
		}
		for(int j = 1; j <= s; j++) {
			++cnt[j];
			check(i + 1);
			--cnt[j];
		}
	}
	public static boolean works() {
		for(int i = 0; i < e; i++) {
			boolean didBreak = false;
			for(int j = 1; j <= s; j++) {
				if(cnt[j] < exp[i][j]) {
					didBreak = true;
					break;
				}
			}
			if(!didBreak)
				return true;
		}
		return false;
	}
}