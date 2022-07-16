import java.util.*;
public class BrickHouse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int s = sc.nextInt();
			int l = sc.nextInt();
			int x = sc.nextInt();
			if(s < x % 5) {
				System.out.println("false");
				continue;
			}
			s -= x % 5;
			if(l + s / 5 < x / 5)
				System.out.println("false");
			else
				System.out.println("true");
		}
		sc.close();
	}
}