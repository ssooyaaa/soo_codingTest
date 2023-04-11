import java.util.*;
import java.io.*;
public class Main {
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<n;i++) {
    		
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	System.out.println(twoPointer(arr, m));
    }
    
    static int twoPointer(int[] arr, int m) {
    	int count = 0;
    	int startPoint = 0, endPoint = 0;
    	int sum = 0;
    	
    	while(true) {
    		if(sum >= m) {
    			sum -= arr[startPoint++];
    		}else if(endPoint >= arr.length) {
    			break;
    		}else {
    			sum += arr[endPoint++];
    		}
    		
    		if(sum == m) {
    			count ++;
    		}
    	} return count;
    }
    
}