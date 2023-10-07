import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] up = new int[N];
		int[] down = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i])
					up[i] = Math.max(up[j]+1, up[i]);
			}
		}
		
		for(int i=N-1;i>-1;i--) {
			for(int j=i;j<N;j++) {
				if(arr[i]>arr[j]) {
					down[i] = Math.max(down[j]+1, down[i]);
				}
			}
		}
		
		int count = 0;
		for(int i=0;i<N;i++) {
			count = Math.max(count, up[i]+down[i]);
		}
		System.out.println(count+1);
	}
	
}
