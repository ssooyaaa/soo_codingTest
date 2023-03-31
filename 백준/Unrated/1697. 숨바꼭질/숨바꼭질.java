import java.util.*;
import java.io.*;

public class Main{
    
    static int N,K;
    static int visited[] = new int[100001];
    
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
        K = sc.nextInt();
        
        System.out.println(bfs(N));
    }
    
    public static int bfs(int a){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(a);
        int index = a;
        int n = 0;
        
        visited[index]=1;
        
        while(!q.isEmpty()){
            n=q.poll();
            
            if(n==K)
                return visited[n]-1;
            
            if(n-1>=0 && visited[n-1]==0){
                visited[n-1] = visited[n]+1;
                q.add(n-1);
            }
            if(n+1<=100000 && visited[n+1]==0){
                visited[n+1] = visited[n]+1;
                q.add(n+1);
            }
            
            if(2*n<=100000 && visited[2*n]==0){
                visited[2*n] = visited[n]+1;
                q.add(2*n);
            }
        } return -1;
    }

}