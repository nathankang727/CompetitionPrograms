import java.util.*;
public class Prob09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			ArrayList<teams> list = new ArrayList<teams>();
			for(int j = 0; j < n; j++) {
				String[] input = sc.nextLine().split(",");
				if(input[4].equals("false"))
					continue;
				boolean day = input[2].equals("Day");
				boolean found = false;
				for(int k = 0; k < list.size(); k++) {
					if(list.get(k).id.equals(input[3]) && day) {
						list.set(k, new teams(input[3], list.get(k).d + 1, list.get(k).n));
						found = true;
					}
					else if(list.get(k).id.equals(input[3]) && !day) {
						list.set(k, new teams(input[3], list.get(k).d, list.get(k).n + 1));
						found = true;
					}
				}
				if(!found && day)
					list.add(new teams(input[3], 1, 0));
				else if(!found && !day)
					list.add(new teams(input[3], 0, 1));
			}
			Collections.sort(list);
			for(int j = 0; j < list.size(); j++)
				System.out.println(list.get(j).id + "," + list.get(j).d + "," + list.get(j).n);
		}
		sc.close();
	}
	static class teams implements Comparable<teams> {
		public String id;
		public int d, n;
		public int compareTo(teams T) {
			return id.compareTo(T.id);
		}
		public teams(String idd, int day, int night) {
			id = idd;
			d = day;
			n = night;
		}
	}
}