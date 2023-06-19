import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0;
		for(int i=0;i<list.size();i++) {
			sum += list.get(i);
		}
		
		int restTime = (list.size()-1)*8;
		sum += restTime;
		
		System.out.println((sum/24)+" "+(sum%24));
	}
	
}
