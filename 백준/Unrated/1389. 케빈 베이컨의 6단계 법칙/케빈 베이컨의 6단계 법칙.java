import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int[][] graph;
	static boolean[] visited;
	static int answer;
	static int minCount = Integer.MAX_VALUE;
	
	static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		visited[start] = true;
		
		int count = 0;
		q.add(new int[] {start,0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			count += now[1];
			
			for(int i=1;i<n+1;i++) {
				int num = graph[now[0]][i];
				
				if(num == 1 && !visited[i]) {
					visited[i] = true;
					q.add(new int[] {i,now[1]+1});
				}
			}
		}
		if(minCount > count) {
			minCount = count;
			answer = start;
		}
	}
 
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	graph = new int[n+1][n+1];
    	for(int i=0;i<m;i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		graph[x][y] = graph[y][x] = 1;
    	}
    	
    	for(int i=1;i<n+1;i++) {
    		visited = new boolean[n+1];
    		bfs(i);
    	}
    	System.out.println(answer);
    	
    }
 
    
}