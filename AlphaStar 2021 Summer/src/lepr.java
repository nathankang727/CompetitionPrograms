import java.util.*;
import java.io.*;
public class lepr {
	static int n, matrix[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				result = Math.max(result, sumRow(i, j));
				result = Math.max(result, sumCol(i, j));
				result = Math.max(result, sumDiag1(i, j));
				result = Math.max(result, sumDiag2(i, j));
			}
		}
		System.out.println(result);
	}
	public static int sumRow(int row, int col) {
		int sum = 0;
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			sum += matrix[row][(col + i) % n];
			result = Math.max(result, sum);
		}
		return result;
	}
	public static int sumCol(int row, int col) {
		int sum = 0;
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			sum += matrix[(row + i) % n][col];
			result = Math.max(result, sum);
		}
		return result;
	}
	public static int sumDiag1(int row, int col) {
		int sum = 0;
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			sum += matrix[(row + i) % n][(col + i) % n];
			result = Math.max(result, sum);
		}
		return result;
	}
	public static int sumDiag2(int row, int col) {
		int sum = 0;
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			sum += matrix[(row + i) % n][(col - i + n) % n];
			result = Math.max(result, sum);
		}
		return result;
	}
}