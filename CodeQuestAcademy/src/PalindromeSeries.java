import java.util.*;
public class PalindromeSeries {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			ArrayList<Integer> index = new ArrayList<Integer>();
			for(int j = 1; j <= n; j++) {
				StringBuilder sb = new StringBuilder();
				String input = sc.nextLine().toLowerCase();
				sb.append(input);
				sb.reverse();
				if(!input.equals(sb.toString()))
					index.add(j);
			}
			if(index.size() == 0)
				System.out.println("True");
			else {
				System.out.print("False - " + index.get(0));
				for(int j = 1; j < index.size(); j++)
					System.out.print(", " + index.get(j));
				System.out.println();
			}
		}
		sc.close();
	}
}