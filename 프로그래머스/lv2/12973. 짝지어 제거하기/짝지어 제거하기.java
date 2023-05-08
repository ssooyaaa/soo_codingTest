import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        
        if(s.length()==0) answer = 0;
        
        for(int i=0;i<s.length();i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
            }else{
                if((stack.peek())==s.charAt(i)){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        
        if(stack.empty()) answer = 1;
        else{answer = 0;}
        
        return answer;
    }
}