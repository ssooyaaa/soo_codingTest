import java.util.*;
import java.io.*;
public class Main {
	
	
	public static void main(String[] args)throws IOException{

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int result = search(arr,n,m);
		System.out.println(result);
	}	
	
	public static int search(int[] arr, int n, int m) {
		int result = 0;
		
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					int temp = arr[i]+arr[j]+arr[k];
					
					if(m == temp)
						return temp;
					
					if(result<temp && temp<m) {
						result = temp;
					}
				}
			}
		}return result;
	}
}

