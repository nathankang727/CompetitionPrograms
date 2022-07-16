import java.util.*;
public class Prob08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String input = sc.nextLine();
			input = input.replace("A", "0").replace("T", "0").replace("C", "1").replace("G", "1");
			for(int j = 0; j < input.length(); j += 7) {
				int n = Integer.parseInt(input.substring(j, j + 7), 2);
				System.out.print((char)(n));
			}
			System.out.println();
		}
		sc.close();
	}
}