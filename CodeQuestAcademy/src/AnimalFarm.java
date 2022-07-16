import java.util.*;
public class AnimalFarm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int turkey = sc.nextInt();
			int goat = sc.nextInt();
			int horse = sc.nextInt();
			System.out.println(2 * turkey + 4 * (goat + horse));
		}
		sc.close();
	}
}
