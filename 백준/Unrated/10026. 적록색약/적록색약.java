import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static void dfs(int x,int y) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			if(newX>=0 && newY>=0 && newX<N && newY<N) {
				if(!visited[newX][newY] && graph[newX][newY]==graph[x][y]) {
					
					dfs(newX,newY);
				}
			}
		}
		
		
	}
	
	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		graph = new char[N][N];
		visited = new boolean[N][N];
		
		//graph 셋팅
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				graph[i][j] = s.charAt(j);
			}
		}
		
		//normal
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					count++;
				}
			}
		}
		
		int normal = count;
		count = 0;
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(graph[i][j]=='G')
					graph[i][j]='R';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					count++;
				}
			}
		}
		
		int special = count;
		System.out.println(normal+" "+special);
		
	}	
}