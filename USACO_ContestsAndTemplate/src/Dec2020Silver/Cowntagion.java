package Dec2020Silver;
import java.util.*;
import java.io.*;
public class Cowntagion {
	static boolean v[];
	static ArrayList<Integer>[] storage;
	static int n, result;
    static Queue<Integer> queue;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		queue = new LinkedList<Integer>();
		queue.add(0);
		v = new boolean[n];
		v[0] = true;
		storage = new ArrayList[n];
		for(int i = 0; i < n; i++)
			storage[i] = new ArrayList<Integer>();
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			storage[a].add(b);
			storage[b].add(a);
		}
		result = n - 1;
		bfs();
		System.out.println(result);
		br.close();
	}
	public static void bfs() {
		while(queue.size() > 0) {
            int m = queue.poll();
            int spread = 1;
            for(int i : storage[m]) {
                if(!v[i]) {
                    queue.add(i);
                    ++spread;
                    v[i] = true;
                }
            }
            for(int i = 0; i <= 17; i++) {
    			if((int)(Math.pow(2, i)) >= spread) {
    				result += i;
    				break;
    			}
    		}
        }
	}
}