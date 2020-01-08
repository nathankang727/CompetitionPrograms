package Dec2018Bronze;
/*
ID: nathank3
LANG: JAVA
TASK:
*/
import java.util.*;
import java.io.*;
public class backforth {
    static BufferedReader br;
    static PrintWriter pw;
    static Set<Integer> set;
    static ArrayList<Integer> sideA;
    static ArrayList<Integer> sideB;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("backforth.in")));
            pw = new PrintWriter(new File("backforth.out"));
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
    	sideA = new ArrayList<Integer>();
    	sideB = new ArrayList<Integer>();
    	set = new HashSet<Integer>();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < 10; i++)
    		sideA.add(Integer.parseInt(st.nextToken()));
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < 10; i++)
    		sideB.add(Integer.parseInt(st.nextToken()));
    }
    private static String solve() {
    	int[] A = new int[10];
    	int[] B = new int[10];
    	for(int i = 0; i < 10; i++) {
    		A[i] = sideA.get(i);
    		B[i] = sideB.get(i);
    	}
    	for(int i = 0; i < 10; i++) {
    		for(int j = 0; j < 11; j++) {
    			for(int k = 0; k < 10; k++) {
    				for(int l = 0; l < 11; l++) {
    					int n = calculate(i, j, k, l);
    					set.add(n);
    					sideA.clear();
    					sideB.clear();
    					for(int m = 0; m < 10; m++) {
    						sideA.add(A[m]);
    						sideB.add(B[m]);
    					}
    				}
    			}
    		}
    	}
        return String.valueOf(set.size());
    }
    private static int calculate(int tues, int wed, int thurs, int fri) {
    	int a = 1000;
    	a -= sideA.get(tues);
    	sideB.add(sideA.remove(tues));
    	a += sideB.get(wed);
    	sideA.add(sideB.remove(wed));
    	a -= sideA.get(thurs);
    	sideB.add(sideA.remove(thurs));
    	a += sideB.get(fri);
    	sideA.add(sideB.remove(fri));
    	return a;
    }
}