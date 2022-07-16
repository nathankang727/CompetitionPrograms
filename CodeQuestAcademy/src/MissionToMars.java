import java.util.*;
import java.text.*;
import java.math.*;
public class MissionToMars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0");
		df.setRoundingMode(RoundingMode.HALF_UP);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			double dist = sc.nextDouble() * 1000000;
			double speed = sc.nextDouble() / 3600;
			double time = dist / speed;
			int day = (int)(time / 86400);
			time -= 86400 * (int)(time / 86400);
			int hour = (int) (time / 3600);
			time -= 3600 * (int)(time / 3600);
			int minute = (int) (time / 60);
			time -= 60 * (int)(time / 60);
			int second = Integer.parseInt(df.format(time));
			if(second == 60) {
				second = 0;
				++minute;
			}
			System.out.println("Time to Mars: " + day + " days, " + hour + " hours, " + minute + " minutes, " + second + " seconds");
		}
		sc.close();
	}
}