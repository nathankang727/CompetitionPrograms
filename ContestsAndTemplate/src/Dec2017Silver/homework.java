package Dec2017Silver;
import java.util.*;
import java.io.*;
public class homework {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] scores;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("homework.in")));
            pw = new PrintWriter(new File("homework.out"));
            init();
            pw.print(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	n = Integer.parseInt(br.readLine());
    	scores = new int[n + 1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++)
    		scores[i] = Integer.parseInt(st.nextToken());
    }
	private static String solve() {
    	int[] sortedScores = new int[n];
    	for(int i = 0; i < n; i++)
    		sortedScores[i] = scores[i + 1];
    	Arrays.sort(sortedScores);
    	String res = "";
    	int sum = 0;
    	for(int i = 1; i <= n; i++)
    		sum += scores[i];
    	int nums = n;
    	double avg = 0;
    	double max = 0;
    	ArrayList<Integer> sums = new ArrayList<Integer>();
    	sums.add(0);
    	int index = 0;
    	for(int i = 1; i <= n - 2; i++) {
    		int number = scores[i];
    		if(number == sortedScores[index])
    			++index;
    		sum -= number;
    		int min = sortedScores[index];
    		sums.add(sum - min);
    	}
    	ArrayList<Double> avgs = new ArrayList<Double>();
    	avgs.add(0.0);
    	for(int i = 1; i <= n - 2; i++) {
    		--nums;
    		avg = (double)(sums.get(i)) / (double)(nums - 1);
    		if(avg > max)
    			max = avg;
    		avgs.add(avg);
    	}
    	ArrayList<Integer> k = new ArrayList<Integer>();
    	for(int i = 1; i < avgs.size(); i++)
    		if(avgs.get(i) == max)
    			k.add(i);
    	for(int i = 0; i < k.size(); i++)
    		res += k.get(i) + "\n";
        return res;
    }
}