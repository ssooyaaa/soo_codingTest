import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int min = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        for(int i=0;i<N;i++) {
        	String s = br.readLine();
        	for(int j=0;j<s.length();j++) {
        		map[i][j] = s.charAt(j)-'0';
        	}
        }
        
        bfs();
        
        System.out.println(min==Integer.MAX_VALUE? 0:min);
       
    }
    
    public static void bfs() {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {0,0,0});
    	boolean[][][] visited = new boolean[N][N][N*N];
    	visited[0][0][0] = true;
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int x = now[0];
    		int y = now[1];
    		int bw = now[2];
    		
    		if(min<bw) continue;
    		if(x==N-1 && y==N-1) {
    			if(min>bw) min = bw;
    			continue;
    		}
    		
    		for(int i=0;i<4;i++) {
    			int nx = x+dx[i];
    			int ny = y+dy[i];
    			
    			if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny][bw]) continue;
    			
    			if(map[nx][ny]==1) {
    				visited[nx][ny][bw] = true;
    				q.add(new int[] {nx, ny, bw});
    			}else {
    				visited[nx][ny][bw] = true;
    				q.add(new int[] {nx, ny, bw+1});
    			}
    		}
    	}
    	
    }
}