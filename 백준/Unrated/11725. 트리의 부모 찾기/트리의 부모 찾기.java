import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] parent;
	static boolean[] visited;
	static StringTokenizer st;
	static ArrayList<Integer> list[]; //노드저장
	
	public static void dfs(int index) {
		visited[index] = true;
		for(int i:list[index]) {
			if(!visited[i]) {
				parent[i] = index;
				dfs(i);
			}
		}
	}
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        parent = new int[n+1];
        
        for(int i=0;i<n+1;i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<n-1;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	list[a].add(b);
        	list[b].add(a);
        }
        
        dfs(1);
        
        for(int i=2;i<parent.length;i++) {
        	System.out.println(parent[i]);
        }
    }
	
}