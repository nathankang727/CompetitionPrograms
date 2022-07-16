import java.util.*;
public class ConwaysGameOfLife {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int x = Integer.parseInt(sc.nextLine());
			int[][] arr = new int[12][12];
			for(int j = 1; j <= 10; j++) {
				String input = sc.nextLine();
				for(int k = 1; k <= 10; k++)
					arr[j][k] = Integer.parseInt(input.substring(k - 1, k));
			}
			for(int j = 0; j < x; j++) {
				int[][] copy = new int[12][12];
				for(int k = 0; k < 12; k++)
					for(int l = 0; l < 12; l++)
						copy[k][l] = arr[k][l];
				for(int k = 1; k <= 10; k++) {
					for(int l = 1; l <= 10; l++) {
						if(copy[k][l] == 0) {
							if(cntCells(copy, k, l) == 3)
								arr[k][l] = 1;
						}
						else {
							int cnt = cntCells(copy, k, l);
							if(cnt == 0 || cnt == 1 || cnt >= 4)
								arr[k][l] = 0;
						}
					}
				}
			}
			for(int j = 1; j <= 10; j++) {
				String ans = "";
				for(int k = 1; k <= 10; k++)
					ans += arr[j][k];
				System.out.println(ans);
			}
		}
		sc.close();
	}
	public static int cntCells(int[][] arr, int x, int y) {
		int cnt = 0;
		if(arr[x + 1][y] == 1)
			++cnt;
		if(arr[x - 1][y] == 1)
			++cnt;
		if(arr[x][y + 1] == 1)
			++cnt;
		if(arr[x][y - 1] == 1)
			++cnt;
		if(arr[x + 1][y + 1] == 1)
			++cnt;
		if(arr[x + 1][y - 1] == 1)
			++cnt;
		if(arr[x - 1][y + 1] == 1)
			++cnt;
		if(arr[x - 1][y - 1] == 1)
			++cnt;
		return cnt;
	}
}