import java.util.*;
public class DollarBillPoker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String in = sc.nextLine();
			String[] inputStr = in.split("");
			ArrayList<Integer> input = new ArrayList<Integer>();
			int[] digitCount = new int[10];
			int max = 0;
			for(int j = 0; j < 8; j++) {
				if(!inputStr[j].equals("0")) {
					input.add(Integer.parseInt(inputStr[j]));
					++digitCount[input.get(input.size() - 1)];
					max = Math.max(max, input.get(input.size() - 1));
				}
			}
			boolean b = false;
			TreeSet<Integer> set = new TreeSet<Integer>();
			for(int j = 0; j < input.size(); j++)
				set.add(input.get(j));
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j : set)
				list.add(j);
			for(int j = 0; j <= list.size() - 5; j++) {
				if(list.get(j) + 1 == list.get(j + 1) && list.get(j + 1) + 1 == list.get(j + 2) && list.get(j + 2) + 1 == list.get(j + 3)
						&& list.get(j + 3) + 1 == list.get(j + 4)) {
					b = true;
					break;
				}
			}
			Arrays.sort(digitCount);
			System.out.print(in + " = ");
			if(digitCount[9] >= 5)
				System.out.println("FIVE OF A KIND");
			else if(digitCount[9] >= 4)
				System.out.println("FOUR OF A KIND");
			else if(check(0, digitCount))
				System.out.println("FULL HOUSE");
			else if(b)
				System.out.println("STRAIGHT");
			else if(digitCount[9] >= 3)
				System.out.println("THREE OF A KIND");
			else if(check(1, digitCount))
				System.out.println("TWO PAIR");
			else if(check(2, digitCount))
				System.out.println("PAIR");
			else
				System.out.println(max);
		}
		sc.close();
	}
	public static boolean check(int t, int[] digitCount) {
		if(t == 0) {
			boolean b1 = false;
			boolean b2 = false;
			for(int i = 0; i < 10; i++) {
				if(!b1 && digitCount[i] >= 3)
					b1 = true;
				else if(digitCount[i] >= 2)
					b2 = true;
			}
			if(b1 && b2)
				return true;
		}
		else if(t == 1) {
			int cnt = 0;
			int num = -1;
			for(int i = 0; i < 10; i++)
				if(digitCount[i] == 2 && (num == -1 || num != i))
					++cnt;
			if(cnt >= 2)
				return true;
		}
		else if(t == 2) {
			int cnt = 0;
			for(int i = 0; i < 10; i++)
				if(digitCount[i] == 2)
					++cnt;
			if(cnt >= 1)
				return true;
		}
		return false;
	}
}