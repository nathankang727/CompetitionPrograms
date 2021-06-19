package US_Open2020Silver;
import java.util.*;
import java.io.*;
public class cereal {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("cereal.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("cereal.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] choices = new int[n][2];
		int[] answers = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			choices[i][0] = Integer.parseInt(st.nextToken());
			choices[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] occupy = new int[m + 1];
		int count = 0;
		for(int i = n - 1; i >= 0; i--) {
			int cow = i;
			int type = choices[i][0];
			while(true) {
				if(occupy[type] == 0) {
					occupy[type] = cow;
					++count;
					break;
				}
				else if(occupy[type] < cow && type == choices[cow][1])
					break;
				else {
					int prev = occupy[type];
					occupy[type] = cow;
					if(type == choices[prev][1])
						break;
					type = choices[prev][1];
					cow = prev;
				}
			}
			answers[i] = count;
		}
		for(int i = 0; i < n; i++)
			pw.println(answers[i]);
		br.close();
		pw.close();
	}
}