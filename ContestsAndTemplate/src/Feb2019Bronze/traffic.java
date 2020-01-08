package Feb2019Bronze;
import java.util.*;
import java.io.*;
public class traffic {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static Highway[] highway;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("traffic.in")));
            pw = new PrintWriter(new File("traffic.out"));
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
    	highway = new Highway[n];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		highway[i] = new Highway(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    	}
    }
    private static String solve() {
    	String res = "";
    	int start = 0;
    	int end = 1000000;
    	for(int i = n - 1; i >= 0; i--) {
    		if(highway[i].getRamp().equals("none")) {
    			start = Math.max(start, highway[i].getStart());
    			end = Math.min(end, highway[i].getEnd());
    		}
    		else if(highway[i].getRamp().equals("on")) {
    			start -= highway[i].getEnd();
    			end -= highway[i].getStart();
    			if(start < 0)
    	    		start = 0;
    		}
    		else {
    			start += highway[i].getStart();
    			end += highway[i].getEnd();
    		}
    	}
    	res += start + " " + end + "\n";
    	start = 0;
    	end = 1000000;
    	for(int i = 0; i < n; i++) {
    		if(highway[i].getRamp().equals("none")) {
    			start = Math.max(start, highway[i].getStart());
    			end = Math.min(end, highway[i].getEnd());
    		}
    		else if(highway[i].getRamp().equals("off")) {
    			start -= highway[i].getEnd();
    			end -= highway[i].getStart();
    			if(start < 0)
    	    		start = 0;
    		}
    		else {
    			start += highway[i].getStart();
    			end += highway[i].getEnd();
    		}
    	}
    	res += start + " " + end;
    	return res;
    }
}
class Highway {
	String whatRamp;
	int start;
	int end;
	Highway(String r, int s, int e) {
		whatRamp = r;
		start = s;
		end = e;
	}
	public String getRamp() {
		return whatRamp;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
}