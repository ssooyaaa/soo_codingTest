import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] calc = br.readLine().toCharArray();
		
		Stack<Character> oper = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<calc.length;i++) {
			if(calc[i]>='A' && calc[i]<='Z')
				sb.append(calc[i]);
			else {
				if(calc[i]=='(')
					oper.add(calc[i]);
				else if(calc[i]==')') {
					while(!oper.isEmpty() && oper.peek()!='(') {
						sb.append(oper.pop());
					}
					if(!oper.isEmpty())
						oper.pop();
				}else {
					while(!oper.isEmpty() && prior(oper.peek())>=prior(calc[i])) {
						sb.append(oper.pop());
					}
					oper.push(calc[i]);
				}
			}
		}
		
		while(!oper.isEmpty()) {
			sb.append(oper.pop());
		}
		System.out.println(sb.toString());
	}
	
	static int prior(char op) {
		if(op=='*' || op=='/') return 2;
		else if(op=='+' || op=='-') return 1;
		else return 0;
	}
}