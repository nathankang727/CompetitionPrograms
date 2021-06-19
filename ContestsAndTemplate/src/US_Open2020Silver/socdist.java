package US_Open2020Silver;
import java.util.*;
import java.io.*;
public class socdist {
	static int n;
	static int m;
	static Ranges[] arr;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("socdist.in")));
    	PrintWriter pw = new PrintWriter(new FileWriter(new File("socdist.out")));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	arr = new Ranges[m];
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		arr[i] = new Ranges(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
    	}
    	Arrays.sort(arr);
    	long low = 0;
    	long mid = 500000000;
    	long high = (long)(1000000000) * (long)(1000000000);
    	long ans = -1;
    	while(low <= high) {
    		if(check(mid)) {
    			ans = mid;
    			low = mid + 1;
    		}
    		else
    			high = mid - 1;
    		mid = (low + high) / 2;
    	}
    	pw.println(ans);
    	br.close();
    	pw.close();
    }
    public static boolean check(long distance) {
    	long prev = -Long.MAX_VALUE;
    	int count = 0;
    	for(int i = 0; i < arr.length; i++) {
    		while(Math.max(prev + distance, arr[i].getLow()) <= arr[i].getHigh()) {
    			prev = Math.max(prev + distance, arr[i].getLow());
    			++count;
    			if(count >= n)
    				return true;
    		}
    	}
    	return false;
    }
}
class Ranges implements Comparable<Ranges> { 
    private long l;
    private long h;
    public int compareTo(Ranges r) {
        return (int)(this.l - r.l);
    }
    public Ranges(long low, long high) {
        this.l = low;
        this.h = high;
    }
    public long getLow() {
    	return l;
    }
    public long getHigh() {
    	return h;
    }
}