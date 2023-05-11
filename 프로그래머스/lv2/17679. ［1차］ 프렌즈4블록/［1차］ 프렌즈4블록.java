class Solution {
    static char[][] block;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        block = new char[m][n];
        for(int i=0;i<m;i++){
            block[i] = board[i].toCharArray();
        }
        
        while(true){
            int cnt = simulation(m,n);
            if(cnt==0) break;
            answer += cnt;
        }
        
        return answer;
    }
    
    public int simulation(int m, int n){
        boolean[][] check = new boolean[m][n];
        int count = 0;
        
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(block[i][j]!='.'&&checkBlock(i,j)){
                    check[i][j] = check[i][j+1] = check[i+1][j] = check[i+1][j+1] = true;
                }
            }
        }
        
        count = update(check,m,n);
        while(dropBlock(m,n));
        return count;
    }
    
    public int update(boolean[][] check, int m, int n){
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]){
                    count++;
                    block[i][j] ='.';
                }
            }
        }
        return count;
    }
    
    public boolean dropBlock(int m, int n){
        boolean isMoved = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m-1;j++){
                if(block[j][i]!='.' && block[j+1][i]=='.'){
                    block[j+1][i]=block[j][i];
                    block[j][i]='.';
                    isMoved = true;
                }
            }
        }
        return isMoved;
    }
    
    public boolean checkBlock(int i, int j){
        char c = block[i][j];
        return (c==block[i][j+1] && c==block[i+1][j] && c==block[i+1][j+1]);
    }
}