import java.util.*;

class Solution {
    public int solution(int[] order) {
        int count = 0;
        
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=1;i<=order.length;i++){
            q.add(i);
        }
        
        for(int i=0;i<order.length;i++){
            if(!st.isEmpty() && st.peek()==order[i]){
                st.pop();
                count++;
            }else{
                boolean check = false;
                while(!q.isEmpty()){
                    if(q.peek()==order[i]){
                        count++;
                        q.poll();
                        check = true;
                        break;
                    }else{
                        st.add(q.poll());
                    }
                }
                if(!check) break;
            }
        }
        return count;
    }
}