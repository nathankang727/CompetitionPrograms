import java.util.*;
public class PiecewiseEncrypter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < t; i++) {
			String input = sc.nextLine();
			String res = "";
			for(int j = 0; j < input.length(); j++) {
				int value = input.charAt(j) - 'A' + 1;
				if(value >= 1 && value <= 5)
					value += 6;
				else if(value >= 6 && value <= 10)
					value *= value;
				else if(value >= 11 && value <= 15)
					value = value % 3 * 5 + 1;
				else if(value >= 16 && value <= 20)
					value = digits(value) * 8;
				else
					value = factor(value) * 2;
				value %= 26;
				if(value == 0)
					res += input.charAt(j);
				else
					res += alphabet.charAt(value - 1);
			}
			System.out.println(res);
		}
		sc.close();
	}
	public static int digits(int n) {
		String s = String.valueOf(n);
		int cnt = 0;
		for(int i = 0; i < s.length(); i++)
			cnt += Integer.parseInt(s.substring(i, i + 1));
		return cnt;
	}
	public static int factor(int n) {
		int gcf = 1;
		for(int i = 2; i <= n / 2; i++)
			if(n % i == 0)
				gcf = i;
		return gcf;
	}
}