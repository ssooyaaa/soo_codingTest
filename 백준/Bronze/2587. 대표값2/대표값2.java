import java.util.*;

public class Main {
	
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<5;i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		
		int sum = 0;
		int avg = 0;
		for(int i=0;i<list.size();i++) {
			sum += list.get(i);
		}
		
		avg = sum/5;
		
		System.out.print(avg+"\n"+list.get(2));
		
    }
	
	  
    
}
