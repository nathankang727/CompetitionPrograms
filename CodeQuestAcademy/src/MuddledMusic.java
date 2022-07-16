import java.util.*;
public class MuddledMusic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			Songs[] s = new Songs[n];
			for(int j = 0; j < n; j++) {
				String[] input = sc.nextLine().split(" - ");
				s[j] = new Songs(input[0], input[1]);
			}
			Arrays.sort(s);
			for(int j = 0; j < n; j++)
				System.out.println(s[j].name + " - " + s[j].artist);
		}
		sc.close();
	}
	static class Songs implements Comparable<Songs> {
		public String name, artist;
		public int compareTo(Songs s) {
			if(this.artist.equals(s.artist))
				return this.name.compareTo(s.name);
			String artist1 = this.artist.toLowerCase();
			String artist2 = s.artist.toLowerCase();
			if(artist1.length() > 3 && artist1.substring(0, 4).equals("the "))
				artist1 = artist1.substring(4);
			if(artist2.length() > 3 && artist2.substring(0, 4).equals("the "))
				artist2 = artist2.substring(4);
			return artist1.compareTo(artist2);
		}
		public Songs(String n, String a) {
			this.name = n;
			this.artist = a;
		}
	}
}