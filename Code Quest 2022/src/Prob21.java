import java.util.*;
import java.math.*;
import java.text.*;
public class Prob21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("$0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int in = sc.nextInt();
			int c = sc.nextInt();
			ArrayList<Item> items = new ArrayList<Item>();
			for(int j = 0; j < in; j++)
				items.add(new Item(sc.nextInt(), sc.next(), sc.nextDouble()));
			Collections.sort(items);
			HashMap<Integer, ArrayList<Item>> carts = new HashMap<Integer, ArrayList<Item>>();
			for(int j = 0; j < c; j++) {
				int id = sc.nextInt();
				if(!carts.containsKey(id))
					carts.put(id, new ArrayList<Item>());
				String cmd = sc.next();
				if(cmd.equals("ADD")) {
					String item = sc.next();
					int quan = sc.nextInt();
					int prev = 0;
					int index = -1;
					for(int k = 0; k < carts.get(id).size(); k++) {
						if(carts.get(id).get(k).n.equals(item)) {
							prev = carts.get(id).get(k).s;
							index = k;
							break;
						}
					}
					if(quan + prev > items.get(find(items, item)).s)
						System.out.println("Not enough " + item + " for customer " + id);
					else {
						if(index == -1)
							carts.get(id).add(new Item(quan, item, items.get(find(items, item)).p));
						else
							carts.get(id).set(index, new Item(quan + carts.get(id).get(index).s, item, carts.get(id).get(index).p));
						System.out.println("Added " + quan + " " + item + " to customer " + id + "\'s cart");
					}
				}
				else if(cmd.equals("REMOVE")) {
					String item = sc.next();
					int quan = sc.nextInt();
					int index = 0;
					boolean works = false;
					for(int k = 0; k < carts.get(id).size(); k++) {
						if(carts.get(id).get(k).n.equals(item)) {
							works = quan <= carts.get(id).get(k).s;
							index = k;
							break;
						}
					}
					if(works) {
						carts.get(id).set(index, new Item(carts.get(id).get(index).s - quan, item, carts.get(id).get(index).p));
						System.out.println("Removed " + quan + " " + item + " from customer " + id + "\'s cart");
					}
					else
						System.out.println("Customer " + id + " does not have that many " + item + "s");
				}
				else {
					double cost = 0.0;
					Collections.sort(carts.get(id));
					for(int k = 0; k < carts.get(id).size(); k++) {
						if(items.get(find(items, carts.get(id).get(k).n)).s < carts.get(id).get(k).s)
							System.out.println("Out of stock of " + carts.get(id).get(k).n);
						else {
							cost += (double)(carts.get(id).get(k).s) * carts.get(id).get(k).p;
							items.set(find(items, carts.get(id).get(k).n), new Item(items.get(find(items, carts.get(id).get(k).n)).s - carts.get(id).get(k).s, carts.get(id).get(k).n, carts.get(id).get(k).p));
						}
					}
					carts.get(id).clear();
					System.out.println("Customer " + id + "\'s total: " + df.format(cost));
				}
			}
			Collections.sort(items);
			for(int j = 0; j < items.size(); j++) {
				if(items.get(j).s <= 0)
					continue;
				System.out.println(items.get(j).n + " - " + items.get(j).s);
			}
		}
		sc.close();
	}
	static class Item implements Comparable<Item> {
		public int s;
		public String n;
		public double p;
		public int compareTo(Item i) {
			return this.n.compareTo(i.n);
		}
		public Item(int stock, String name, double price) {
			s = stock;
			n = name;
			p = price;
		}
	}
	public static int find(ArrayList<Item> items, String name) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).n.equals(name))
				return i;
		}
		return -1;
	}
}