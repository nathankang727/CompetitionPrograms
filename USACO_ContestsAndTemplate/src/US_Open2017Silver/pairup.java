package US_Open2017Silver;
import java.util.*;
import java.io.*;
public class pairup {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("pairup.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("pairup.out")));
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map.put(y, x);
		}
		int ans = 0;
		while(!map.isEmpty()) {
			int a = map.firstKey();
			int b = map.lastKey();
			int subtract = Math.min(map.get(a), map.get(b));
			map.put(a, map.get(a) - subtract);
			map.put(b, map.get(b) - subtract);
			ans = Math.max(ans, a + b);
			if(map.get(a) <= 0)
				map.remove(a);
			if(map.size() == 0)
				break;
			if(map.get(b) <= 0)
				map.remove(b);
		}
		pw.println(ans);
		br.close();
		pw.close();
	}
}