package Jan2019Bronze;
import java.util.*;
import java.io.*;
public class shell {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("shell.in")));
    	PrintWriter pw = new PrintWriter(new FileWriter(new File("shell.out")));
    	int n = Integer.parseInt(br.readLine());
    	int[][] swap = new int[n][2];
    	int[] guess = new int[n];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		swap[i][0] = Integer.parseInt(st.nextToken());
    		swap[i][1] = Integer.parseInt(st.nextToken());
    		guess[i] = Integer.parseInt(st.nextToken());
    	}
    	int max = 0;
    	for(int i = 1; i <= 3; i++) {
    		int cnt = 0;
    		boolean[] b = new boolean[4];
    		b[i] = true;
    		for(int j = 0; j < n; j++) {
    			if(b[swap[j][0]] || b[swap[j][1]]) {
    				b[swap[j][0]] = !b[swap[j][0]];
    				b[swap[j][1]] = !b[swap[j][1]];
    			}
    			if(b[guess[j]])
    				++cnt;
    		}
    		if(max < cnt)
    			max = cnt;
    	}
    	pw.println(max);
    	br.close();
    	pw.close();
    }
}