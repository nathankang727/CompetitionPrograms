import java.util.*;
import java.io.*;
public class AnagramChecker {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			String[] s = str.split("\\|");
			int[][] letters = new int[2][26];
			for(int j = 0; j < 2; j++)
				for(int k = 0; k < s[j].length(); k++)
					++letters[j][s[j].charAt(k) - 'A'];
			if(s[0].equals(s[1]) || !Arrays.toString(letters[0]).equals(Arrays.toString(letters[1])))
				System.out.println(str + " = NOT AN ANAGRAM");
			else
				System.out.println(str + " = ANAGRAM");
		}
		br.close();
	}
}