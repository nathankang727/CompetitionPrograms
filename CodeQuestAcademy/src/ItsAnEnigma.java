import java.util.*;
import java.io.*;
public class ItsAnEnigma {
	static int rotors[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int[][] roAndRe = {{3, 6, 8, 0, 5, 4, 1, 9, 2, 7}, {1, 3, 6, 0, 5, 4, 8, 7, 9, 2}, {0, 3, 5, 2, 6, 9, 1, 4, 8, 7},
				{5, 9, 1, 7, 3, 8, 0, 2, 4, 6}, {1, 6, 5, 2, 9, 0, 7, 4, 3, 8}};
			rotors = new int[3][10];
			for(int j = 0; j < 3; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int rotorNum = Integer.parseInt(st.nextToken());
				int startPos = Integer.parseInt(st.nextToken());
				for(int k = startPos; k < startPos + 10; k++)
					rotors[j][k % 10] = (roAndRe[rotorNum][k - startPos] + startPos) % 10;
			}
			String code = br.readLine();
			String res = "";
			int rotaryNumber = 0;
			for(int j = 0; j < code.length(); j++) {
				int n = Integer.parseInt(code.substring(j, j + 1));
				int newNum = index(0, index(1, index(2, roAndRe[0][rotors[2][rotors[1][rotors[0][n]]]])));
				res += newNum + "";
				++rotaryNumber;
				int[][] rotors2 = new int[3][10];
				for(int k = 1; k < 11; k++)
					rotors2[2][k % 10] = (rotors[2][k - 1] + 1) % 10;
				if(rotaryNumber % 10 == 0)
					for(int k = 1; k < 11; k++)
						rotors2[1][k % 10] = (rotors[1][k - 1] + 1) % 10;
				else
					for(int k = 0; k < 10; k++)
						rotors2[1][k] = rotors[1][k];
				if(rotaryNumber % 100 == 0)
					for(int k = 1; k < 11; k++)
						rotors2[0][k % 10] = (rotors[0][k - 1] + 1) % 10;
				else
					for(int k = 0; k < 10; k++)
						rotors2[0][k] = rotors[0][k];
				for(int k = 0; k < 3; k++)
					for(int l = 0; l < 10; l++)
						rotors[k][l] = rotors2[k][l];
			}
			System.out.println(res);
		}
		br.close();
	}
	public static int index(int ind, int n) {
		for(int i = 0; i < rotors[ind].length; i++)
			if(rotors[ind][i] == n)
				return i;
		return -1;
	}
}