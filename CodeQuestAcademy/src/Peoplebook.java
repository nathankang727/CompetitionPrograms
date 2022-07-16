import java.util.*;
public class Peoplebook {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			String input = sc.nextLine();
			input = input.substring(1, input.length() - 1);
			String[][] info = new String[6][n];
			for(int j = 0; j < 6; j++) {
				int n1 = input.indexOf("[");
				int n2 = input.indexOf("]");
				String[] input2 = input.substring(n1 + 1, n2).split(",");
				for(int k = 0; k < input2.length; k++)
					info[j][k] = input2[k];
				if(j < 5)
					input = input.substring(n2 + 2);
			}
			for(int j = 0; j < n; j++) {
				String name = sc.nextLine();
				int index = 0;
				for(int k = 0; k < info[0].length; k++)
					if(name.equals(info[0][k]))
						index = k;
				System.out.println("Name: " + info[0][index]);
				System.out.println("Age: " + info[1][index]);
				System.out.println("Instagram: " + info[2][index]);
				System.out.println("Twitter: " + info[3][index]);
				System.out.println("Phone: " + info[4][index]);
				System.out.println("Email: " + info[5][index]);
			}
		}
		sc.close();
	}
}