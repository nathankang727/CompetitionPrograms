import java.util.*;
public class CaesarCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int key = Integer.parseInt(sc.nextLine());
			String message = sc.nextLine();
			String ans = "";
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			for(int j = 0; j < message.length(); j++) {
				char c = message.charAt(j);
				if(c == ' ') {
					ans += " ";
					continue;
				}
				int shift = c - 'a' - key;
				if(shift < 0)
					shift = 26 + shift;
				if(shift > 25)
					shift %= 26;
				ans += alphabet.substring(shift, shift + 1);
			}
			System.out.println(ans);
		}
		sc.close();
	}
}