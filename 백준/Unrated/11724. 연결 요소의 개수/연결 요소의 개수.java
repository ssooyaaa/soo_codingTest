import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		int count = 0;
		for(int i=1;i<N+1;i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
    }
	
	public static void dfs(int x) {
		visited[x] = true;
		
		for(int i=1;i<N+1;i++) {
			if(graph[x][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}