import java.util.*;
public class updog {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String input = sc.nextLine();
			String keyword = input.substring(15, input.lastIndexOf(" in here"));
			if(keyword.length() >= 2 && keyword.substring(0, 2).equals("up"))
				System.out.println("what\'s that");
			else
				System.out.println("what\'s " + keyword);
		}
		sc.close();
	}
}