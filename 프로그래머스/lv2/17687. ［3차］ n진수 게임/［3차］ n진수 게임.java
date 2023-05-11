import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder nGame = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; nGame.length()<=t*m;i++){
            nGame.append(Integer.toString(i,n));
        }
        
        for(int i=p-1;answer.length()<t;i+=m){
            answer.append(nGame.charAt(i));
        }
        
        return answer.toString().toUpperCase();
    }
}