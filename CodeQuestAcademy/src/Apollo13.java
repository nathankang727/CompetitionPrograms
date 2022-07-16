import java.util.*;
import java.text.*;
public class Apollo13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("000.00");
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			double x = sc.nextDouble() - 180;
			double y = sc.nextDouble() - 180;
			double z = sc.nextDouble() - 180;
			x = x < 0 ? 360 + x : x;
			y = y < 0 ? 360 + y : y;
			z = z < 0 ? 360 + z : z;
			System.out.println(df.format(x) + " " + df.format(y) + " " + df.format(z));
		}
		sc.close();
	}
}