class Solution {
    public int solution(String[] board) {
        int countO = count(board, 'O');
        int countX = count(board, 'X');
        
        if(countO<countX) return 0;
        
        if(countO-countX>1) return 0;
        
        if(bingo(board, 'O') && (countO==countX))
            return 0;
        
        if(bingo(board, 'X') && (countO>countX))
            return 0;
        
        return 1;
    }
    
    public boolean bingo(String[] board, char ch){
        int[][] r = { { 0, 0, 0 }, { 1, 1, 1 }, { 2, 2, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, };
		int[][] c = { { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 0, 0 }, { 1, 1, 1 }, { 2, 2, 2 }, { 0, 1, 2 }, { 2, 1, 0 }, };
        
        for(int i=0;i<8;i++){
            boolean check = true;
            
            if(board[r[i][0]].charAt(c[i][0])!=ch)
                check = false;
            if (board[r[i][1]].charAt(c[i][1]) != ch)
				check = false;
			if (board[r[i][2]].charAt(c[i][2]) != ch)
				check = false;
			if (check)
				return true;
        }
        
        return false;
    }
    
    public int count(String[] board, char ch){
        int cnt = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)==ch) cnt++;
            }
        }
        
        return cnt;
    }
}