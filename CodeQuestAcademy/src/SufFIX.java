import java.util.*;
public class SufFIX {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String input = sc.nextLine();
			int n = Integer.parseInt(input.substring(0, input.indexOf("th")));
			if(n % 100 == 11 || n % 100 == 12 || n % 100 == 13)
				System.out.println(n + "th");
			else if(n % 10 == 1)
				System.out.println(n + "st");
			else if(n % 10 == 2)
				System.out.println(n + "nd");
			else if(n % 10 == 3)
				System.out.println(n + "rd");
			else
				System.out.println(n + "th");
		}
		sc.close();
	}
}