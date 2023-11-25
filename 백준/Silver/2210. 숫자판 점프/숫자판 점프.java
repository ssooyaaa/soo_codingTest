import java.util.*;
import java.io.*;

public class Main {
	
	static String[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static List<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new String[5][5];
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map[i][j] = st.nextToken();
			}
		}
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				dfs(map, i, j, 0, map[i][j]);
			}
		}
		
		System.out.println(list.size());
		
	}
	
	static void dfs(String[][] map, int x, int y, int count, String m) {
		if(count==5) {
			if(!list.contains(m)) {
				list.add(m);
			}
			
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nowX = x+dx[i];
			int nowY = y+dy[i];
			
			if(0<=nowX && 0<=nowY && nowX<5 && nowY<5) {
				dfs(map, nowX, nowY, count+1, m+map[nowX][nowY]);
			}
		}
	}
	
}