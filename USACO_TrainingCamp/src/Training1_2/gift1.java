package Training1_2;
/*
ID: nathank3
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;
public class gift1 {
    static Scanner in;
    static PrintWriter out;
    static Map<String, Integer> friends;
    public static void main(String[] args) {
        try {
            in = new Scanner(new File("gift1.in"));
            out = new PrintWriter(new File("gift1.out"));
            init();
            out.print(solve());
            out.close();
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() {
    	friends = new LinkedHashMap<String, Integer>();
    	int n = Integer.parseInt(in.nextLine());
    	for(int i = 0; i < n; i++)
    		friends.put(in.nextLine(), 0);
    }
    private static String solve() {
        while(in.hasNext()) {
        	String s = in.nextLine();
        	String[] nums = in.nextLine().split(" ");
        	int amount = Integer.parseInt(nums[0]);
        	int people = Integer.parseInt(nums[1]);
        	if(people > 0)
        		friends.put(s, friends.get(s) - amount + (amount % people));
            for(int i = 0; i < people; i++) {
            	String name = in.nextLine();
            	friends.put(name, friends.get(name) + (amount / people));
            }
        }
        String res = "";
        Set<Map.Entry<String,Integer>> st = friends.entrySet();
        for(Map.Entry<String, Integer> map : st)
        	res += map.getKey() + " " + map.getValue() + "\n";
        return res;
    }
}