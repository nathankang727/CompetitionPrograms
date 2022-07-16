import java.util.*;
public class HaveYouSeenMyKey {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int x = Integer.parseInt(sc.nextLine());
			String ct = sc.nextLine();
			for(int j = 0; j < x; j++) {
				String key = sc.nextLine();
				String ans = "";
				for(int k = 0; k < key.length(); k += 2) {
					String bi1 = Integer.toString(Integer.parseInt(ct.substring(k, k + 2), 16), 2);
					String bi2 = Integer.toString(Integer.parseInt(key.substring(k, k + 2), 16), 2);
					bi1 = pad(bi1);
					bi2 = pad(bi2);
					String xor = "";
					for(int l = 0; l < bi1.length(); l++) {
						if(bi1.charAt(l) == bi2.charAt(l))
							xor += "0";
						else
							xor += "1";
					}
					ans += (char)(Integer.parseInt(xor, 2));
				}
				System.out.println("[" + ans + "]");
			}
		}
		sc.close();
	}
	public static String pad(String n) {
		for(int i = 8 - n.length(); i > 0; i--)
			n = "0" + n;
		return n;
	}
}