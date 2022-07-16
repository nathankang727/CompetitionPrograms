import java.util.*;
public class PlayfairCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int x = sc.nextInt();
			String keyword = sc.next();
			char[][] grid = new char[5][5];
			String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
			LinkedHashSet<Character> set = new LinkedHashSet<Character>();
			for(int j = 0; j < keyword.length(); j++) {
				if(keyword.charAt(j) == 'J')
					set.add('X');
				else
					set.add(keyword.charAt(j));
			}
			int index = 0;
			for(Character c : set) {
				grid[index / 5][index % 5] = c;
				alphabet = alphabet.replace(c.toString(), "");
				++index;
			}
			while(!alphabet.isEmpty()) {
				grid[index / 5][index % 5] = alphabet.charAt(0);
				alphabet = alphabet.substring(1);
				++index;
			}
			for(int j = 0; j < x; j++) {
				String ciphertext = sc.next();
				String message = "";
				for(int k = 0; k < ciphertext.length(); k += 2) {
					String code = ciphertext.substring(k, k + 2);
					int x1 = 0;
					int x2 = 0;
					int y1 = 0;
					int y2 = 0;
					for(int l = 0; l < 5; l++) {
						for(int m = 0; m < 5; m++) {
							if(grid[l][m] == code.charAt(0)) {
								x1 = l;
								y1 = m;
							}
							else if(grid[l][m] == code.charAt(1)) {
								x2 = l;
								y2 = m;
							}
						}
					}
					if(x1 == x2) {
						--y1;
						--y2;
						if(y1 == -1)
							y1 = 4;
						if(y2 == -1)
							y2 = 4;
					}
					else if(y1 == y2) {
						--x1;
						--x2;
						if(x1 == -1)
							x1 = 4;
						if(x2 == -1)
							x2 = 4;
					}
					else {
						int temp = y1;
						y1 = y2;
						y2 = temp;
					}
					message += grid[x1][y1] + "" + grid[x2][y2];
				}
				System.out.println(message.toLowerCase());
			}
		}
		sc.close();
	}
}