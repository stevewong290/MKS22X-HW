public class KnightBoard{
    private int[][]board;
    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
    }

    public String toString() {
	String kboard = "";
	for (int r = 0; r < board.length; r++) {
	    for(int c = 0; c < board[0].length; c++) {
		kboard = kboard + " " + board[r][c];
		/*
		if (board[r][c] != -1) {
		    kboard = kboard + " " +  0;
		}
		else {
		    kboard= kboard + " " + 1;
		}
		*/
		
	    }
	    kboard += "\n";
	}
	return kboard;
    }

    public void solve() {
	solveH(0,0,1);
    }

    private boolean solveH(int row ,int col, int level) {
	if (level == (board.length * board[0].length)) {
	    return true;
	}
	if (isGoodSpot(row, col)) {
	    board[row][col] = level;
	    if(solveH(row + 2, col + 1, level+1)) {
		return true;
	    }
	    if(solveH(row + 2, col - 1, level+1)) {
		return true;
	    }
	    if(solveH(row - 2, col + 1, level+1)) {
		return true;
	    }
	    if(solveH(row - 2, col - 1, level+1)) {
		return true;
	    }
	    if(solveH(row + 1, col + 2, level+1)) {
		return true;
	    }
	    if(solveH(row + 1, col - 2, level+1)) {
		return true;
	    }
	    if(solveH(row - 1, col + 2, level+1)) {
		return true;
	    }
	    if(solveH(row - 1, col - 2, level+1)) {
		return true;
	    }
	    else {
		return false;
	    }
	    
	}
        else {
	    return false;
	}
    }
    public boolean isGoodSpot(int row, int col) {
	if (row < board.length   &&
	    row >= 0             &&
	    col < board[0].length&&
	    col >= 0             &&
	    board[row][col] == 0) {
	    return true;
	}
	else {
	    return false;
	}

    }
    public static void main(String args[]){
	KnightBoard a = new KnightBoard(8,8);
	System.out.println(a);
	System.out.println(a.isGoodSpot(0,0));
	System.out.println(a.isGoodSpot(8,8));
	System.out.println(a.isGoodSpot(7,8));
	a.solve();
	System.out.println(a);
    }


}
