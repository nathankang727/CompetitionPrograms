package Dec2016Silver;
import java.util.*;
import java.io.*;
public class citystate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("citystate.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("citystate.out")));
		int n = Integer.parseInt(br.readLine());
		Map<String, Long> map = new HashMap<String, Long>();
		ArrayList<String> str = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken().substring(0, 2) + st.nextToken();
			if(!s.substring(0, 2).equals(s.substring(2)))
				str.add(s);
		}
		for(int i = 0; i < str.size(); i++) {
			if(!map.containsKey(str.get(i)))
				map.put(str.get(i), (long)(1));
			else
				map.put(str.get(i), map.get(str.get(i)) + 1);
		}
		long ans = 0;
		for(String city : map.keySet()) {
			String reverse = city.substring(2) + city.substring(0, 2);
			if(map.containsKey(reverse))
				ans += map.get(city) * map.get(reverse);
		}
		pw.println(ans / 2);
		br.close();
		pw.close();
	}
}