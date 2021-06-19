package Dec2017Bronze;
import java.util.*;
import java.io.*;
public class shuffle {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("shuffle.in")));
    	PrintWriter pw = new PrintWriter(new FileWriter(new File("shuffle.out")));
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	ArrayList<Integer> swap = new ArrayList<Integer>();
    	swap.add(0);
    	for(int i = 1; i <= n; i++)
    		swap.add(Integer.parseInt(st.nextToken()));
    	int[] ids = new int[n + 1];
    	int[] ans = new int[n + 1];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++)
    		ids[i] = Integer.parseInt(st.nextToken());
    	for(int i = 1; i <= n; i++) {
    		int prev = i;
    		int index = prev;
    		for(int j = 0; j < 3; j++) {
    			index = swap.indexOf(prev);
    			prev = index;
    		}
    		ans[index] = ids[i];
    	}
    	for(int i = 1; i <= n; i++)
    		pw.println(ans[i]);
    	br.close();
    	pw.close();
    }
}