public class KnightBoard() {
    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRow][startingCols];
    }

    public String toString() {
	String kboard = "";
	for (int r = 0; r < board.length; r++) {
	    for(int c = 0; c < board[0].length; c++) {
		
		/*
		if (board[r][c] != -1) {
		    kboard = kboard + " " +  "_";
		}
		else {
		    kboard= kboard + " " + "Q";
		}
		*/
	    }
	    kboard += "\n";
	}
	return kboard;
    }

    public void solve() {

    }

    private boolean solveH(int row ,int col, int level) {

    }


}
