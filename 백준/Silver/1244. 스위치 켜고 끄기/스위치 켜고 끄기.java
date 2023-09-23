import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
				
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] light = new int[N];
		for(int i=0;i<N;i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}
		
		int students = Integer.parseInt(br.readLine());
		
		for(int i=0;i<students;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sex = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			if(sex==1) {
				male(light, number, N);
			}else {
				female(light, number, N);
			}
		}
		
		for(int i=0;i<light.length;i++) {
			System.out.print(light[i]+" ");
			
			if((i+1)%20 == 0) {
				System.out.println();
			}
		}
		
	}
	
	static int[] male(int[] light, int number ,int N) {
		
		for(int i=1;i*number<=N;i++) {
			if(light[(i*number)-1]==0)
				light[(i*number)-1]=1;
			else
				light[(i*number)-1]=0;
		}
		
		return light;
	}
	
	static int[] female(int[] light, int number, int N) {
		
		if(light[number-1]==0)
			light[number-1]=1;
		else
			light[number-1]=0;
		
		
		int len = Math.min(number-1, N-number);
		
		for(int i=1;i<=len;i++) {
			if(light[number-i-1] != light[number+i-1])
				break;
			
			if(light[number-i-1]==0) {
				light[number-i-1]=1;
				light[number+i-1]=1;
			}else {
				light[number-i-1]=0;
				light[number+i-1]=0;
			}
		}
		
		return light;
	}
	
}