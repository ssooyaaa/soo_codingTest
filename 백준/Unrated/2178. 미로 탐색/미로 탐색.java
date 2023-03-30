import java.util.*;
import java.io.*;

public class Main{
    
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for(int i=0;i<4;i++){
                int newX = nowX+dx[i];
                int newY = nowY+dy[i];
                
                if(newX<0 || newY<0 || newX>=n || newY>=m){
                    continue;
                }
                if(visited[newX][newY] || graph[newX][newY] ==0){
                    continue;
                }
                
                q.add(new int[]{newX,newY});
                graph[newX][newY] = graph[nowX][nowY]+1;
                visited[newX][newY] = true;
            }
        }
    }
    
	public static void main(String[] args)throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                graph[i][j] = s.charAt(j)-'0';
            }
        }
        visited[0][0] = true;
        bfs(0,0);
        
        System.out.println(graph[n-1][m-1]);
	}
    

}