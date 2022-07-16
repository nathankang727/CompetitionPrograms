import java.util.*;
import java.io.*;
public class RPN {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int a = 0; a < t; a++) {
			int n = Integer.parseInt(br.readLine());
			for(int b = 0; b < n; b++) {
				String[] input = br.readLine().split(" ");
				ArrayList<String> s = new ArrayList<String>();
				for(int i = 0; i < input.length; i++)
					s.add(input[i]);
				String ans = postfixConvert(s);
				String spacedAns = ans.charAt(0) + "";
				for(int i = 1; i < ans.length(); i++)
					spacedAns += " " + ans.charAt(i);
				System.out.println(spacedAns);
			}
		}
		br.close();
	}
	public static String postfixConvert(ArrayList<String> s) {
		while(s.indexOf("(") >= 0 || s.indexOf(")") >= 0) {
			int front = s.indexOf("(");
			int back = 0;
			int frontCnt = 0;
			for(int i = front + 1; i <= s.lastIndexOf(")"); i++) {
				if(s.get(i).equals("("))
					++frontCnt;
				else if(s.get(i).equals(")") && frontCnt > 0)
					--frontCnt;
				else if(s.get(i).equals(")") && frontCnt == 0) {
					back = i;
					break;
				}
			}
			ArrayList<String> temp = new ArrayList<String>();
			for(int i = front + 1; i < back; i++)
				temp.add(s.get(i));
			s.set(front, postfixConvert(temp));
			for(int i = back; i > front; i--)
				s.remove(i);
		}
		while(s.indexOf("^") >= 0) {
			int exp = s.lastIndexOf("^");
			String temp = s.get(exp - 1) + s.get(exp + 1) + "^";
			s.set(exp - 1, temp);
			s.remove(exp + 1);
			s.remove(exp);
		}
		while(s.indexOf("*") >= 0 || s.indexOf("/") >= 0) {
			int md = 0;
			if(s.indexOf("*") == -1)
				md = s.indexOf("/");
			else if(s.indexOf("/") == -1)
				md = s.indexOf("*");
			else
				md = Math.min(s.indexOf("*"), s.indexOf("/"));
			String temp = s.get(md - 1) + s.get(md + 1) + s.get(md);
			s.set(md - 1, temp);
			s.remove(md + 1);
			s.remove(md);
		}
		while(s.indexOf("+") >= 0 || s.indexOf("-") >= 0) {
			int as = 0;
			if(s.indexOf("+") == -1)
				as = s.indexOf("-");
			else if(s.indexOf("-") == -1)
				as = s.indexOf("+");
			else
				as = Math.min(s.indexOf("+"), s.indexOf("-"));
			String temp = s.get(as - 1) + s.get(as + 1) + s.get(as);
			s.set(as - 1, temp);
			s.remove(as + 1);
			s.remove(as);
		}
		return s.toString().replace("[", "").replace("]", "");
	}
}