import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M,K,X;
	static List<List<Integer>> list;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, -1);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
		}
		
		dist[X] = 0;
		bfs(X);
		
		boolean check = false;
		for(int i=1;i<=N;i++) {
			if(dist[i]==K) {
				System.out.println(i);
				check = true;
			}
		}
		
		if(!check)
			System.out.println(-1);
	
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0;i<list.get(now).size();i++) {
				if(dist[list.get(now).get(i)]==-1) {
					dist[list.get(now).get(i)] = dist[now]+1;
					q.add(list.get(now).get(i));
				}
			}
		}
	}
}