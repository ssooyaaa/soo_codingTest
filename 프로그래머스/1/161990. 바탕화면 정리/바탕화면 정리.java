class Solution {
    public int[] solution(String[] wallpaper) {
        int minR = 51;
        int maxR = 0;
        int minC = 51;
        int maxC = 0;
        
        for(int i=0;i<wallpaper.length;i++){
            char[] desk = wallpaper[i].toCharArray();
            
            for(int j=0;j<desk.length;j++){
                if(desk[j]=='#'){
                    if(i<minR) minR = i;
                    if(i+1>maxR) maxR = i+1;
                    if(j<minC) minC = j;
                    if(j+1>maxC) maxC = j+1;
                }
            }
        }
        
        return new int[]{minR, minC, maxR, maxC};
    }
}