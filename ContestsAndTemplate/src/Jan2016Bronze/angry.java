package Jan2016Bronze;
import java.util.*;
import java.io.*;
public class angry {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] locations;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("angry.in")));
            pw = new PrintWriter(new File("angry.out"));
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
    	n = Integer.parseInt(br.readLine());
    	locations = new int[n];
    	for(int i = 0; i < n; i++)
    		locations[i] = Integer.parseInt(br.readLine());
    	Arrays.sort(locations);
    }
    private static String solve() {
    	int max = 1;
    	for(int i = 0; i < n; i++) {
    		int left = explosion(i, false);
    		int right = explosion(i, true);
    		int num = left - right + 1;
    		if(num > max)
    			max = num;
    	}
        return String.valueOf(max);
    }
    private static int explosion(int index, boolean goingLeft) {
    	int ans = index;
    	int range = 1;
    	while(ans > 0 && ans < n - 1) {
    		int explode = 0;
    		if(goingLeft)
    			explode = -1;
    		else
    			explode = 1;
    		int next = ans;
    		while(next + explode >= 0 && next + explode < n && Math.abs(locations[next + explode] - locations[ans]) <= range)
    			next += explode;
    		if(next == ans)
    			break;
    		ans = next;
    		++range;
    	}
    	return ans;
    }
}