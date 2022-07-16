package Dec2015Silver;
import java.util.*;
import java.io.*;
public class lightson {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("lightson.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("lightson.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<Room, ArrayList<Room>> rooms = new HashMap<Room, ArrayList<Room>>();
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				rooms.put(new Room(i, j), new ArrayList<Room>());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			Room xy = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Room ab = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if(rooms.containsKey(xy)) {
				ArrayList<Room> list = rooms.get(xy);
				list.add(ab);
				rooms.put(xy, list);
			}
			else {
				ArrayList<Room> list = new ArrayList<Room>();
				list.add(ab);
				rooms.put(xy, list);
			}
		}
		System.out.println(rooms.size());
		for(Map.Entry<Room, ArrayList<Room>> map : rooms.entrySet()) {
			System.out.println(map.getKey().x + " " + map.getKey().y);
			for(int i = 0; i < map.getValue().size(); i++)
				System.out.println(map.getValue().get(i).x + " " + map.getValue().get(i).y);
			System.out.println("-------------------------------------------------------");
		}
		br.close();
		pw.close();
	}
	static class Room {
		public int x;
		public int y;
		public Room(int xx, int yy) {
			this.x = xx;
			this.y = yy;
		}
	}
}