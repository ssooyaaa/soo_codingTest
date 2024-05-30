import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static int answer = 0;
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	
    	map = new char[N][M];
    	visited = new boolean[N][M];
    	
    	int r = 0;
    	int c = 0;
    	
    	for(int i=0;i<N;i++) {
    		String s = sc.next();
    		for(int j=0;j<M;j++) {
    			map[i][j] = s.charAt(j);
    			
    			if(map[i][j]=='I') {
    				r = i;
    				c = j;
    			}
    		}
    	}
    	
    	dfs(r,c);
    	
    	if(answer==0) System.out.println("TT");
    	else System.out.println(answer);
    }
    
    
    public static void dfs(int x, int y) {
    	visited[x][y] = true;
    	
    	if(map[x][y]=='P') answer++;
    	
    	for(int i=0;i<4;i++) {
    		int nx = x+dx[i];
    		int ny = y+dy[i];
    		
    		if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny]) {
    			if(map[nx][ny]!='X')
    				dfs(nx, ny);
    		}
    	}
    }
}