package US_Open2018Silver;
import java.util.*;
import java.io.*;
public class lemonade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("lemonade.in")));
        PrintWriter pw = new PrintWriter(new File("lemonade.out"));
        int n = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] w = new int[n];
    	int[] w1 = new int[n];
    	for(int i = 0; i < n; i++)
    		w1[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(w1);
    	for(int i = n - 1, j = 0; i > -1; i--) {
    		w[j] = w1[i];
    		++j;
    	}
        int count = 0;
    	for(int i = 0; i < n; i++)
    		if(count <= w[i])
    			++count;
        pw.println(count);
        br.close();
        pw.close();
    }
}