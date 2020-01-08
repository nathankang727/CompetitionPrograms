package Jan2019Silver;
import java.util.*;
import java.io.*;
public class planting {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] paths;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("planting.in")));
            pw = new PrintWriter(new File("planting.out"));
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
    	paths = new int[(n - 1) * 2];
    	for(int i = 0; i < paths.length; i += 2) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
    		paths[i] = Integer.parseInt(st.nextToken());
    		paths[i + 1] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(paths);
    }
    private static String solve() {
    	int ans = 0;
    	int count = 1;
    	int num = 0;
    	for(int i = 0; i < paths.length; i++) {
    		if(num != paths[i]) {
    			if(ans < count)
    				ans = count;
    			count = 1;
    			num = paths[i];
    		}
    		else
    			++count;
    	}
        return String.valueOf(ans + 1);
    }
}