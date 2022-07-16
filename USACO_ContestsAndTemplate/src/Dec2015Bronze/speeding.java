package Dec2015Bronze;
import java.util.*;
import java.io.*;
public class speeding {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("speeding.in")));
    	PrintWriter pw = new PrintWriter(new FileWriter(new File("speeding.out")));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int[] nRoad = new int[100];
    	int[] mRoad = new int[100];
    	int end = 0;
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int start = end;
    		end += Integer.parseInt(st.nextToken());
    		int speed = Integer.parseInt(st.nextToken());
    		for(int j = start; j < end; j++)
    			nRoad[j] = speed;
    	}
    	end = 0;
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int start = end;
    		end += Integer.parseInt(st.nextToken());
    		int speed = Integer.parseInt(st.nextToken());
    		for(int j = start; j < end; j++)
    			mRoad[j] = speed;
    	}
    	int ans = 0;
    	for(int i = 0; i < 100; i++)
    		if(mRoad[i] > nRoad[i])
    			ans = Math.max(ans, mRoad[i] - nRoad[i]);
    	pw.println(ans);
    	br.close();
    	pw.close();
    }
}