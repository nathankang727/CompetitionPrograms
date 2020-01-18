package Dec2016Silver;
import java.util.*;
import java.io.*;
public class haybales {
    static BufferedReader br;
    static PrintWriter pw;
    static int n, q;
    static int[] nums;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("haybales.in")));
            pw = new PrintWriter(new File("haybales.out"));
            init();
            pw.print(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	q = Integer.parseInt(st.nextToken());
    	nums = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++)
    		nums[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(nums);
    }
    private static StringBuilder solve() throws IOException {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < q; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int index1 = Arrays.binarySearch(nums, Integer.parseInt(st.nextToken()));
    		int index2 = Arrays.binarySearch(nums, Integer.parseInt(st.nextToken()) + 1);
    		if(index1 < 0)
    			index1 = Math.abs(index1 + 1);
    		if(index2 < 0)
    			index2 = Math.abs(index2 + 1);
    		sb.append(index2 - index1).append("\n");
    	}
        return sb;
    }
}