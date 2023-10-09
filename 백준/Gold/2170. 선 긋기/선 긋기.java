import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {start,end});
		}
		
		list.sort(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		int result = 0;
		
		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			if(right>=list.get(i)[0]) {
				right = Math.max(right, list.get(i)[1]);
			}else {
				result += (right-left);
				left = list.get(i)[0];
				right = list.get(i)[1];
			}
		}
		
		result += (right-left);//마지막 선
		
		System.out.println(result);
	}	
}