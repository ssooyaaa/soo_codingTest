import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static int[][] graph,copy_graph;
	
	static int result = Integer.MIN_VALUE;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void dfs(int count) {
		if(count==3) {
			bfs();
			return;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==0) {
					graph[i][j]=1;
					dfs(count+1);
					graph[i][j]=0;
				}
			}
		}
	}
	
	public static void bfs() {
		int[][] virus = new int[n][m];
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				virus[i][j] = graph[i][j];
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virus[i][j]==2)
					q.add(new int[] {i,j});
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0;i<4;i++) {
				int nowX = now[0]+dx[i];
				int nowY = now[1]+dy[i];
				
				if(nowX>=0 && nowY>=0 && nowX<n && nowY<m) {
					if(virus[nowX][nowY]==0) {
						virus[nowX][nowY]=2;
						q.add(new int[] {nowX,nowY});
					}
				}
			}
		}safe(virus);
	}
	
	
	public static void safe(int[][] virus) {
		int count = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(virus[i][j]==0)
					count ++;
			}
		} result = Math.max(count, result);
	}
	
	public static void main(String[] args)throws IOException{

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		graph = new int[n][m];
		copy_graph = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		
		copy_graph = graph;
		
		dfs(0);
		
		System.out.println(result);
	}	
	
}