import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS[0] = arr[0];
		int len = 1;
		
		for(int i=1;i<N;i++) {
			int num = arr[i];
			
			if(LIS[len-1]<num) {
				len++;
				LIS[len-1] = num;
			}else {
				int start = 0;
				int end = len;
				
				while(start<end) {
					int mid = (start+end)/2;
					
					if(LIS[mid]<num) {
						start = mid+1;
					}else
						end = mid;
				}
				
				LIS[start] = num;
			}
		}
		
		System.out.println(len);
	}
}