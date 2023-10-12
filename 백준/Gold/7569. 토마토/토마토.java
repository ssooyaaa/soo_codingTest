import java.util.*;
import java.io.*;

public class Main {
	
	static int M,N,H;
	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static int[][][] tomato;
	static Queue<int[]> q;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][M][N];
		q = new LinkedList<>();
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<M;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					
					if(tomato[i][j][k]==1) {
						q.add(new int[] {i,j,k});
					}
					
				}
			}
		}
		
		System.out.println(bfs());
	
	}
	
	static int bfs() {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			int z = now[0];
			int x = now[1];
			int y = now[2];
			
			for(int i=0;i<6;i++) {
				int nz = z+dz[i];
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nz>=0 && nx>=0 && ny>=0 && nz<H && nx<M && ny<N) {
					if(tomato[nz][nx][ny]==0) {
						tomato[nz][nx][ny] = tomato[z][x][y]+1;
						
						q.add(new int[] {nz,nx,ny});
					}
				}
			}
		
		}
		
		int result = Integer.MIN_VALUE;
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<N;k++) {
					if(tomato[i][j][k]==0) return -1;
					
					result = Math.max(result, tomato[i][j][k]);
				}
			}
		}
		
		if(result==1) return 0;
		else return result-1;
	}
}