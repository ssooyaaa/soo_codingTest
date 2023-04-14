import java.util.*;
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), Q = sc.nextInt();
		
		List<int[]>[] list = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1;i<N;i++) {
			int p = sc.nextInt(), q = sc.nextInt(), r = sc.nextInt();
			list[p].add(new int[] {q,r});
			list[q].add(new int[] {p,r});
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<Q;i++) {
			int k = sc.nextInt(), v = sc.nextInt();
			
			boolean[] visited = new boolean[N+1];
			visited[v] = true;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(v);
			
			int answer = 0;
			while(!q.isEmpty()) {
				int now = q.poll();
				
				for(int[] a:list[now]) {
					if(!visited[a[0]] && a[1]>=k) {
						q.add(a[0]);
						visited[a[0]] = true;
						answer++;
					}
				}
			}sb.append(answer).append('\n');
		}System.out.println(sb.toString());
		
    }
    
    
}