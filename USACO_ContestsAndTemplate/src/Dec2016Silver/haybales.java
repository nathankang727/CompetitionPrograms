package Dec2016Silver;
import java.util.*;
import java.io.*;
public class haybales {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("haybales.in")));
    	PrintWriter pw = new PrintWriter(new PrintWriter(new File("haybales.out")));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int q = Integer.parseInt(st.nextToken());
    	int[] nums = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++)
    		nums[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(nums);
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < q; i++) {
    		st = new StringTokenizer(br.readLine());
    		int s = Arrays.binarySearch(nums, Integer.parseInt(st.nextToken()));
    		int e = Arrays.binarySearch(nums, Integer.parseInt(st.nextToken()));
    		if(s < 0)
    			s = -s - 1;
    		if(e < 0)
    			e = -e - 1;
    		else if(e >= 0)
    			++e;
    		sb.append(e - s).append("\n");
    	}
    	pw.print(sb);
    	br.close();
    	pw.close();
    }
}