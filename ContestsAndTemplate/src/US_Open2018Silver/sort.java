package US_Open2018Silver;
import java.util.*;
import java.io.*;
public class sort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("sort.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("sort.out")));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		int[] nums2 = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			nums2[i] = nums[i];
		}
		Arrays.sort(nums2);
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int temp = Arrays.binarySearch(nums2, nums[i]);
			while(temp <= n - 2) {
				if(nums2[temp + 1] == nums2[temp])
					++temp;
				else
					break;
			}
			answer = Math.max(answer, i - temp);
		}
		pw.println(answer + 1);
		br.close();
		pw.close();
	}
}