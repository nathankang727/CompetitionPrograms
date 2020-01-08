import java.util.*;
import java.io.*;
public class speeding {
    static BufferedReader br;
    static PrintWriter pw;
    static int n, m;
    static int[] road1, road2, road3;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("speeding.in")));
            pw = new PrintWriter(new File("speeding.out"));
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
    	road1 = new int[100];
    	road2 = new int[100];
    	road3 = new int[100];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	int start = 0;
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int n1 = Integer.parseInt(st.nextToken());
    		int n2 = Integer.parseInt(st.nextToken());
    		for(int j = start; j < n1 + start; j++)
    			road1[j] = n2;
    		start += n1;
    	}
    	start = 0;
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int n1 = Integer.parseInt(st.nextToken());
    		int n2 = Integer.parseInt(st.nextToken());
    		for(int j = start; j < n1 + start; j++)
    			road2[j] = n2;
    		start += n1;
    	}
    	for(int i = 0; i < 100; i++)
    		if(road2[i] - road1[i] > 0)
    			road3[i] = road2[i] - road1[i];
    }
    private static String solve() {
    	Arrays.sort(road3);
        return String.valueOf(road3[road3.length - 1]);
    }
}