import java.util.*;
public class Main {
	
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		visited = new boolean[M][N];
		
		int count = 0;
		int sum = 0;
		int nowX = 0;
		int nowY = 0;
		int idx = 0;
		
		visited[nowX][nowY] = true;
		sum = 1;
		
		while(idx<4) {
			int nx = nowX+dx[idx];
			int ny = nowY+dy[idx];
			
			if(sum == M*N) {
				System.out.println(count);
				return;
			}
			
			if(nx>=0 && ny>=0 && nx<M && ny<N && !visited[nx][ny]) {
				sum ++;
				visited[nx][ny] = true;
				nowX = nx;
				nowY =ny;
			}else {
				count ++;
				idx++;
			}
			
			if(idx>=4) idx=0;
		}
		
	}
	
	
}