import java.util.*;
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		Integer[] score = new Integer[10];
		
		for(int i=0;i<score.length;i++) {
			score[i] = (int)Math.pow(2, i);
		}
		Arrays.sort(score, Collections.reverseOrder());
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<score.length;i++) {
			if(a>=score[i]) {
				map.put(score[i], map.getOrDefault(score[i], 0)+1);
				a -= score[i];
			}
			
			if(b>=score[i]) {
				map.put(score[i], map.getOrDefault(score[i], 0)+1);
				b -= score[i];
			}
		}
		
		int c = 0;
		
		for(int key : map.keySet()) {
			if(map.get(key)==1) {
				c += key;
			}
		}
		
		System.out.println(c);
		
    }
	
}