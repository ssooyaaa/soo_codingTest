import java.util.*;
import java.io.*;

public class Main {
	
	static int y,x,count;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int r,c,d;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[y][x];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		count = 1;
		
		for(int i=0;i<y;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<x;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(r,c,d);
		System.out.println(count);
		
    }
	
	public static void dfs(int r, int c, int dir) {
		map[r][c] = -1;
		
		for(int i=0;i<4;i++) {
			dir = (dir+3)%4;
			int ny = r + dy[dir];
			int nx = c + dx[dir];
			
			if(ny>=0 && nx>=0 && ny<y && nx<x && map[ny][nx]==0) {
				count ++;
				dfs(ny,nx, dir);
				
				return;
			}
		}
		
		int back = (dir+2)%4;
		int by = r + dy[back];
		int bx = c + dx[back];
		
		if(by>=0 && bx>=0 && by<y && bx<x && map[by][bx]!=1) {
			dfs(by,bx,dir);
		}
	}
	
	  
    
}
