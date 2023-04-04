import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewel[] jewel = new Jewel[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			jewel[i] = new Jewel(m,v);
		}
		
		Arrays.sort(jewel, new Comparator<Jewel>() {
			public int compare(Jewel o1, Jewel o2) {
				if(o1.weight == o2.weight) {
					return o2.price - o1.price;
				}
				return o1.weight-o2.weight;
			}
		});
		
		int[] bag = new int[K];
		for(int i=0;i<K;i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bag);
		
		//가격 내림차순
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long answer = 0;
		
		for(int i=0,j=0;i<K;i++) {
			while(j<N && jewel[j].weight<=bag[i]) {
				pq.add(jewel[j++].price);
			}
			
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		
		System.out.println(answer);
		
	}	
}

class Jewel{
	int weight;
	int price;
	
	Jewel(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
}
