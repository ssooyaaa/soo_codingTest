import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[][] graph;
	static int[][] change;
	static boolean[][] visited;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nowX = x + dx[i];
			int nowY = y + dy[i];
			
			if(nowX>=0 && nowY>=0 && nowX<n && nowY<n) {
				if(change[nowX][nowY]==1 && !visited[nowX][nowY])
					dfs(nowX, nowY);
			}
		}
	}
	
	
	public static void main(String[] args)throws IOException{

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		graph = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		
		int max = 1;
		
		for(int i=1;i<101;i++) {
			change = new int[n][n];
			int count = 0;
			
			visited = new boolean[n][n];
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(graph[j][k]<=i)
						change[j][k] = 0;
					else change[j][k] = 1;
				}
			}
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(change[j][k]==1 && !visited[j][k]) {
						dfs(j,k);
						count++;
					}
				}
			}
			
			max = Math.max(max, count);
		} System.out.println(max);
		
	}	
	
}