package Feb2021Silver;
import java.util.*;
import java.io.*;
public class YearOfTheCow {
	static int n, k, ancestors[];
	static boolean visited[];
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ancestors = new int[n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++)
			ancestors[i] = -Integer.parseInt(br.readLine());
		Arrays.sort(ancestors);
		System.out.println(Arrays.toString(ancestors));
//		System.out.println(recursion());
		br.close();
	}
//	public static int recursion() {
//		q.add(0);
//    	while(!q.isEmpty()) {
//    		int parent = q.poll();
//    		int prev = n[parent];
//    		int n1 = parent + 12;
//    		int n2 = parent - 12;
//    		int n3 = parent * 2;
//    		if(n1 >= 0 && n1 <= 100000 && n[n1] == 0 && n1 != start) {
//    			q.add(n1);
//    			n[n1] = prev + 1;
//    		}
//    		if(n2 >= 0 && n2 <= 100000 && n[n2] == 0 && n2 != start) {
//    			q.add(n2);
//    			n[n2] = prev + 1;
//    		}
//    		if(n3 >= 0 && n3 <= 100000 && n[n3] == 0 && n3 != start) {
//    			q.add(n3);
//    			n[n3] = prev + 1;
//    		}
//    		if(n1 == end || n2 == end || n3 == end)
//    			break;
//    	}
//	}
}
/*
5 3
101
85
100
46
95

36
*/