import java.util.*;
public class Main {
	
	static int n,m;
	static int[] arr;
	static boolean[] visited;
 
    public static void main(String[] args){
        
    	Scanner sc = new Scanner(System.in);
    	
    	n = sc.nextInt();
    	m = sc.nextInt();
    	
    	arr = new int[m];
    	
    	dfs(1,0);
    	
    }
    
    static void dfs(int start, int depth) {
    	if(depth==m) {
    		for(int val:arr) {
    			System.out.print(val + " ");
    		}
    		System.out.println();
    		return;
    	}
    	for(int i=start;i<=n;i++) {
    		arr[depth] = i;
    		dfs(i+1,depth+1);
    	}
    }
 
    
}