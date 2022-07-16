package US_Open2019Silver;
import java.util.*;
import java.io.*;
public class fenceplan {
	static boolean v[];
    static ArrayList<Integer>[] a;
    static int n, m, coordinates[][];
    static int minX, maxX, minY, maxY, perimeter;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("fenceplan.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("fenceplan.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = new boolean[n];
		coordinates = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coordinates[i][0] = Integer.parseInt(st.nextToken());
			coordinates[i][1] = Integer.parseInt(st.nextToken());
		}
		a = new ArrayList[n];
        for(int i = 0; i < n; i++)    
            a[i] = new ArrayList<Integer>();        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            a[x].add(y);
            a[y].add(x);
        }
        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        minY = Integer.MAX_VALUE;
        maxY = Integer.MIN_VALUE;
        perimeter = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
        	if(!v[i]) {
        		dfs(i);
        		perimeter = Math.min(perimeter, (maxX - minX) * 2 + (maxY - minY) * 2);
        		minX = Integer.MAX_VALUE;
                maxX = Integer.MIN_VALUE;
                minY = Integer.MAX_VALUE;
                maxY = Integer.MIN_VALUE;
        	}
        }
        pw.println(perimeter);
		br.close();
		pw.close();
	}
	static void dfs(int s) {
        v[s] = true;
        minX = Math.min(minX, coordinates[s][0]);
    	maxX = Math.max(maxX, coordinates[s][0]);
    	minY = Math.min(minY, coordinates[s][1]);
    	maxY = Math.max(maxY, coordinates[s][1]);
        for(int i : a[s]) {
            if(!v[i]) {
            	minX = Math.min(minX, coordinates[i][0]);
            	maxX = Math.max(maxX, coordinates[i][0]);
            	minY = Math.min(minY, coordinates[i][1]);
            	maxY = Math.max(maxY, coordinates[i][1]);
                dfs(i);
            }
        }
    }
}