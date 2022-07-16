import java.util.*;
public class CaesarWithAShift {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String msg = sc.nextLine();
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String ans = "";
			int index = 0;
			ArrayList<Integer> shift = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			while(st.hasMoreTokens())
				shift.add(Integer.parseInt(st.nextToken()));
			ArrayList<Integer> dir = new ArrayList<Integer>();
			st = new StringTokenizer(sc.nextLine());
			while(st.hasMoreTokens())
				dir.add(Integer.parseInt(st.nextToken()));
			for(int j = 0; j < msg.length(); j++) {
				if(!alphabet.contains(msg.substring(j, j + 1).toLowerCase()))
					ans += msg.substring(j, j + 1);
				else {
					int s = shift.get(index % shift.size());
					int d = dir.get(index % dir.size());
					if(d == 0) {
						int ind = (alphabet.indexOf(msg.substring(j, j + 1).toLowerCase()) + s) % 26;
						ans += alphabet.charAt(ind) + "";
					}
					else {
						int ind = (alphabet.indexOf(msg.substring(j, j + 1).toLowerCase()) - s + 26) % 26;
						ans += alphabet.charAt(ind) + "";
					}
					++index;
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}