import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[][] map;
	static int[][] cost;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			cost = new int[n][n];
			
			if(n==0)
				break;
			
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			
			count++;
			System.out.println("Problem "+count+": "+bfs());
		}
	}
	
	static int bfs() {
		
		Queue<int[]> q = new LinkedList<>();
		cost[0][0] = map[0][0];
		q.add(new int[] {0,0,map[0][0]});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0;i<4;i++) {
				int x = now[0]+dx[i];
				int y = now[1]+dy[i];
				
				if(x>=0 && y>=0 && x<n && y<n) {
					if(cost[x][y]>cost[now[0]][now[1]]+map[x][y]) {
						cost[x][y] = cost[now[0]][now[1]]+map[x][y];
						q.add(new int[] {x,y,cost[x][y]});
					}
				}
				
			}
		}
		return cost[n-1][n-1];
	}
}
