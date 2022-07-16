import java.util.*;
import java.io.*;
public class tlines {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Integer, ArrayList<Integer>> xMap = new HashMap<Integer, ArrayList<Integer>>();
		Map<Integer, ArrayList<Integer>> yMap = new HashMap<Integer, ArrayList<Integer>>();
		int[][] input = new int[n][2];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) {
			xMap.put(input[i][0], new ArrayList<Integer>());
			yMap.put(input[i][1], new ArrayList<Integer>());
		}
		for(int i = 0; i < n; i++) {
			xMap.get(input[i][0]).add(input[i][1]);
			yMap.get(input[i][1]).add(input[i][0]);
		}
		if(xMap.size() <= 3 || yMap.size() <= 3)
			System.out.println("1");
		else if(works(xMap, yMap, true) || works(xMap, yMap, false))
			System.out.println("1");
		else
			System.out.println("0");
		br.close();
	}
	public static boolean works(Map<Integer, ArrayList<Integer>> xMap, Map<Integer, ArrayList<Integer>> yMap, boolean isVertical) {
		if(isVertical) {
			for(Map.Entry<Integer, ArrayList<Integer>> entry : xMap.entrySet()) {
				Map<Integer, ArrayList<Integer>> temp = new HashMap<Integer, ArrayList<Integer>>();
				for(Map.Entry<Integer, ArrayList<Integer>> entry2 : yMap.entrySet()) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					for(int i = 0; i < entry2.getValue().size(); i++)
						list.add(entry2.getValue().get(i));
					temp.put(entry2.getKey(), list);
				}
				for(int i = 0; i < entry.getValue().size(); i++) {
					temp.get(entry.getValue().get(i)).remove(entry.getKey());
					if(temp.get(entry.getValue().get(i)).size() == 0)
						temp.remove(entry.getValue().get(i));
				}
				if(temp.size() <= 2)
					return true;
			}
		}
		else {
			for(Map.Entry<Integer, ArrayList<Integer>> entry : yMap.entrySet()) {
				Map<Integer, ArrayList<Integer>> temp = new HashMap<Integer, ArrayList<Integer>>();
				for(Map.Entry<Integer, ArrayList<Integer>> entry2 : xMap.entrySet()) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					for(int i = 0; i < entry2.getValue().size(); i++)
						list.add(entry2.getValue().get(i));
					temp.put(entry2.getKey(), list);
				}
				for(int i = 0; i < entry.getValue().size(); i++) {
					temp.get(entry.getValue().get(i)).remove(entry.getKey());
					if(temp.get(entry.getValue().get(i)).size() == 0)
						temp.remove(entry.getValue().get(i));
				}
				if(temp.size() <= 2)
					return true;
			}
		}
		return false;
	}
}