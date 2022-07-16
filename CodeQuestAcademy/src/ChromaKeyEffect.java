import java.util.*;
public class ChromaKeyEffect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int cr = sc.nextInt();
			int cg = sc.nextInt();
			int cb = sc.nextInt();
			int tolerance = sc.nextInt();
			int fr = sc.nextInt();
			int fg = sc.nextInt();
			int fb = sc.nextInt();
			int br = sc.nextInt();
			int bg = sc.nextInt();
			int bb = sc.nextInt();
			double dist = Math.sqrt((Math.pow(cr - fr, 2.0)) + (Math.pow(cg - fg, 2.0)) + (Math.pow(cb - fb, 2.0)));
			if(dist <= tolerance)
				System.out.println(br + " " + bg + " " + bb);
			else
				System.out.println(fr + " " + fg + " " + fb);
		}
		sc.close();
	}
}