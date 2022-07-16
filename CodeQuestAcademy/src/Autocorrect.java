import java.util.*;
public class Autocorrect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int d = sc.nextInt();
			int w = sc.nextInt();
			sc.nextLine();
			String[] dictionary = new String[d];
			for(int j = 0; j < d; j++)
				dictionary[j] = sc.nextLine();
			for(int j = 0; j < w; j++) {
				String word = sc.nextLine();
				int diff = word.length() + 1;
				String correct = "";
				for(int k = 0; k < d; k++) {
					if(word.length() != dictionary[k].length())
						continue;
					int diffCnt = 0;
					for(int l = 0; l < word.length(); l++)
						if(word.charAt(l) != dictionary[k].charAt(l))
							++diffCnt;
					if(diffCnt < diff) {
						diff = diffCnt;
						correct = dictionary[k];
					}
				}
				System.out.println(correct);
			}
		}
		sc.close();
	}
}