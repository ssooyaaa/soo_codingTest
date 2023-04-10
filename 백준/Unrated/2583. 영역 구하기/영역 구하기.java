import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int m, n, k;
    static int[][] graph;
    static boolean[][] visited;
    static int count;
    
    static void dfs(int x, int y) {
    	visited[x][y] = true;
    	count++;
    	
    	for(int i=0;i<4;i++) {
    		int nx = x+dx[i];
    		int ny = y+dy[i];
    		
    		if(nx>=0 && ny>=0 && nx<m && ny<n) {
    			if(graph[nx][ny]==0 && !visited[nx][ny])
    				dfs(nx,ny);
    		}
    	}
    }
 
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
    	graph = new int[m][n];
    	visited = new boolean[m][n];
    	
    	//graph 직사각형 1 표시
    	for(int i=0;i<k;i++) {
    		st = new StringTokenizer(br.readLine());
    		
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken())-1;
			int endY = Integer.parseInt(st.nextToken())-1;
			
			for(int a=startY;a<=endY;a++) {
				for(int b=startX;b<=endX;b++) {
					graph[a][b] = 1;
				}
			}
    		
    	}
    	
    	List<Integer> list = new ArrayList<>();
    	
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(graph[i][j]==0 && !visited[i][j]) {
    				count = 0;
    				dfs(i,j);
    				list.add(count);
    			}
    		}
    	}
    	System.out.println(list.size());
    	Collections.sort(list);
    	for(Integer count : list) {
    		System.out.print(count+" ");
    	}
    	
    }
 
    
}