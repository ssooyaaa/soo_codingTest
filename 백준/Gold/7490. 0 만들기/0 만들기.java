import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static List<String> ans;
	static String[] op = {"+","-"," "};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			ans = new ArrayList<>();
			dfs(1,"1");
			
			Collections.sort(ans);
			for(int i=0;i<ans.size();i++) {
				System.out.println(ans.get(i));
			}
			System.out.println();
		}
	}
	
	static void dfs(int num, String s) {
		if(num == N) {
			String ex = s.replaceAll(" ", "");
			if(cal(ex))
				ans.add(s);
			return;
		}
		
		for(int i=0;i<3;i++) {
			dfs(num+1, s+op[i]+Integer.toString(num+1));
		}
	}
	
	static boolean cal(String ex) {
		StringTokenizer st = new StringTokenizer(ex, "-|+", true);
		int sum = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			if(s.equals("+"))
				sum += Integer.parseInt(st.nextToken());
			else
				sum -= Integer.parseInt(st.nextToken());
		}
		
		if(sum==0)
			return true;
		return false;
	}
	
}