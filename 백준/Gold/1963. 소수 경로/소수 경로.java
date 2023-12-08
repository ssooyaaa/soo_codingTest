import java.util.*;
import java.io.*;

public class Main {
	
    static int[] units = {1000, 100, 10, 1};
    static boolean[] notPrime = new boolean[10000];
    static boolean[] check;
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T= Integer.parseInt(br.readLine());
 
        isPrime();
 
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
 
            if(start==end){
                System.out.println(0);
                continue;
            }
 
            int answer = bfs(start, end);
 
            System.out.println(answer);
        }
 
    }
 
    static int bfs(int start, int end){
 
        check = new boolean[10000];
        Queue<Integer> q = new LinkedList<>();
 
        q.add(start);
        check[start] = true;
 
        int count = -1;
        while (!q.isEmpty()){
            count++;
            int size = q.size();
            for (int i = 0; i <size ; i++) {
                int now = q.poll();
                
                if(now==end){
                    return count;
                }
                
                int[] numbers = new int[4];
                for (int j = 0; j <4 ; j++) {
                    numbers[j] = now/units[j];
                    now %= units[j];
                }
                
                for (int j = 0; j <4 ; j++) {
                    for (int k = 0; k <10 ; k++) {
                        numbers[j] = numbers[j] + 1 > 9 ? 0 : numbers[j]+1;
                        int next = 0;
                        for (int l = 0; l <4 ; l++) {
                            next += numbers[l]*units[l];
                        }
                        
                        if(next < 1000) continue;
                        if(check[next]) continue;
                        if(notPrime[next]) continue;
 
                        q.add(next);
                        check[next] = true;
                    }
                }
 
            }
        }
        return -1;
    }
 
 
    static void isPrime(){
        for (int i = 2; i <10000 ; i++) {
            if(notPrime[i]) continue;
            for (int j = 2; j*i <10000 ; j++) {
                notPrime[i*j] = true;
            }
        }
    }
}