import java.util.*;
import java.io.*;
public class wormsort {
	static int[] indexes, component;
	static ArrayList<Edges>[] edge;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		indexes = new int[n];
		component = new int[n];
		edge = new ArrayList[n];
		for(int i = 0; i < n; i++)
			edge[i] = new ArrayList<>();
		for(int i = 0; i < n; i++)
			indexes[i] = Integer.parseInt(st.nextToken()) - 1;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			edge[a].add(new Edges(b, w));
			edge[b].add(new Edges(a, w));
		}
		int minW = 0;
		int maxW = 1000000001;
		while(minW < maxW) {
			int middle = (minW + maxW + 1) / 2;
			if(works(middle))
				minW = middle;
			else
				maxW = middle - 1;
		}
		System.out.println(minW <= 1000000000 ? minW : "-1");
		br.close();
	}
	public static void recursion(int current, int temp, int minW) {
		if(component[current] == temp)
			return;
		component[current] = temp;
		for(int i = 0; i < edge[current].size(); i++)
			if(edge[current].get(i).getB() >= minW)
				recursion(edge[current].get(i).getA(), temp, minW);
	}
	public static boolean works(int num) {
		for(int i = 0; i < component.length; i++)
			component[i] = -1;
		int temp = 0;
		for(int i = 0; i < component.length; i++)
			if(component[i] < 0)
				recursion(i, temp++, num);
		for(int i = 0; i < indexes.length; i++)
			if(component[i] != component[indexes[i]])
				return false;
		return true;
	}
	static class Edges {
		private int a, b;
		public Edges(int aa, int bb) {
			this.a = aa;
			this.b = bb;
		}
		public int getA() {
			return a;
		}
		public int getB() {
			return b;
		}
	}
}