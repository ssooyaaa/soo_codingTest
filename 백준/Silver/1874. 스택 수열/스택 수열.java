import java.util.*;

public class Main {
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int start = 0;
		
		while(N-- > 0) {
			int value = sc.nextInt();
			
			if(value > start) {
				for(int i=start+1;i<=value;i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start = value;
			}else if(stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append('-').append('\n');
			
		}
		
		System.out.println(sb);
	}
	
	
}