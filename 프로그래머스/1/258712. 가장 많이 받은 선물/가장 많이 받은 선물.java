import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] count = new int[friends.length];
        int[][] graph = new int[friends.length][friends.length];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<friends.length;i++){
            map.put(friends[i],i);
        }
        
        for(int i=0;i<friends.length;i++){
            for(int j=0;j<friends.length;j++){
                graph[i][j] = 0;
            }
            count[i] = 0;
        }
        
        for(int i=0;i<gifts.length;i++){
            StringTokenizer st = new StringTokenizer(gifts[i]);
            
            int giver = map.get(st.nextToken());
            int taker = map.get(st.nextToken());
            
            graph[giver][taker] += 1;
        }
        
        for(int i=0;i<friends.length;i++){
            for(int j=0;j<friends.length;j++){
                if(i>=j) continue;
                
                int i_give = graph[i][j];
                int j_give = graph[j][i];
                
                if(i_give>j_give) count[i] += 1;
                else if(i_give<j_give) count[j] += 1;
                else{
                    int i_score = 0;
                    int give = 0;
                    int take = 0;
                    
                    for(int k=0;k<friends.length;k++){
                        give += graph[i][k];
                        take += graph[k][i];
                    }
                    
                    i_score = give-take;
                    
                    int j_score = 0;
                    give = 0;
                    take = 0;
                    
                    for(int k=0;k<friends.length;k++){
                        give += graph[j][k];
                        take += graph[k][j];
                    }
                    
                    j_score = give-take;
                    
                    if(i_score > j_score) count[i] += 1;
                    else if(i_score<j_score) count[j] += 1;
                }
                
            }
        }
        
        answer = count[0];
        for(int cnt : count){
            if(answer<cnt) answer = cnt;
        }
        
        return answer;
    }
}