package test;

public class SudokuSolver37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(5/3*3);
	}
	
    public static void solveSudoku(char[][] board) {
    	solve(board);    	      
    }
    
    public static boolean solve(char[][] board) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (board[i][j] == '.') {
    				for (char c = '1'; c <= '9'; c++) {
    					if (isValid(board, i, j, c)) {
    						board[i][j] = c;
    						if (solve(board)) {
    							return true;
    						} else {
        						board[i][j] = '.'; 
    						}
    					}
    				}
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public static boolean isValid(char[][] board, int row, int col, int c) {
    	for (int i = 0; i < 9; i++) {
    		if (board[row][i] != '.' && board[row][i] == c)
    			return false;
    		if (board[i][col] != '.' && board[i][col] == c)
    			return false;
    		if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] != '.' &&
    			board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] != 'c')
    			return false;
    	}
    	return true;
    }
}
