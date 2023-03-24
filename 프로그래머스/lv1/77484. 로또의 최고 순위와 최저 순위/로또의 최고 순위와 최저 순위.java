class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int matchCount = 0; //좋은 등수 체크
        int noMatchCount = 0; // 나쁜 등수 체크
        
        //숫자 0 확인 -> win:맞는 count추가 / lose:밎지 않음
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                matchCount++;
            }
        }
        
        //맞는 숫자 확인
        for(int i=0;i<lottos.length;i++){
            for(int j=0;j<win_nums.length;j++){
                if(lottos[i]==win_nums[j]){
                    matchCount++;
                    noMatchCount++;
                }
            }
        }
        
        int[] answer = new int[2];
        
        answer[0] = getScore(matchCount);
        answer[1] = getScore(noMatchCount);
        
        return answer;
    }
    
    public int getScore(int count){
        int score = 0;
        switch(count){
            case 6:
                score = 1;
                return score;
                
            case 5:
                score = 2;
                return score;
                
            case 4:
                score = 3;
                return score;
                
            case 3:
                score = 4;
                return score;
                
            case 2:
                score = 5;
                return score;
                
            default:
                score = 6;
                return score;
                
        }
    }
}