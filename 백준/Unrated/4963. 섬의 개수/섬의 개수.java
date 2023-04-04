import java.io.*;
import java.util.*;

public class Main {
	
	static int h,w;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1,-1,1,-1,1};
	static int[] dy = {1,-1,0,0,-1,1,1,-1};
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0;i<8;i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			
			if(newX>=0 && newY>=0 && newX<h && newY<w) {
				if(!visited[newX][newY] && graph[newX][newY]==1) {
					dfs(newX, newY);
				}
			}
		}
	}
	
	
	public static void main(String[] args)throws IOException{

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w==0 && h==0) break;
			
			graph = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					graph[i][j]=sc.nextInt();
				}
			}
			
			int count = 0;
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(graph[i][j]==1 && !visited[i][j]) {
						dfs(i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}	
}