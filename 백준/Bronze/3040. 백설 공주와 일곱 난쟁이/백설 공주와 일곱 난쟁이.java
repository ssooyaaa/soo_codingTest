import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		
		int total = 0;
		
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		
		for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				int sum = arr[i] + arr[j];
				
				if(total-sum==100) {
					arr[i]=0;
					arr[j]=0;
					
					for(int k=0;k<9;k++) {
						if(arr[k]!=0)
							System.out.println(arr[k]);
					}
				}
			}
		}
	}

}