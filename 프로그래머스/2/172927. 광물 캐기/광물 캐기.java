import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int sumPicks = 0;
        for(int i=0;i<picks.length;i++)
            sumPicks += picks[i];
        
        int[][] p = new int[sumPicks][3];
        
        for(int i=0;i<minerals.length;i+=5){
            int x = i/5;
            if(x==sumPicks) break;
            
            int[] cost = new int[3];
            for(int j=i;j<i+5;j++){
                if(j==minerals.length) break;
                
                String s = minerals[j];
                if(s.equals("diamond"))
                    sumCost(cost,1,5,25);
                else if(s.equals("iron"))
                    sumCost(cost,1,1,5);
                else
                    sumCost(cost,1,1,1);
            }
            
            for(int j=0;j<3;j++)
                p[x][j] = cost[j];
            
            cost = new int[3];
        }
        
        Arrays.sort(p,(a1,a2) -> (a2[2]-a1[2]));
        
        for(int i=0;i<sumPicks;i++){
            if(picks[0]>0){
                answer += p[i][0];
                picks[0]--;
            }else if(picks[1]>0){
                answer += p[i][1];
                picks[1]--;
            }else if(picks[2]>0){
                answer += p[i][2];
                picks[2]--;
            }
        }
        
        return answer;
    }
    
    public void sumCost(int[] cost, int a, int b, int c){
        cost[0] += a;
        cost[1] += b;
        cost[2] += c;
    }
}