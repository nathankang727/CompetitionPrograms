import java.util.*;
import java.io.*;
public class blink {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		ArrayList<Boolean> bulbs = new ArrayList<Boolean>();
		for(int i = 0; i < n; i++)
			bulbs.add(Integer.parseInt(br.readLine()) == 1);
		Map<ArrayList<Boolean>, Long> map = new HashMap<ArrayList<Boolean>, Long>();
		map.put(bulbs, (long)(0));
		long index = 0;
		while(index < b) {
			++index;
			ArrayList<Boolean> temp = new ArrayList<Boolean>();
			if(bulbs.get(n - 1))
				temp.add(!bulbs.get(0));
			else
				temp.add(bulbs.get(0));
			for(int i = 1; i < bulbs.size(); i++) {
				if(bulbs.get(i - 1))
					temp.add(!bulbs.get(i));
				else
					temp.add(bulbs.get(i));
			}
			bulbs = new ArrayList<Boolean>();
				for(int i = 0; i < n; i++)
					bulbs.add(temp.get(i));
			if(map.containsKey(temp))
				break;
			else
				map.put(temp, index);
		}
		if(index == b)
			for(int i = 0; i < n; i++)
				System.out.println(bulbs.get(i) ? 1 : 0);
		else {
			long period = index - map.get(bulbs);
			b = (b - map.get(bulbs)) % period;
			index = 0;
			while(index < b) {
				++index;
				ArrayList<Boolean> temp = new ArrayList<Boolean>();
				if(bulbs.get(n - 1))
					temp.add(!bulbs.get(0));
				else
					temp.add(bulbs.get(0));
				for(int i = 1; i < bulbs.size(); i++) {
					if(bulbs.get(i - 1))
						temp.add(!bulbs.get(i));
					else
						temp.add(bulbs.get(i));
				}
				bulbs = new ArrayList<Boolean>();
					for(int i = 0; i < n; i++)
						bulbs.add(temp.get(i));
			}
			for(int i = 0; i < n; i++)
				System.out.println(bulbs.get(i) ? 1 : 0);
		}
		br.close();
	}
}