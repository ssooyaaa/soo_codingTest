import java.util.*;

class Solution {
    
    boolean[][] visited;
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    int sizeOfArea = 0;
    
    public void dfs(int x, int y, int[][] picture){
        if(visited[x][y]) return;
        
        visited[x][y] = true;
        sizeOfArea++;
        
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<picture.length && ny<picture[0].length){
                if(picture[x][y] == picture[nx][ny]){
                    dfs(nx,ny,picture);
                }
            }
        }
    }
    
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    numberOfArea++;
                    dfs(i,j,picture);
                }
                
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfArea);
                sizeOfArea = 0;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}