import java.util.*;
import java.io.*;
public class shuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int[] shuffles = new int[n + 1];
	    int[] cows = new int[n + 1];
	    for(int i = 1; i <= n; i++) {
	     	shuffles[i] = Integer.parseInt(st.nextToken());
	       	++cows[shuffles[i]];
	    }
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
	    System.out.println(ans);
	    br.close();
	}
}