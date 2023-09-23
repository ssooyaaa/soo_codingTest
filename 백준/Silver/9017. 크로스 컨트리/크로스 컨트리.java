import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int[] num = new int[N+1];
			
			int[] team = new int[201];
			int[] teamFive = new int[201];
			HashMap<Integer,Integer> map = new HashMap<>();
			
			for(int i=0;i<N;i++) {
				int score = Integer.parseInt(st.nextToken());
				num[i] = score;
				team[score]++;
				
				if(team[score]==5) {
					teamFive[score] = i;
				}
				
				if(team[score]==6) {
					map.put(score, 0);
					team[score]=0;
				}
				
				
			}
				
			int index = 1;
			for(int i=0;i<N;i++) { 
				if(!map.containsKey(num[i]))
					continue;
				
				if(team[num[i]]<4) {
					map.put(num[i], map.get(num[i])+index); 
					team[num[i]]++;
				}
				index++;
			}
			
			int min = Integer.MAX_VALUE;
			int minT = 201;
			
			for(int k:map.keySet()) {
				
				int value = map.get(k);
				
				if(min>value) {
					min = value;
					minT = k;
				}else if(min==value) {
					if(teamFive[k]<teamFive[minT])
						minT = k;
				}
			}
			
			System.out.println(minT);
			 
		}
		
	}
	
}