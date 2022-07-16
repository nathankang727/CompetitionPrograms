import java.util.*;
public class WhoSellsMoreNewspapers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int times = sc.nextInt();
			int herald = sc.nextInt();
			if(times == herald)
				System.out.println("Times and Herald have the same number of subscribers");
			else
				System.out.println((times > herald ? "Times" : "Herald") + " has " + Math.abs(times - herald) + " more subscribers");
		}
		sc.close();
	}
}