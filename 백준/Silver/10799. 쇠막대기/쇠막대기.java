import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int count = 0;
		
		Stack<Character> st = new Stack<>();
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i)=='(') {
				st.push('(');
			}else {
				if(s.charAt(i-1)=='(') {
					st.pop();
					count += st.size();
				}else {
					st.pop();
					count+=1;
				}
			}
		}
		
		System.out.println(count);
	}
}

