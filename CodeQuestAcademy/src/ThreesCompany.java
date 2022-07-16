import java.util.*;
public class ThreesCompany {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		for(int z = 0; z < testCases; z++) {
			int t = sc.nextInt();
			int i = sc.nextInt();
			sc.nextLine();
			char[][] triples = new char[t][3];
			for(int j = 0; j < t; j++) {
				for(int k = 0; k < 3; k++) {
					String input = sc.next();
					if(input.charAt(0) == '!')
						input = input.substring(1).toLowerCase();
					triples[j][k] = input.charAt(0);
				}
			}
			for(int j = 0; j < i; j++) {
				boolean[] b = new boolean[3 * t];
				for(int k = 0; k < 3 * t; k++)
					b[k] = sc.nextInt() == 1;
				boolean didBreak = false;
				for(int k = 0; k < t; k++) {
					boolean works = false;
					for(int l = 0; l < 3; l++) {
						if(triples[k][l] >= 'a') {
							if(!b[triples[k][l] - 'a']) {
								works = true;
								break;
							}
						}
						else {
							if(b[triples[k][l] - 'A']) {
								works = true;
								break;
							}
						}
					}
					if(!works) {
						didBreak = true;
						break;
					}
				}
				System.out.println(String.valueOf(!didBreak).toUpperCase());
			}
		}
		sc.close();
	}
}