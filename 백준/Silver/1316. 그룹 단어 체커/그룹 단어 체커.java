import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			if(check(s)==true)
				count++;
		}
		
		System.out.println(count);
	}
	
	static boolean check(String st){
		boolean[] check = new boolean[26];
		
		int prev = 0;
		
		for(int i=0;i<st.length();i++) {
			int now = st.charAt(i);
			
			if(prev!=now) {
				if(check[now-'a']==false) {
					check[now-'a']=true;
					prev = now;
				}else
					return false;
			}else
				continue;
		}
		return true;
	}
}
