import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M,R;
	static List<Integer>[] list;
	static boolean[] visited;
	
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	list[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	list[u].add(v);
        	list[v].add(u);
        }
        
        for(int i=1;i<=N;i++) {
        	Collections.sort(list[i], Collections.reverseOrder());
        }
        
        bfs(R);
        
    }
    
    public static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(start);
    	visited[start] = true;
    	
    	int[] order = new int[N+1];
    	int count = 0;
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		count++;
    		order[now] = count;
    		
    		for(int i:list[now]) {
    			if(!visited[i]) {
    				visited[i] = true;
    				q.add(i);
    			}
    		}
    	}
    	
    	for(int i=1;i<=N;i++) {
    		System.out.println(order[i]);
    	}
    }
}