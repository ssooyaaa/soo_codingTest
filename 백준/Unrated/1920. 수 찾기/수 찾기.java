import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static int[] arr1;
	static int target;
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	arr1 = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0;i<n;i++) {
    		arr1[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr1);
    	
    	m = Integer.parseInt(br.readLine());
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<m;i++) {
    		if(search(arr1, Integer.parseInt(st.nextToken()))>=0) {
    			System.out.println(1);
    		}else {
    			System.out.println(0);
    		}
    	}
    }
    
    static int search(int[] arr, int target) {
    	int startPoint = 0;
    	int endPoint = arr.length-1;
    	
    	while(startPoint<=endPoint) {
    		int mid = (startPoint+endPoint)/2;
    		
    		if(target<arr[mid]) {
    			endPoint = mid-1;
    		}else if(target>arr[mid]) {
    			startPoint = mid+1;
    		}else {
    			return mid;
    		}
    	}
    	return -1;
    }
    
}