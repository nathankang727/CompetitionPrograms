package Feb2019Bronze;
import java.util.*;
import java.io.*;
public class traffic {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("traffic.in")));
    	PrintWriter pw = new PrintWriter(new FileWriter(new File("traffic.out")));
    	int n = Integer.parseInt(br.readLine());
    	Data[] td = new Data[n];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		td[i] = new Data(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    	}
    	int low = 0;
    	int high = 1000;
    	for(int i = n - 1; i >= 0; i--) {
    		if(td[i].t.equals("on")) {
    			low = Math.max(low - td[i].u, 0);
    			high -= td[i].l;
    		}
    		else if(td[i].t.equals("off")) {
    			low += td[i].l;
    			high += td[i].u;
    		}
    		else {
    			low = Math.max(low, td[i].l);
    			high = Math.min(high, td[i].u);
    		}
    	}
    	if(low < 0)
    		low = 0;
    	pw.println(low + " " + high);
    	low = 0;
    	high = 1000;
    	for(int i = 0; i < n; i++) {
    		if(td[i].t.equals("on")) {
    			low += td[i].l;
    			high += td[i].u;
    		}
    		else if(td[i].t.equals("off")) {
    			low = Math.max(low - td[i].u, 0);
    			high -= td[i].l;
    		}
    		else {
    			low = Math.max(low, td[i].l);
    			high = Math.min(high, td[i].u);
    		}
    	}
    	if(low < 0)
    		low = 0;
    	pw.println(low + " " + high);
    	br.close();
    	pw.close();
    }
    static class Data {
    	public String t;
    	public int l, u;
    	public Data(String type, int low, int up) {
    		this.t = type;
    		this.l = low;
    		this.u = up;
    	}
    }
}