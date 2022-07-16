import java.util.*;
public class wordsearch {
	static int r, c;
	static String word, reverse;
	static char grid[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			word = sc.nextLine();
			reverse = reversed(word);
			r = sc.nextInt();
			c = sc.nextInt();
			sc.nextLine();
			grid = new char[r][c];
			for(int j = 0; j < r; j++) {
				String input = sc.nextLine();
				for(int k = 0; k < c; k++)
					grid[j][k] = input.charAt(k);
			}
			if(i < t - 1)
				sc.nextLine();
			hN();
			hR();
			vN();
			vR();
			if(i < t - 1)
				System.out.println();
		}
		sc.close();
	}
	public static String reversed(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		sb.reverse();
		return sb.toString();
	}
	public static void hN() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j <= c - word.length(); j++) {
				boolean didBreak = false;
				for(int k = j; k < j + word.length(); k++) {
					if(grid[i][k] != word.charAt(k - j)) {
						didBreak = true;
						break;
					}
				}
				if(!didBreak) {
					for(int k = 0; k < r; k++) {
						for(int l = 0; l < c; l++) {
							if(k == i && l >= j && l < j + word.length())
								System.out.print(grid[k][l]);
							else
								System.out.print("#");
						}
						System.out.println();
					}
					return;
				}
			}
		}
	}
	public static void hR() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j <= c - reverse.length(); j++) {
				boolean didBreak = false;
				for(int k = j; k < j + reverse.length(); k++) {
					if(grid[i][k] != reverse.charAt(k - j)) {
						didBreak = true;
						break;
					}
				}
				if(!didBreak) {
					for(int k = 0; k < r; k++) {
						for(int l = 0; l < c; l++) {
							if(k == i && l >= j && l < j + reverse.length())
								System.out.print(grid[k][l]);
							else
								System.out.print("#");
						}
						System.out.println();
					}
					return;
				}
			}
		}
	}
	public static void vN() {
		for(int i = 0; i < c; i++) {
			for(int j = 0; j <= r - word.length(); j++) {
				boolean didBreak = false;
				for(int k = j; k < j + word.length(); k++) {
					if(grid[k][i] != word.charAt(k - j)) {
						didBreak = true;
						break;
					}
				}
				if(!didBreak) {
					for(int k = 0; k < r; k++) {
						for(int l = 0; l < c; l++) {
							if(l == i && k >= j && k < j + word.length())
								System.out.print(grid[k][l]);
							else
								System.out.print("#");
						}
						System.out.println();
					}
					return;
				}
			}
		}
	}
	public static void vR() {
		for(int i = 0; i < c; i++) {
			for(int j = 0; j <= r - reverse.length(); j++) {
				boolean didBreak = false;
				for(int k = j; k < j + reverse.length(); k++) {
					if(grid[k][i] != reverse.charAt(k - j)) {
						didBreak = true;
						break;
					}
				}
				if(!didBreak) {
					for(int k = 0; k < r; k++) {
						for(int l = 0; l < c; l++) {
							if(l == i && k >= j && k < j + reverse.length())
								System.out.print(grid[k][l]);
							else
								System.out.print("#");
						}
						System.out.println();
					}
					return;
				}
			}
		}
	}
}