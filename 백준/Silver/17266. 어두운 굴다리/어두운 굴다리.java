import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] light = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}
		
		int height = Integer.MAX_VALUE;
		
		if(light.length==1) {
			int location = light[0];
			int minHeight = Math.max(Math.abs(0-location), Math.abs(location-N));
			
			if(minHeight<height) {
				height = minHeight;
			}
		}
		
		else {
			int start = Math.abs(0-light[0]);
			int end = Math.abs(light[light.length-1]-N);
			
			int gap = 0;
			int mid = Integer.MIN_VALUE;
			
			for(int i=1;i<light.length-1;i++) {
				if((light[i+1]-light[i])%2==0) {
					gap = (light[i+1]-light[i])/2;
					if(mid<gap)
						mid = gap;
				}else {
					gap = (light[i+1]-light[i])/2+1;
					if(mid<gap)
						mid = gap;
				}
			}
			
			int minHeight = Math.max(start, Math.max(end, mid));
			
			if(minHeight<height) {
				height = minHeight;
			}
		}
		System.out.println(height);
	}
	
}
