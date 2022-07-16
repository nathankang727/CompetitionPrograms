import java.util.*;
import java.math.*;
import java.text.*;
public class BatterUp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.000");
		df.setRoundingMode(RoundingMode.HALF_UP);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String input = sc.nextLine();
			String name = input.substring(0, input.indexOf(":"));
			input = input.substring(input.indexOf(":") + 1);
			String[] bats = input.split(",");
			int total = 0;
			int atBats = 0;
			for(int j = 0; j < bats.length; j++) {
				if(bats[j].equals("BB"))
					continue;
				++atBats;
				if(bats[j].equals("1B"))
					++total;
				else if(bats[j].equals("2B"))
					total += 2;
				else if(bats[j].equals("3B"))
					total += 3;
				else if(bats[j].equals("HR"))
					total += 4;
			}
			if(atBats == 0)
				System.out.println(name + "=0.000");
			else
				System.out.println(name + "=" + df.format((double)(total) / (double)(atBats)));
		}
		sc.close();
	}
}