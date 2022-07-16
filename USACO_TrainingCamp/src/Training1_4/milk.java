package Training1_4;
/*
ID: nathank3
LANG: JAVA
TASK: milk
*/
import java.util.*;
import java.io.*;
public class milk {
    static Scanner in;
    static PrintWriter out;
    static int n;
    static Farmers[] pa;
    public static void main(String[] args) {
        try {
            in = new Scanner(new File("milk.in"));
            out = new PrintWriter(new File("milk.out"));
            init();
            out.println(solve());
            out.close();
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() {
    	n = in.nextInt();
    	int m = in.nextInt();
    	pa = new Farmers[m];
    	for(int i = 0; i < pa.length; i++)
    		pa[i] = new Farmers(in.nextInt(), in.nextInt());
    	Arrays.sort(pa);
    }
    private static String solve() {
        int total = 0;
        int pay = 0;
        int index = 0;
    	while(total < n) {
        	int price = pa[index].getPrice();
        	int amount = pa[index].getAmount();
        	int bought = 0;
        	if(amount + total <= n)
        		bought = amount;
        	else
        		bought = n - total;
        	pay += price * bought;
        	total += bought;
        	index++;
        }
        return String.valueOf(pay);
    }
}
class Farmers implements Comparable<Farmers> { 
    private int price;
    private int amount;
    public int compareTo(Farmers f) {
        return this.price - f.price;
    }
    public Farmers(int pr, int am) {
        this.price = pr;
        this.amount = am;
    }
    public int getPrice() {
    	return price;
    }
    public int getAmount() {
    	return amount;
    }
}