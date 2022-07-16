import java.util.*;
import java.io.*;
public class ChallengeNine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			int digit = 0;
			String n = br.readLine();
			for(int j = 0; j < n.length(); j++)
				digit = (digit + Integer.parseInt(n.substring(j, j + 1))) % 9;
			if(digit == 0)
				digit = 9;
			int ans = 9 - digit;
			ArrayList<String> list = new ArrayList<String>();
			if(ans != 0)
				list.add(ans + n);
			for(int j = 1; j < n.length(); j++)
				list.add(n.substring(0, j) + ans + n.substring(j));
			list.add(n + ans);
			Collections.sort(list);
			System.out.println("Case #" + i + ": " + list.get(0));
		}
		br.close();
	}
}