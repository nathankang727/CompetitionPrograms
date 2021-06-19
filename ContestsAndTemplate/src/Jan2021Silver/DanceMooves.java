package Jan2021Silver;
import java.util.*;
import java.io.*;
public class DanceMooves {
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList[] data = new ArrayList[n];
		int[] cow = new int[n];
		int[][] d = new int[k][2];
		for(int i = 0; i < n; i++) {
			data[i] = new ArrayList<Integer>();
			data[i].add(i);
			cow[i] = i;
		}
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			d[i][0] = Integer.parseInt(st.nextToken()) - 1;
			d[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}
		for(int i = 0; i < k; i++) {
			data[cow[d[i][0]]].add(d[i][1]);
			data[cow[d[i][1]]].add(d[i][0]);
			int swap = cow[d[i][0]];
			cow[d[i][0]] = cow[d[i][1]];
			cow[d[i][1]] = swap;
		}
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			ArrayList<Integer> cycles = new ArrayList<Integer>();
			int num = i;
			while(cow[num] >= 0) {
				cycles.add(num);
				int temp = num;
				num = cow[num];
				cow[temp] = -1;
			}
			Set<Integer> set = new HashSet<Integer>();
			for(int j = 0; j < cycles.size(); j++)
				set.addAll(data[cycles.get(j)]);
			for(int j = 0; j < cycles.size(); j++)
				arr[cycles.get(j)] = set.size();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]);
		for(int i = 1; i < n; i++)
			sb.append("\n" + arr[i]);
		System.out.println(sb);
		br.close();
	}
}