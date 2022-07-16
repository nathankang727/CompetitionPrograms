import java.util.*;
public class fractal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			for(int j = 0; j < n; j++) {
				for(int k = n - 1; k >= 0; k--) {
					System.out.print(" ");
				}
				
			}
		}
		sc.close();
	}
}