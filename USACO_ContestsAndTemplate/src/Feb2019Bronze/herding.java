package Feb2019Bronze;
import java.util.*;
import java.io.*;
public class herding {
    static BufferedReader br;
    static PrintWriter pw;
    static int[] nums;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("herding.in")));
            pw = new PrintWriter(new File("herding.out"));
            init();
            pw.println(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	nums = new int[3];
    	for(int i = 0; i < 3; i++)
    		nums[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(nums);
    }
    private static String solve() {
    	int min = 2;
    	if(nums[0] + 1 == nums[1] && nums[1] + 1 == nums[2])
    		min = 0;
    	else if(nums[0] + 2 == nums[1] || nums[1] + 2 == nums[2])
    		min = 1;
    	int max = Math.max(nums[1] - nums[0], nums[2] - nums[1]) - 1;
        return min + "\n" + max;
    }
}