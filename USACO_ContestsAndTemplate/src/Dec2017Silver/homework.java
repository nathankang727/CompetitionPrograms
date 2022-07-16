package Dec2017Silver;
import java.util.*;
import java.io.*;
public class homework {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("homework.in")));
    	PrintWriter pw = new PrintWriter(new FileWriter(new File("homework.out")));
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] scores = new int[n];
    	for(int i = 0; i < n; i++)
    		scores[i] = Integer.parseInt(st.nextToken());
    	int[] sum = new int[n];
    	for(int i = n - 1; i >= 0; i--) {
    		if(i == n - 1)
    			sum[i] = scores[i];
    		else
    			sum[i] = sum[i + 1] + scores[i];
    	}
    	int[] min = new int[n];
    	for(int i = n - 1; i >= 0; i--) {
    		if(i == n - 1)
    			min[i] = scores[i];
    		else if(min[i + 1] > scores[i])
    			min[i] = scores[i];
    		else
    			min[i] = min[i + 1];
    	}
    	double max = 0;
    	for(int i = 1; i <= n - 2; i++) {
    		double formula = (double)(sum[i] - min[i]) / (double)(n - i - 1);
    		if(formula > max)
    			max = formula;
    	}
    	for(int i = 1; i <= n - 2; i++) {
    		double formula = (double)(sum[i] - min[i]) / (double)(n - i - 1);
    		if(formula == max)
    			pw.println(i);
    	}
    	br.close();
    	pw.close();
    }
}