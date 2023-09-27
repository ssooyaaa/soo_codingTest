import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] sortedArr = new int[N];
					
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			if(arr.length%2==0) {
				int j = 0;
				for(int i=0;i<arr.length;i=i+2) {
					sortedArr[j] = arr[i];
					j++;
				}
				
				int k = arr.length-1;
				for(int i=1;i<arr.length;i=i+2) {
					sortedArr[k] = arr[i];
					k--;
				}
			}else {
				int j = 0;
				for(int i=0;i<arr.length-1;i=i+2) {
					sortedArr[j] = arr[i];
					j++;
				}
				
				int k = arr.length-1;
				for(int i=1;i<arr.length-1;i=i+2) {
					sortedArr[k] = arr[i];
					k--;
				}
				
				sortedArr[arr.length/2] = arr[arr.length-1];
			}
			
			int min = Math.abs(sortedArr[0]-sortedArr[arr.length-1]);
			
			for(int i=0;i<arr.length-1;i++) {
				min = Math.max(min, Math.abs(sortedArr[i]-sortedArr[i+1]));
			}
			
			System.out.println(min);
		}
		
		
		
	}

}