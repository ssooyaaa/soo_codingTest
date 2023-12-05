import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[][] cheese;
	static boolean[][] visited;
	static int count, time, answer;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheese = new int[N][M];
		count = 0;
		time = 0;
		answer = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j]==1) count++;
			}
		}
		
		while(count!=0) {
			time++;
			answer = count;
			melt();
		}
		
		System.out.println(time);
		System.out.println(answer);
	}
	
	public static void melt() {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
        
		visited = new boolean[N][M];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0;i<4;i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny])
					continue;
				
				if(cheese[nx][ny]==1) {
					count--;
					cheese[nx][ny] = 0;
				}else if(cheese[nx][ny]==0) {
					q.add(new int[] {nx,ny});
				}
				
				visited[nx][ny] = true;
			}
		}
	}
	
}
