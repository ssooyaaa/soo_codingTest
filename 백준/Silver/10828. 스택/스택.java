import java.util.*;
import java.io.*;

public class Main {
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.contains("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
			}else if(s.equals("pop")) {
				
				if(stack.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					int popNum = stack.pop();
					sb.append(popNum+"\n");
					
				}
			}else if(s.equals("size")) {
				sb.append(stack.size()+"\n");
			}else if(s.equals("empty")) {
				if(stack.isEmpty())
					sb.append(1+"\n");
				else sb.append(0+"\n");
			}else if(s.equals("top")) {
				if(stack.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(stack.peek()+"\n");
				}
			}
		}
		System.out.print(sb);
		
	}
	
	
}
