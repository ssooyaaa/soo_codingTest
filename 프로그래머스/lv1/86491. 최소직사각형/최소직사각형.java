class Solution {
    public int solution(int[][] sizes) {
        
        int max = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int matchNum = 0;
        
        for(int i=0;i<sizes.length;i++){
            for(int j=0;j<sizes[i].length;j++){
                if(max<sizes[i][j]){
                    max = sizes[i][j];
                    leftIndex = i;
                    rightIndex = j;
                    
                    if(rightIndex==0){
                        matchNum = sizes[i][1];
                    }else{
                        matchNum = sizes[i][0];
                    }
                }
                    
            }
        }
        
        int minNum = 0;
        for(int i=0;i<sizes.length;i++){
            minNum = Math.min(sizes[i][0],sizes[i][1]);
            
            if(minNum>matchNum){
                matchNum = minNum;
            }
        }
        
        int answer = 0;
        
        answer = matchNum*max;
        return answer;
    }
}