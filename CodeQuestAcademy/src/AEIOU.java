import java.io.*;
public class AEIOU {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int cnt = 0;
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++)
				if(s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u')
					++cnt;
			System.out.println(cnt);
		}
		br.close();
	}
}