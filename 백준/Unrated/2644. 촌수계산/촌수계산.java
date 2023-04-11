import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static List<Integer>[] relation;
	static boolean[] visited;
	static int res = -1;
	
	public static void dfs(int start, int end, int count) {
		if(start == end) {
			res = count;
			return;
		}
		visited[start] = true;
		for(int i=0;i<relation[start].size();i++) {
			int next = relation[start].get(i);
			if(!visited[next])
				dfs(next, end, count+1);
		}
	}
 
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	relation = new ArrayList[n+1];
    	visited = new boolean[n+1];
    	
    	for(int i=1;i<=n;i++) {
    		relation[i] = new ArrayList<>();
    	}
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int x = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	
    	int l = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<l;i++) {
    		st = new StringTokenizer(br.readLine());
    		int p = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		relation[p].add(c);
    		relation[c].add(p);
    	}
    	
    	dfs(x,y,0);
    	System.out.println(res);
    	
    }
 
    
}
