class Solution {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    public int solution(String dirs) {
        int answer = 0;
        
        int[][] map = new int[11][11];
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        
        for(int i=0;i<dirs.length();i++){
            char dir = dirs.charAt(i);
            int d = 0;
            
            if(dir=='U') d=0;
            if(dir=='L') d=1;
            if(dir=='D') d=2;
            if(dir=='R') d=3;
            
            int nowX = x+dx[d];
            int nowY = y+dy[d];
            
            if(nowX>=0 && nowY>=0 && nowX<11 && nowY <11 ){
                if(!visited[nowX][nowY][d]){
                    visited[nowX][nowY][d]=true;
                    d = (d%2==0)? 2-d: 4-d;
                    visited[x][y][d] = true;
                    answer++;
                }
                x = nowX;
                y = nowY;
            }
            
        }
        
        return answer;
    }
}