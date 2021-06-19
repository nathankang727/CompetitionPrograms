package US_Open2021Silver;
import java.util.*;
import java.io.*;
public class DoYouKnowYourABCs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				nums[j] = Integer.parseInt(st.nextToken());
			Arrays.sort(nums);
			Set<int[]> ans = new HashSet<int[]>();
			if(n == 7) {
				if(nums[0] + nums[1] == nums[3] && nums[0] + nums[2] == nums[4] && nums[1] + nums[2] == nums[5] &&
						nums[0] + nums[1] + nums[2] == nums[6]) {
					int[] temp = {nums[0], nums[1], nums[2]};
					ans.add(temp);
				}
				if(nums[0] + nums[1] == nums[2] && nums[0] + nums[3] == nums[4] && nums[1] + nums[3] == nums[5] && 
						nums[0] + nums[1] + nums[3] == nums[6]) {
					int[] temp = {nums[0], nums[1], nums[3]};
					ans.add(temp);
				}
			}
			else if(n == 6) {
				
			}
			else if(n == 5) {
				
			}
			else {
				
			}
			System.out.println(ans);
		}
		br.close();
	}
}
/*
10
7
1 2 3 4 5 6 7
4
4 5 7 8
4
4 5 7 9
4
4 5 7 10
4
4 5 7 11
4
4 5 7 12
4
4 5 7 13
4
4 5 7 14
4
4 5 7 15
4
4 5 7 16
*/