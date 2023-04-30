class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int startX=0, startY=0;
        char[][] arr = new char[park.length][park[0].length()];
        
        for(int i=0;i<park.length;i++){
            arr[i] = park[i].toCharArray();
            
            if(park[i].contains("S")){
                startY = i;
                startX = park[i].indexOf("S");
            }
        }
        
        for(int i=0;i<routes.length;i++){
            String s = routes[i];
            String way = s.split(" ")[0];
            int len = Integer.parseInt(s.split(" ")[1]);
            
            int nowX = startX;
            int nowY = startY;
            
            for(int j=0;j<len;j++){
                if(way.equals("E")) nowX++;
                if(way.equals("W")) nowX--;
                if(way.equals("S")) nowY++;
                if(way.equals("N")) nowY--;
                if(nowX>=0 && nowY>=0 && nowX<arr[0].length && nowY<arr.length){
                    if(arr[nowY][nowX]=='X') break;
                    if(j==len-1){
                        startX = nowX;
                        startY = nowY;
                    }
                }
            }
        }
        int[] answer = {startY, startX};
        return answer;
    }
}