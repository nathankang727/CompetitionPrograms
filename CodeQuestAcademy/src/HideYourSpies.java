import java.util.*;
public class HideYourSpies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int xSpy = sc.nextInt();
			int ySpy = sc.nextInt();
			int xCam = sc.nextInt();
			int yCam = sc.nextInt();
			int maxX = Math.max(xSpy, xCam);
			int minX = Math.min(xSpy, xCam);
			int maxY = Math.max(ySpy, yCam);
			int minY = Math.min(ySpy, yCam);
			int w = sc.nextInt();
			int[][] walls = new int[w][4];
			for(int j = 0; j < w; j++)
				for(int k = 0; k < 4; k++)
					walls[j][k] = sc.nextInt();
			boolean scUndefined = xSpy == xCam ? true : false;
			double slopeSC = scUndefined ? 0 : (double)(ySpy - yCam) / (double)(xSpy - xCam);
			double c = scUndefined ? 0 : (double)(yCam) - slopeSC * (double)(xCam);
			if(scUndefined) {
				boolean didBreak = false;
				for(int j = 0; j < w; j++) {
					if(walls[j][0] <= xSpy && walls[j][2] >= xSpy) {
						if(minY <= walls[j][1] && walls[j][1] <= maxY || minY <= walls[j][3] && walls[j][3] <= maxY) {
							didBreak = true;
							System.out.println("NO");
							break;
						}
					}
				}
				if(!didBreak)
					System.out.println("YES");
			}
			else {
				boolean didBreak = false;
				for(int j = 0; j < w; j++) {
					int maX = Math.max(walls[j][0], walls[j][2]);
					int miX = Math.min(walls[j][0], walls[j][2]);
					int maY = Math.max(walls[j][1], walls[j][3]);
					int miY = Math.min(walls[j][1], walls[j][3]);
					boolean scUndefined2 = walls[j][0] == walls[j][2] ? true : false;
					double slopeSC2 = scUndefined ? 0 : (double)(walls[j][3] - walls[j][1]) / (double)(walls[j][2] - walls[j][0]);
					double c2 = scUndefined ? 0 : (double)(walls[j][3]) - slopeSC2 * (double)(walls[j][2]);
					if(scUndefined2) {
						double temp = slopeSC * walls[j][0] + c;
						if(minY <= temp && temp <= maxY) {
							didBreak = true;
							System.out.println("NO");
							break;
						}
					}
					else {
						double xInter = (c2 - c) / (slopeSC - slopeSC2);
						double yInter = slopeSC * xInter + c;
						if(minX <= xInter && xInter <= maxX) {
							if(minY <= yInter && yInter <= maxY) {
								if(miX <= xInter && xInter <= maX) {
									if(miY <= yInter && yInter <= maY) {
										didBreak = true;
										System.out.println("NO");
										break;
									}
								}
							}
						}
					}
				}
				if(!didBreak)
					System.out.println("YES");
			}
		}
		sc.close();
	}
}