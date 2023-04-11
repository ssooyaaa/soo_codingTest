import java.util.*;
import java.io.*;
public class Main {
	
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
     
        boolean[] prime = new boolean[n+1];
        prime[0] = prime[1] = true;
        
        for(int i=2;i*i<=n;i++) {
        	if(!prime[i]) {
        		for(int j=i*i;j<=n;j+=i) {
        			prime[j] = true;
        		}
        	}
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) {
        	if(!prime[i]) list.add(i);
        }
        int count = 0;
        int startPoint = 0, endPoint = 0;
        int sum = 0;
        
        while(true) {
        	if(sum >=n)
        		sum -= list.get(startPoint++);
        	else if(endPoint == list.size()) break;
        	else
        		sum += list.get(endPoint++);
        	
        	if(n==sum) count++;
        }
        
        System.out.println(count);
    }
    
}