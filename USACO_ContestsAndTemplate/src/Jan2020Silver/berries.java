package Jan2020Silver;
import java.util.*;
import java.io.*;
public class berries {
	static int mod;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("berries.in")));
    	PrintWriter pw = new PrintWriter(new FileWriter(new File("berries.out")));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] nums = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++)
    		nums[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(nums);
    	int max = nums[n - 1];
    	int res = 0;
    	for(int i = 1; i <= max; i++) {
    		int temp = 0;
    		for(int j = 0; j < n; j++)
    			temp += nums[j] / i;
    		if(temp < k / 2)
    			break;
    		else if(temp >= k) {
    			res = Math.max(res, k / 2 * i);
    			continue;
    		}
    		mod = i;
    		Sorting[] nums2 = new Sorting[n];
    		for(int j = 0; j < n; j++)
    			nums2[j] = new Sorting(nums[j]);
    		Arrays.sort(nums2);
    		for(int j = 0; j < n; j++)
    			nums[j] = nums2[j].number;
    		int current = i * (temp - k / 2);
    		for(int j = 0; j < n && j + temp < k; j++)
    			current += nums[j] % i;
    		res = Math.max(res, current);
    	}
    	pw.println(res);
    	br.close();
    	pw.close();
    }
    static class Sorting implements Comparable<Sorting> {
    	public int number;
    	public int compareTo(Sorting s) {
    		return s.number % mod - this.number % mod;
    	}
    	public Sorting(int nu) {
    		this.number = nu;
    	}
    }
}