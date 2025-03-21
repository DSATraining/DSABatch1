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




//Code for rat in a maze
class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        int[][] mat2 = new int[mat.size()][mat.size()];
        int m = mat.size();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<m;j++){
                mat2[i][j] = mat.get(i).get(j);
            }
        }
        boolean[][] visited = new boolean[m][m];
        ArrayList<String> ans = new ArrayList<>();
        String tempAns = "";
        int row = 0;
        int col = 0;
        backtrack(mat2,ans,tempAns,visited,row,col);
        return ans;
    }
    public void backtrack(int[][] mat,ArrayList<String> ans, String p, boolean[][] visited, int r, int c){
        if(r == mat.length-1 && c == mat.length - 1){
            ans.add(p);
            return;
        }
        //base cases
        if(mat[r][c] == 0 || visited[r][c] == true){
            return;
        }
        visited[r][c] = true;
        //lets go down of the maze 1st
        if(r < mat.length - 1)
            backtrack(mat,ans,p + "D",visited,r + 1 ,c); //backtrack(mat, ans, p+"d",visited,0+1,0)
        //lets go to the left of the maze after that
        if(c > 0)
            backtrack(mat, ans, p + "L", visited, r, c - 1);
            
        //next path is going right
        if(c < mat.length - 1)
            backtrack(mat, ans, p + "R", visited,r, c+1);
        //only remaining path is up
        if(r > 0)
            backtrack(mat, ans, p + "U", visited,r-1,c );
        //main backtraking code
        visited[r][c] = false;
    }
}
