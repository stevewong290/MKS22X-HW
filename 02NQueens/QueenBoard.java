
public class QueenBoard {
    private int[][]board;
    private int solutionCount;
    private int posnum;
    //construct the Board
    public QueenBoard(int size) {
	board = new int[size][size];
    }
    public boolean solve() {
	return solveH(0);
    }
    //solves the function and returns true if there is a possible solutions. It returns false if there is no solution. 
    private boolean solveH(int col) {
        if (col >  board.length) {
	    return true;
	}
	else {
	    for(int x = 0; x < board.length; x++) {
		if (board[x][col] == 0) {
		    addQueen(col, x);
		    if (solveH(col + 1)) {
			return true;
		    }
		    else {
			removeQueen(col, x);
		    }
		}
		System.out.println(this);
	    }
	    return false;
			
	}
    }
    
    private boolean addQueen(int col, int row) {
	if (board[row][col] != 0) {
	    return false;
	}
	else {
	    board[row][col] = -1;
	    for (int r = 0; r < board.length; r++) {
		for (int c = 0; c < board.length; c++) {
		    if ((r == row) && c >= col){
			board[r][c] += 1;
		    }
		    if ((r + c == row + col) && c >= col) {
			board [r][c] += 1;
		    }
		    if ((r - c == row - col) && c >= col) {
			board[r][c] += 1;
		    }
		    board[row][col] = -1;
		}
	    }
	    return true;
	}
    }

    private boolean removeQueen(int col, int row) {
	if (board[row][col] != -1) {
	    return false;
	}
	else {
	    board[row][col] = 0;
	    for (int r = 0; r < board.length; r++) {
		for (int c = 0; c < board.length; c++) {
		    if ((r == row) && c >= col){
			board[r][c] -= 1;
		    }
		    if ((r + c == row + col) && c >= col) {
			board [r][c] -= 1;
		    }
		    if ((r - c == row - col) && c >= col) {
			board[r][c] -= 1;
		    }
		    board[row][col] = 0;
		}
	    }
	    return true;
	}
    }
    
    //returns the number of solutions: this function does not account for unique solutions
    public int getSolutionCount() {
	return -1;
    }
    public int solutionCountHelper() {
	return -1;
    }
    //gives you the 2-D array of the Board. If the solve has not been run, it should return a board of all zeroes. 
    public String toString() {
	String qboard = "";
	for (int r = 0; r < board.length; r++) {
	    for(int c = 0; c < board.length; c++) {
		qboard = qboard + " " +  board[r][c];
	    }
	    qboard += "\n";
	}
	return qboard;
    }
    public static void main(String args[]) {
	QueenBoard a = new QueenBoard(4);
	System.out.println(a.toString());
	/*    	System.out.println(a.addQueen(0,2));
	System.out.println(a.toString());
	System.out.println(a.removeQueen(2,2));
	System.out.println(a.toString());*/
		System.out.println(a.solve());
	/*
	  System.out.println(queenboard.solve());
	  System.out.println(queenboard.getSolutionCount());
	*/
    }

}
