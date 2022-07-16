import java.util.*;
public class CentauriPrime {
	private static String getRuler(String kingdom) {
		String ruler = "";
		String vowels = "AEIOUaeiou";
		int lastIndex = kingdom.length() - 1;
		if(kingdom.charAt(lastIndex) == 'Y' || kingdom.charAt(lastIndex) == 'y')
			ruler = "nobody";
		else if(vowels.indexOf(kingdom.charAt(lastIndex)) >= 0)
			ruler = "Alice";
		else
			ruler = "Bob";
		return ruler;
	}
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int T = in.nextInt();
			for(int t = 1; t <= T; ++t) {
				String kingdom = in.next();
				System.out.println("Case #" + t + ": " + kingdom + " is ruled by " + getRuler(kingdom) + ".");
			}
		}
	}
}