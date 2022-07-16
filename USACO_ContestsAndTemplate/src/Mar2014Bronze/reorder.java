package Mar2014Bronze;
import java.io.*;
import java.util.*;
public class reorder {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] a;
    static int[] b;
    static int[] correctIndexes;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("reorder.in")));
            pw = new PrintWriter(new File("reorder.out"));
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
    	a = new int[n + 1];
    	b = new int[n + 1];
    	correctIndexes = new int[n + 1];
    	for(int i = 1; i <= n; i++)
    		a[i] = Integer.parseInt(br.readLine());
    	for(int i = 1; i <= n; i++)
    		b[i] = Integer.parseInt(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		int num1 = a[i];
    		for(int j = 1; j <= n; j++) {
    			if(num1 == b[j]) {
    				correctIndexes[num1] = j;
    				break;
    			}
    		}
    	}
    }
    private static String solve() {
    	int count = 0;
    	int max = 0;
    	while(!Arrays.toString(a).equals(Arrays.toString(b))) {
    		int maxCount = 0;
    		int hold = 0;
    		boolean firstTime = true;
    		while(hold != 0 || firstTime) {
    			int temp = 0;
    			int cIndex = 0;
    			if(firstTime) {
    				firstTime = false;
    				for(int i = 1; i <= n; i++) {
    					if(a[i] != b[i]) {
    						temp = a[i];
    						a[i] = 0;
    						break;
    					}
    				}
    			}
    			else
    				temp = hold;
    			cIndex = correctIndexes[temp];
    			hold = a[cIndex];
    			a[cIndex] = temp;
    			++maxCount;
    		}
    		++count;
    		if(maxCount > max)
    			max = maxCount;
    	}
    	if(count == 0)
    		max = -1;
        return count + " " + max;
    }
}
