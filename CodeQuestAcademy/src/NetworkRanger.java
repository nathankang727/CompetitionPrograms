import java.util.*;
public class NetworkRanger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int x = Integer.parseInt(sc.nextLine());
			String[] ip = new String[x];
			String[] binary = new String[x];
			for(int j = 0; j < x; j++) {
				ip[j] = sc.nextLine();
				binary[j] = convertBinary(ip[j]);
			}
			int similarLength = 0;
			for(int j = 0; j < 32; j++) {
				int digit = Integer.parseInt(binary[0].substring(j, j + 1));
				boolean didBreak = false;
				for(int k = 1; k < x; k++) {
					if(digit != Integer.parseInt(binary[k].substring(j, j + 1))) {
						didBreak = true;
						break;
					}
				}
				if(didBreak)
					break;
				++similarLength;
			}
			if(similarLength > 0) {
				String binary2 = binary[0].substring(0, similarLength);
				for(int j = 32 - binary2.length(); j > 0; j--)
					binary2 += "0";
				System.out.println(convertIP(binary2, similarLength));
			}
			else
				System.out.println("0.0.0.0/0");
		}
		sc.close();
	}
	public static String convertBinary(String ip) {
		String[] blocks = ip.split("\\.");
		String ans = "";
		for(int i = 0; i < 4; i++) {
			int n = Integer.parseInt(blocks[i]);
			String temp = Integer.toString(n, 2);
			for(int j = 8 - temp.length(); j > 0; j--)
				temp = "0" + temp;
			ans += temp;
		}
		return ans;
	}
	public static String convertIP(String binary, int block) {
		int[] ips = new int[4];
		for(int i = 0; i < 4; i++)
			ips[i] = Integer.parseInt(binary.substring(i * 8, (i + 1) * 8), 2);
		return ips[0] + "." + ips[1] + "." + ips[2] + "." + ips[3] + "/" + block;
	}
}