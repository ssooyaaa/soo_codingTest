import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static boolean[][] graph;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
     
        graph = new boolean[N+1][N+1];
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	graph[a][b] = true;
        }
        
        for(int k=1;k<=N;k++) {
        	for(int i=1;i<=N;i++) {
        		for(int j=1;j<=N;j++) {
        			if(graph[i][k] && graph[k][j])
        				graph[i][j] = true;
        		}
        	}
        }
        
        int[] count = new int[N+1];
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=N;j++) {
        		if(graph[i][j] || graph[j][i])
        			count[i]++;
        	}
        }
        
        int answer = 0;
        for(int i=1;i<=N;i++) {
        	if(count[i]==N-1) {
        		answer++;
        	}
        }
        
        System.out.println(answer);
    }
}
