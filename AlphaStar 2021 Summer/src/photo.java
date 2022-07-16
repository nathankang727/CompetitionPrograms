import java.util.*;
import java.io.*;
public class photo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Range[] ab = new Range[k];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int input1 = Integer.parseInt(st.nextToken());
			int input2 = Integer.parseInt(st.nextToken());
			ab[i] = new Range(Math.min(input1, input2), Math.max(input1, input2));
		}
		Arrays.sort(ab);
		int count = 1;
		int end = 0;
		for(int i = 0; i < k; i++) {
			if(end <= ab[i].a) {
				++count;
				end = ab[i].b;
			}
		}
		System.out.println(count);
		br.close();
	}
	static class Range implements Comparable<Range>{
		public int a, b;
		public int compareTo(Range r) {
			if(this.b == r.b)
				return this.a - r.a;
			return this.b - r.b;
		}
		public Range(int start, int end) {
			this.a = start;
			this.b = end;
		}
	}
}