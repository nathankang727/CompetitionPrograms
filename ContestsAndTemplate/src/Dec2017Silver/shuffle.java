package Dec2017Silver;
import java.util.*;
import java.io.*;
public class shuffle {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] shuffles;
    static int[] cows;
    public static void main(String[] args) {
        try {
        	br = new BufferedReader(new FileReader(new File("shuffleSilver.in")));
        	pw = new PrintWriter(new File("shuffleSilver.out"));
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
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	shuffles = new int[n + 1];
    	cows = new int[n + 1];
    	for(int i = 1; i <= n; i++) {
    		shuffles[i] = Integer.parseInt(st.nextToken());
    		++cows[shuffles[i]];
    	}
    }
    private static String solve() {
    	int ans = n;
    	Queue<Integer> q = new LinkedList<Integer>();
    	for(int i = 1; i <= n; i++) {
    		if(cows[i] == 0) {
    			q.add(i);
    			--ans;
    		}
    	}
    	while(q.size() > 0) {
    		int empty = q.remove();
    		if(--cows[shuffles[empty]] == 0) {
    			q.add(shuffles[empty]);
    			--ans;
    		}
    	}
    	return String.valueOf(ans);
    }
}