import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int danji;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public static void dfs(int x, int y){
        visited[x][y] = true;
        danji++;
        
        for(int i=0;i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(newX>=0 && newY>=0 && newX<n && newY<n){
                if(graph[newX][newY]==1 && !visited[newX][newY]){
                    dfs(newX, newY);
                }
            }
        }
    }
    
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
        n = Integer.parseInt(br.readLine());
		
        graph = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<n;j++){
                graph[i][j] = s.charAt(j)-'0';
            }
        }
        
        List<Integer> count = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==1 && !visited[i][j]){
                    danji = 0;
                    dfs(i,j);
                    count.add(danji);
                }
            }
        }
        
        System.out.println(count.size());
        
        Collections.sort(count);
        for(int i=0;i<count.size();i++){
            System.out.println(count.get(i));
        }
	}

}