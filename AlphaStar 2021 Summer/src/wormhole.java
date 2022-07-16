import java.util.*;
import java.io.*;
public class wormhole {
	static int n, p[], next[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] x = new int[n + 1];
		int[] y = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		p = new int[n + 1];
		next = new int[n + 1];
		for(int i = 1; i <= n; i++)
    		for(int j = 1; j <= n; j++)
    			if(x[j] > x[i] && y[i] == y[j])
    				if(next[i] == 0 || x[j] - x[i] < x[next[i]] - x[i])
    					next[i] = j;
		System.out.println(recursion());
		br.close();
	}
	public static int recursion() {
		int cnt = 0;
		int index = 1;
    	for(int i = 1; i <= n; i++) {
        	if(p[i] == 0)
        		break;
        	++index;
    	}
        if(index > n) {
        	if(isCycle())
        		return 1;
        	else
        		return 0;
        }
        for(int j = index + 1; j <= n; j++) {
        	if(p[j] == 0) {
        		p[index] = j;
        		p[j] = index;
        		cnt += recursion();
        		p[index] = 0;
        		p[j] = 0;
        	}
        }
    	return cnt;
	}
	public static boolean isCycle() {
    	for(int i = 1; i <= n; i++) {
    		int pos = i;
    		for(int j = 1; j <= n; j++)
    			pos = next[p[pos]];
    		if(pos != 0)
    			return true;
    	}
    	return false;
    }
}