import java.util.*;
import java.io.*;

public class Main{
    
    static int m,n,k;
    static int[][] graph;
    static boolean[][] visited;
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public static void dfs(int x,int y){
        visited[x][y] = true;
        
        for(int i=0;i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            
            if(newX>=0&&newY>=0&&newX<m&&newY<n){
                if(graph[newX][newY]==1 && !visited[newX][newY]){
                    dfs(newX,newY);
                }
            }
        }
    }
    
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        
        for(int i=1;i<=t;i++){
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            
            graph = new int[m][n];
            visited = new boolean[m][n];
            
            for(int j=0;j<k;j++){
                graph[sc.nextInt()][sc.nextInt()]=1;
            }
            
            int count = 0;
            
            for(int j=0;j<m;j++){
                for(int l=0;l<n;l++){
                    if(graph[j][l]==1 && !visited[j][l]){
                        dfs(j,l);
                        count++;
                    }
                }
            } System.out.println(count);
        }
    }

}