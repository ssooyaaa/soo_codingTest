import java.io.*;
import java.util.*;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken())-1;
		
		int[][] arr = new int[N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int nation = Integer.parseInt(st.nextToken())-1;
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int brozen = Integer.parseInt(st.nextToken());
			
			arr[nation][0] = gold;
			arr[nation][1] = silver;
			arr[nation][2] = brozen;
		}
		
		int rank = 1;
		
		for(int i=0;i<N;i++) {
			if(arr[i][0] > arr[K][0])
				rank++;
			else if(arr[i][0]==arr[K][0] && arr[i][1]>arr[K][1])
				rank++;
			else if(arr[i][0]==arr[K][0] && arr[i][1]==arr[K][1] && arr[i][2]>arr[K][2])
				rank++;
		}
		
		System.out.println(rank);
	}
	
}