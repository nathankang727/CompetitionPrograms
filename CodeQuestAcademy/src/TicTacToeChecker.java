import java.util.*;
public class TicTacToeChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String input = sc.nextLine();
			String[] s = input.split("");
			char[] c = new char[10];
			for(int j = 1; j <= 9; j++)
				c[j] = s[j - 1].charAt(0);
			if(c[1] == 'X' && c[1] == c[2] && c[2] == c[3] || c[4] == 'X' && c[4] == c[5] && c[5] == c[6] || c[7] == 'X' && c[7] == c[8]
					&& c[8] == c[9] || c[1] == 'X' && c[1] == c[4] && c[4] == c[7] || c[2] == 'X' && c[2] == c[5] && c[5] == c[8] || 
					c[3] == 'X' && c[3] == c[6] && c[6] == c[9] || c[1] == 'X' && c[1] == c[5] && c[5] == c[9] || 
					c[3] == 'X' && c[3] == c[5] && c[5] == c[7]) {
				System.out.println(input + " = X WINS");
			}
			else if(c[1] == 'O' && c[1] == c[2] && c[2] == c[3] || c[4] == 'O' && c[4] == c[5] && c[5] == c[6] || c[7] == 'O' &&
					c[7] == c[8] && c[8] == c[9] || c[1] == 'O' && c[1] == c[4] && c[4] == c[7] || c[2] == 'O' && c[2] == c[5] &&
					c[5] == c[8] || c[3] == 'O' && c[3] == c[6] && c[6] == c[9] || c[1] == 'O' && c[1] == c[5] && c[5] == c[9] || 
					c[3] == 'O' && c[3] == c[5] && c[5] == c[7]) {
				System.out.println(input + " = O WINS");
			}
			else
				System.out.println(input + " = TIE");
		}
		sc.close();
	}
}