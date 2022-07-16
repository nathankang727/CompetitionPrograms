package Dec2019Silver;
import java.util.*;
import java.io.*;
public class milkvisits {
	static int temp;
	static int[] components;
	static char[] cowsOnRoad;
	static ArrayList<Integer>[] edges;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("milkvisits.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("milkvisits.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String cowTypes = br.readLine();
		cowsOnRoad = new char[n + 1];
		components = new int[n + 1];
		for(int i = 1; i < n + 1; i++)
			cowsOnRoad[i] = cowTypes.charAt(i - 1);
		edges = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i++)
			edges[i] = new ArrayList<Integer>();
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			edges[n1].add(n2);
			edges[n2].add(n1);
		}
		for(int i = 1; i < n + 1; i++) {
			if(components[i] == 0) {
				++temp;
				method(i);
			}
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			pw.print(cowsOnRoad[n1] == c || components[n1] != components[n2] ? "1" : "0");
		}
		pw.println();
		br.close();
		pw.close();
	}
	public static void method(int n) {
		if(components[n] != 0)
			return;
		components[n] = temp;
		for(int i : edges[n])
			if(cowsOnRoad[i] == cowsOnRoad[n])
				method(i);
	}
}