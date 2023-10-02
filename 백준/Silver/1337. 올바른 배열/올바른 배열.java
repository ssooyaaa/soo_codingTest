import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			set.add(arr[i]);
		}
		
		int min = 4;
		for(int i=0;i<arr.length;i++) {
			int count = 1;
			for(int j=arr[i]+1;j<arr[i]+5;j++) {
				if(set.contains(j)) {
					count++;
				}
			}
			min = Math.min(min, 5-count);
		}
		
		System.out.println(min);
	}
	
}
