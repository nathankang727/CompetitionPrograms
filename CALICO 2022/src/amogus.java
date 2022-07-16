import java.util.*;
public class amogus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] votes = new int[n + 3];
			for(int j = 0; j < n; j++) {
				int vote = sc.nextInt();
				votes[vote]++;
			}
			if(i < t - 1) {
				sc.nextLine();
				sc.nextLine();
			}
			boolean sus = false;
			int max = 0;
			int maxCrew = 0;
			int maxCrewIndex = 0;
			int minCrew = Integer.MAX_VALUE;
			int minCrewIndex = 0;
			for(int j = 1; j <= n; j++) {
				if(votes[j] > maxCrew) {
					maxCrew = votes[j];
					maxCrewIndex = j;
				}
				if(votes[j] < minCrew) {
					minCrew = votes[j];
					minCrewIndex = j;
				}
			}
			if(Math.max(votes[n + 1], votes[n + 2]) >= maxCrew) {
				max = Math.max(votes[n + 1], votes[n + 2]);
				sus = true;
			}
			else
				max = maxCrew;
			if(sus && max > maxCrew + 2)
				System.out.println("SKIP SKIP");
			else if(sus && max > maxCrew)
				System.out.println(maxCrewIndex + " " + maxCrewIndex);
			else if(max == maxCrew && sus)
				System.out.println(maxCrewIndex + " SKIP");
			else
				System.out.println(minCrewIndex + " " + minCrewIndex);
		}
		sc.close();
	}
}