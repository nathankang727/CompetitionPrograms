package Feb2020Silver;
import java.util.*;
import java.io.*;
public class swap {
	static ArrayList<Integer> tempList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("swap.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("swap.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] commands = new int[m][2];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			commands[i][0] = Integer.parseInt(st.nextToken()) - 1;
			commands[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}
		int[] answer = new int[n];
		int[] temp = new int[n];
		for(int i = 0; i < n; i++)
			temp[i] = i;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < m; i++) {
			tempList = new ArrayList<Integer>();
			for(int j = commands[i][0]; j <= commands[i][1]; j++)
				tempList.add(temp[j]);
			Collections.reverse(tempList);
			for(int j = commands[i][0]; j <= commands[i][1]; j++)
				temp[j] = tempList.get(j - commands[i][0]);
		}
		int count = 0;
		boolean[] isInList = new boolean[n];
		int index = 0;
		int index2 = 0;
		int cycleCount = 0;
		boolean init = false;
		while(count < n) {
			if(!init) {
				for(int i = 0; i < n; i++) {
					if(!isInList[i]) {
						index = i;
						list.add(new ArrayList<Integer>());
						init = true;
						index2 = index;
						break;
					}
				}
			}
			int tempVar = temp[index2];
			index2 = tempVar;
			list.get(cycleCount).add(index2);
			isInList[index2] = true;
			++count;
			if(index == index2) {
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				for(int i = 0; i < list.get(cycleCount).size(); i++)
					tempList.add(list.get(cycleCount).get(i));
				for(int i = 0; i < tempList.size(); i++)
					answer[tempList.get(i)] = tempList.get((i + k % tempList.size()) % tempList.size());
				++cycleCount;
				init = false;
				continue;
			}
		}
		for(int i = 0; i < n; i++)
			pw.println(answer[i] + 1);
		br.close();
		pw.close();
	}
}