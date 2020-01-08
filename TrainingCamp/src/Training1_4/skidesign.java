package Training1_4;
/*
ID: nathank3
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.Arrays;
public class skidesign {
    static BufferedReader in;
    static PrintWriter out;
    static int[] hills;
    static int[][] possibles;
    public static void main(String[] args) {
        try {
            in = new BufferedReader(new FileReader(new File("skidesign.in")));
            out = new PrintWriter(new File("skidesign.out"));
            init();
            out.println(solve());
            out.close();
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	int n = Integer.parseInt(in.readLine());
    	hills = new int[n];
    	possibles = new int[84][2];
    	for(int i = 0; i <= 83; i++) {
    		possibles[i][0] = i;
    		possibles[i][1] = i + 17;
    	}
    	for(int i = 0; i < n; i++)
    		hills[i] = Integer.parseInt(in.readLine());
    }
    private static String solve() {
    	int[] totals = new int[84];
    	for(int i = 0; i < 84; i++) {
    		for(int j = 0; j < hills.length; j++) {
    			int start = possibles[i][0];
    			int end = possibles[i][1];
    			totals[i] += price(start, end, hills[j]);
    		}
    	}
    	Arrays.sort(totals);
    	return String.valueOf(totals[0]);
    }
    private static int price(int start, int end, int hill) {
    	if(hill >= start && hill <= end)
    		return 0;
    	else if(hill < start)
    		return (start - hill) * (start - hill);
    	else
    		return (hill - end) * (hill - end);
     }
} 