import java.util.*;
public class PassFail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
			System.out.println(sc.nextInt() >= 70 ? "PASS" : "FAIL");
		sc.close();
	}
}