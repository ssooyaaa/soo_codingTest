import java.util.*;
import java.io.*;


public class Main {
	
	static int[][] graph;
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void find() {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(graph[i][k]==1 && graph[k][j]==1) {
						graph[i][j] = 1;
					}
				}
			}
		}
	}

}