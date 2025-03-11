class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char [] b : board)Arrays.fill(b, '.');
        List<List<String>> ans = new ArrayList<>();
        backtrack(board,0,ans);
        return ans;

    }
    public void backtrack(char[][] board, int row,List<List<String>> ans){
        if(row >= board.length){
            List<String> aboard = convert(board);
            ans.add(aboard);
            return;
        } //base case
        for(int col = 0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                backtrack(board,row+1,ans);
                board[row][col] = '.';
            }            
        }
    }
    //you have to convert char[][] board to List<String>
    //[['.','Q'],['Q','.']] ==> ".Q","Q."
    List<String> convert(char[][] board)
    {
        List<String> res = new ArrayList<>();
        for(int x = 0;x<board.length;x++)
        {
            String s = new String(board[x]);
            res.add(s);
        }
        return res;
    }
    public boolean isSafe(char[][] board, int row, int col){
        //check for the columns
        for(int i = 0;i<row;i++){
            if(board[i][col] == 'Q')return false;
        }
        //check for the left diagonal
        int maxLeft = Math.min(row, col);
        for(int i = 1;i<=maxLeft;i++){
            if(board[row-i][col-i] == 'Q')return false;
        }

        //check for the right diagonal 
        while(row > 0 && col < board.length-1){
            if(board[row-1][col+1] == 'Q')return false;
            row--;
            col++;
        }
        return true;
    }
}
