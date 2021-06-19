package Feb2020Silver;
import java.util.*;
import java.io.*;
public class clocktree {
	static HashMap<Integer, ArrayList<Integer>> edges;
	static int[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("clocktree.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("clocktree.out")));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		d = new int[100000];
		edges = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			addEdge(a, b);
			addEdge(b, a);
		}
		recursion(0, 0, -1);
		int s0 = 0, s1 = 0, n0 = 0, n1 = 0;
		for(int i = 0; i < n; i++) {
			if(d[i] % 2 == 1) {
				s1 += arr[i];
				++n1;
			}
			else {
				s0 += arr[i];
				++n0;
			}
		}
		if((s0 % 12) == (s1 % 12))
            pw.println(n);
        else if((s0 + 1) % 12 == (s1 % 12))
            pw.println(n1);
        else if((s0 % 12) == ((s1 + 1) % 12))
            pw.println(n0);
        else
            pw.println(0);
		br.close();
		pw.close();
	}
	static void addEdge(int start, int end) {
		edges.putIfAbsent(start, new ArrayList<Integer>());
		edges.get(start).add(end);
	}
	static void recursion(int I, int depth, int p) {
		d[I] = depth;
		for(int i = 0; i < edges.get(I).size(); i++) {
			if(edges.get(I).get(i) != p)
				recursion(edges.get(I).get(i), depth + 1, I);
		}
	}
}