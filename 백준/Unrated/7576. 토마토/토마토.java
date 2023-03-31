import java.util.*;
import java.io.*;

public class Main{
    
    static int m,n;
    static int[][] graph;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static Queue<int[]> q = new LinkedList<>();
    
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[m][n];
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }
        System.out.println(bfs());
	}
    
    public static int bfs(){
        while(!q.isEmpty()){
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            
            for(int i=0;i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];
                
                if(newX>=0 && newY>=0 && newX<m && newY<n){
                    if(graph[newX][newY]==0){
                        graph[newX][newY] = graph[x][y]+1;
                        q.add(new int[]{newX,newY});
                    }
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        if(checkZero()){
            return -1;
        } else{
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(max<graph[i][j])
                        max = graph[i][j];
                }
            }
        } return max-1;
        
    }
    
    public static boolean checkZero(){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==0)
                    return true;
            }
        }return false;
    }

}