import java.util.*;
import java.io.*;

public class Main {
	
	static int R,C,sheep,wolf;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0;i<R;i++) {
        	String s = br.readLine();
        	for(int j=0;j<C;j++) {
        		map[i][j] = s.charAt(j);
        		if(map[i][j]=='#') visited[i][j] = true;
        	}
        }
        
        for(int i=0;i<R;i++) {
        	for(int j=0;j<C;j++) {
        		if(!visited[i][j]) bfs(i,j);
        	}
        }
        
        System.out.println(sheep+" "+wolf);
    }
    
    public static void bfs(int i, int j) {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {i, j});
    	visited[i][j] = true;
    	
    	int sCount = 0;
    	int wCount = 0;
    	if(map[i][j]=='o') sCount++;
    	else if(map[i][j]=='v') wCount++;
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		for(int k=0;k<4;k++) {
    			int nx = now[0]+dx[k];
    			int ny = now[1]+dy[k];
    			
    			if(nx>=0 && ny>=0 && nx<R && ny<C && !visited[nx][ny]) {
    				if(map[nx][ny]=='o') sCount++;
    				else if(map[nx][ny]=='v') wCount++;
    				
    				visited[nx][ny] = true;
    				q.add(new int[] {nx,ny});
    			}
    		}
    	}
    	
    	if(sCount<=wCount) wolf += wCount;
    	else sheep += sCount;
    }
}