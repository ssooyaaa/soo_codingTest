import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			
			list.get(first).add(last);
			indegree[last]++;
		}
		
		Queue<Integer> q = new PriorityQueue<>();
		
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0)
				q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now+" ");
			
			for(int i=0;i<list.get(now).size();i++) {
				indegree[list.get(now).get(i)]--;
				
				if(indegree[list.get(now).get(i)]==0) {
					q.add(list.get(now).get(i));
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
}