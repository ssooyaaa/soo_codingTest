import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> rank = new HashMap<>();
        Map<String, Integer> player = new HashMap<>();
        
        for(int i=0;i<players.length;i++){
            rank.put(i+1,players[i]);
            
            player.put(players[i],i+1);
        }
        
        for(String nowPlayer:callings){
            int nowRank = player.get(nowPlayer);
            int frontRank = nowRank-1;
            
            String frontPlayer = rank.get(frontRank);
            rank.put(frontRank, nowPlayer);
            rank.put(nowRank, frontPlayer);
            
            player.put(frontPlayer, nowRank);
            player.put(nowPlayer, frontRank);
        }
        
        String[] answer = new String[players.length];
        int count = 0;
        for(String s : rank.values()){
            answer[count++] = s;
        }
        return answer;
    }
}