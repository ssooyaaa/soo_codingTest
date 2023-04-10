import java.io.*;
import java.util.*;
public class Main {
	
	
	static char[][] graph;
	
	public static int find(int x, int y) {
		int B = 0; //B부터 시작
		int W = 0; //W부터 시작
		
		for(int i=x;i<x+8;i++) {
			for(int j=y;j<y+8;j++) {
				if((i+j)%2==0) {
					if(graph[i][j]=='B') W++;
					else B++;
				}else {
					if(graph[i][j]=='W') W++;
					else B++;
				}
			}
		} return Math.min(B, W);
	}
	
    public static void main(String[] args)throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	graph = new char[N][M];
    	
    	//배열 입력
    	for(int i=0;i<N;i++) {
    		String str = br.readLine();
    		for(int j=0;j<M;j++) {
    			graph[i][j] = str.charAt(j);
    		}
    	}
    	
    	int answer = Integer.MAX_VALUE;
    	
    	for(int i=0;i<N-7;i++) {
    		for(int j=0;j<M-7;j++) {
    			answer = Math.min(answer, find(i,j));
    		}
    	}
    	System.out.println(answer);
    	
    	
    }
    
	
}
