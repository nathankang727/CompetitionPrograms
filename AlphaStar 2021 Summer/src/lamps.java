import java.util.*;
import java.io.*;
public class lamps {
	static int n, c, finalConfig[], initConfig[];
	static HashSet<ArrayList<Integer>> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		c = Math.min(c, 4);
		finalConfig = new int[n];
		for(int i = 0; i < n; i++)
			finalConfig[i] = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int input = Integer.parseInt(st.nextToken());
		while(input != -1) {
			finalConfig[input - 1] = 1;
			input = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		input = Integer.parseInt(st.nextToken());
		while(input != -1) {
			finalConfig[input - 1] = 0;
			input = Integer.parseInt(st.nextToken());
		}
		initConfig = new int[n];
		for(int i = 0; i < n; i++)
			initConfig[i] = 1;
		set = new HashSet<ArrayList<Integer>>();
		recursion(0);
		if(set.isEmpty())
			System.out.println("IMPOSSIBLE");
		else {
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> arr : set)
				list.add(arr);
			Collections.sort(list, new MyArrayListComparator());
			for(ArrayList<Integer> arr : list) {
				for(int i = 0; i < arr.size(); i++)
					System.out.print(arr.get(i));
				System.out.println();
			}
		}
		br.close();
	}
	public static void recursion(int index) {
		if(index == c) {
			if(valid()) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for(int i = 0; i < initConfig.length; i++)
					temp.add(initConfig[i]);
				set.add(temp);
			}
			return;
		}
		for(int i = 0; i < n; i++) {
			if(initConfig[i] == 0)
				initConfig[i] = 1;
			else
				initConfig[i] = 0;
		}
		recursion(index + 1);
		for(int i = 0; i < n; i++) {
			if(initConfig[i] == 0)
				initConfig[i] = 1;
			else
				initConfig[i] = 0;
		}
		for(int i = 0; i < n; i += 2) {
			if(initConfig[i] == 0)
				initConfig[i] = 1;
			else
				initConfig[i] = 0;
		}
		recursion(index + 1);
		for(int i = 0; i < n; i += 2) {
			if(initConfig[i] == 0)
				initConfig[i] = 1;
			else
				initConfig[i] = 0;
		}
		for(int i = 1; i < n; i += 2) {
			if(initConfig[i] == 0)
				initConfig[i] = 1;
			else
				initConfig[i] = 0;
		}
		recursion(index + 1);
		for(int i = 1; i < n; i += 2) {
			if(initConfig[i] == 0)
				initConfig[i] = 1;
			else
				initConfig[i] = 0;
		}
		for(int i = 0; i < n; i += 3) {
			if(initConfig[i] == 0)
				initConfig[i] = 1;
			else
				initConfig[i] = 0;
		}
		recursion(index + 1);
		for(int i = 0; i < n; i += 3) {
			if(initConfig[i] == 0)
				initConfig[i] = 1;
			else
				initConfig[i] = 0;
		}
	}
	public static boolean valid() {
		for(int i = 0; i < n; i++)
			if(initConfig[i] != finalConfig[i] && finalConfig[i] != -1)
				return false;
		return true;
	}
	static class MyArrayListComparator implements java.util.Comparator<ArrayList<Integer>> {
	    public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
	    	for(int i = 0; i < n; i++) {
	    		if(a1.get(i) > a2.get(i))
	    			return 1;
	    		else if(a1.get(i) < a2.get(i))
	    			return -1;
	    	}
	    	return 0;
	    }
	}
}