package Dec2018Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: mixmilk
*/
import java.util.*;
import java.io.*;
public class mixmilk {
	static BufferedReader br;
    static PrintWriter pw;
    static int[] size = new int[3];
    static int[] milk = new int[3];
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("mixmilk.in")));
            pw = new PrintWriter(new File("mixmilk.out"));
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
    	for(int i = 0; i < 3; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		size[i] = Integer.parseInt(st.nextToken());
    		milk[i] = Integer.parseInt(st.nextToken());
    	}
    }
    private static String solve() {
        String s = "";
        for(int i = 0; i < 100; i++) {
        	int index = i % 3;
        	int index2 = (i + 1) % 3;
        	milk[index2] += milk[index];
        	milk[index] = 0;
        	if(milk[index2] > size[index2]) {
        		milk[index] = milk[index2] - size[index2];
        		milk[index2] = size[index2];
        	}
        }
        for(int i = 0; i < 2; i++)
        	s += milk[i] + "\n";
        s += milk[2];
        return s;
    }
}