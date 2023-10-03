import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		
		int count = 1;
		sb.append("<");
		
		while(!q.isEmpty()) {
			if(count==K) {
				count = 1;
				int num = q.poll();
				sb.append(num);
				
				if(!q.isEmpty())
					sb.append(", ");
			}else {
				q.add(q.poll());
				count++;
			}
		}
		sb.append(">");
		
		System.out.println(sb.toString());
	}
	
}