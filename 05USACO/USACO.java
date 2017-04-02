import java.util.*;
import java.io.*;
//cs pls yea
public class USACO{
    //usaco pls yea
    public USACO(){
	
    }
    //used to fine maximum in the 3 by 3 ary. max pls yea
    public static int max(int[] ary){
	int max = 0;
	for(int fpy = 0; fpy < ary.length; fpy++){
	    if(ary[fpy] > max){
		max = ary[fpy];
	    }
	}
	return max;
    }
    public static int bronze(String filename){
	try{
	    File text = new File(filename);
	    Scanner data = new Scanner(text);
	    int row = data.nextInt();
	    int col = data.nextInt();
	    int elevacion = data.nextInt();
	    int numinstructions = data.nextInt();
	    int[][] land = new int[row][col];

	    //filling land in
	    for(int x = 0; x < row; x++){
		for(int y = 0; y < col; y++){
		    land[x][y] = data.nextInt();
		}
	    }
	    
	    for(int n = 0; n < numinstructions; n++){
		int rowofcow = data.nextInt() - 1;
		int colofcow = data.nextInt() - 1;
		int tiempodestompodevaca = data.nextInt();
		int maximumdevaca = 0;
		int[] temporal = new int[9];
		temporal[0] = land[rowofcow][colofcow];
		temporal[1] = land[rowofcow][colofcow + 1];
		temporal[2] = land[rowofcow][colofcow + 2];
		temporal[3] = land[rowofcow + 1][colofcow];
		temporal[4] = land[rowofcow + 1][colofcow + 1];
		temporal[5] = land[rowofcow + 1][colofcow + 2];
		temporal[6] = land[rowofcow + 2][colofcow];
		temporal[7] = land[rowofcow + 2][colofcow + 1];
		temporal[8] = land[rowofcow + 2][colofcow + 2];
		maximumdevaca = max(temporal);
		while(tiempodestompodevaca > 0){
		    for(int isitthesame = 0; isitthesame < temporal.length; isitthesame++){
			if(temporal[isitthesame] == maximumdevaca){
			    temporal[isitthesame]--;
			}
		    }
		    tiempodestompodevaca--;
		    maximumdevaca--;
		}
	        land[rowofcow][colofcow] = temporal[0];
		land[rowofcow][colofcow + 1] = temporal[1];
		land[rowofcow][colofcow + 2] = temporal[2];
		land[rowofcow + 1][colofcow] = temporal[3];
		land[rowofcow + 1][colofcow + 1] = temporal[4];
		land[rowofcow + 1][colofcow + 2] = temporal[5];
		land[rowofcow + 2][colofcow] = temporal[6];
		land[rowofcow + 2][colofcow + 1] = temporal[7];
		land[rowofcow + 2][colofcow + 2] = temporal[8];
			
		
	    }
	    // System.out.println(land[0][0]);
	    int depthodeaggregacion = 0;
	    for(int rowdedata = 0; rowdedata < land.length; rowdedata++){
		for(int coldedata = 0; coldedata < land[0].length; coldedata++){
		    if(land[rowdedata][coldedata] < elevacion){
			depthodeaggregacion += elevacion - land[rowdedata][coldedata];
		    }
		}
	    }
	    return depthodeaggregacion * 72 * 72;
	}
	catch(FileNotFoundException e){
	  
	}
	return 0;
    }
    /*	public static int silver(String filename){
	File text = new File(filename);
	Scanner data = new Scanner(text);
	int numrowdepastar = data.nextInt();
	int numcoldepastar = data.nextInt();
	int numdetiempo = data.nextInt();
	int coorxdeempezar = 0;
	int coorydeempezar = 0;
	int coorxdeterminar = 0;
	int coorydeterminar = 0;
	String lineadenext = "";
	int[][] pastar = new int[numrowdepastar][numcoldepastar];
	for(int i = 0; i < numrowdepastar; i++){
	    lineadenext = data.next();
	    for(int j = 0; j < numcoldepastar; j++){
		if (lineadenext.charAt(j) == '.'){
		    pastar[i][j] = 0;
		}
		if (lineadenext.charAt(j) == '*'){
		    pastar[i][j] = -1;
		}
	    }
	}
	coorxdeempezar = data.nextInt();
	coorydeempezar = data.nextInt();
	coorxdeterminar = data.nextInt();
	coorydeterminar = data.nextInt();	
		
	}*/
    private static boolean valid(int[][] data, int r, int c){
	if(r >=0 && r < data.length && c >= 0 && c < data[0].length && data[r][c] == 0) {
	    return true;
	}
	else {
	    return false;
	}
    }
    
    private static int movesTo(int[][] data, int row, int col, int time, int startrow, int startcol){
	if(time == 0) {
	    if(row == startrow && col == startcol) {
		return 1;
	    }
	    else {
		return 0;
	    }
	}
	else {
	    int total = 0;
	    if(valid(data, row + 1, col)){
		total += movesTo(data,row + 1, col, time - 1, startrow, startcol);
	    }
	    if(valid(data, row - 1, col)){
		total += movesTo(data,row - 1, col, time - 1, startrow, startcol);
	    }
	    if(valid(data, row, col + 1)){
		total += movesTo(data,row, col + 1, time - 1, startrow, startcol);
	    }
	    if(valid(data, row, col - 1)){
		total += movesTo(data,row, col - 1, time - 1, startrow, startcol);
	    }
	    return total;
	}
    }
	
    public static int silver(String filename){
	try{
	    File text = new File(filename);
	    Scanner data = new Scanner(text);
	    int numrow = data.nextInt();
	    int numcol = data.nextInt();
	    int time = data.nextInt();
	    int[][] pasture = new int[numrow][numcol];
	    for( int x = 0; x < numrow; x++ ) {
		String savior = data.next();
		for ( int y = 0; y < numcol; y++ ) {
		    if (savior.charAt(y) == '.') {
			pasture[x][y] = 0;
		    }
		    if (savior.charAt(y) == '*') {
			pasture[x][y] = -1;
		    }
		}
	    }
	    int rowstart = data.nextInt() - 1;
	    int colstart = data.nextInt() - 1;
	    int rowend   = data.nextInt() - 1;
	    int colend   = data.nextInt() - 1;

	    return movesTo(pasture, rowend, colend, time, rowstart, colstart);
	  
	}
	catch(FileNotFoundException e){
	}
		
	

	return 0;

    }

    public static String printary(int[][] ary) {
	String answer = "";
	for (int x = 0; x < ary.length; x++) {
	    answer = answer + "\n";
	    for (int y = 0; y < ary[0].length; y++) {
		answer = answer + ary[x][y] + " ";
	    }
	}
	return answer;
    }
    
    public static void main(String args[]){
	System.out.println(bronze("testfile1.txt"));
	System.out.println(silver("testfile3.txt"));
    }





}

  //	    pasture[rowstart][colstart] = 1;
	    // int[][] temp = new int[numrow][numcol];
	    /*  while(time > 0) {
		for( int x = 0; x < numrow; x++ ) {
		    for ( int y = 0; y < numcol; y++ ) {
			if (pasture[x][y] == 0) {
			    if (x == 0 && y == 0) {
				if (pasture[x+1][y] == -1){
				    temp[x][y] = pasture[x][y+1];
				}
				else if(pasture[x][y+1] == -1) {
				    temp[x][y] = pasture[x+1][y];
				}
				else {	
				    temp[x][y] = pasture[x+1][y] + pasture[x][y+1];
				}
			    }
			    else if (x == 0 && y == numcol - 1) {
				if (pasture[x+1][y] == -1){
				    temp[x][y] = pasture[x][y-1];
				}
				else if(pasture[x][y-1] == -1) {
				    temp[x][y] = pasture[x+1][y];
				}
				else{
				    temp[x][y] = pasture[x+1][y] + pasture[x][y-1];
				}
			    }
			    else if (x == numrow - 1 && y == 0) {
				if (pasture[x-1][y] == -1){
				    temp[x][y] = pasture[x][y+1];
				}
				else if(pasture[x][y+1] == -1) {
				    temp[x][y] = pasture[x-1][y];
				}
				else {
				    temp[x][y] = pasture[x-1][y] + pasture[x][y+1];
				}
			    }
			    else if (x == numrow - 1 && y == numcol - 1) {
				if (pasture[x-1][y] == -1){
				    temp[x][y] = pasture[x][y-1];
				}
				else if(pasture[x][y-1] == -1) {
				    temp[x][y] = pasture[x-1][y];
				}
				else {
				    temp[x][y] = pasture[x-1][y] + pasture[x][y-1];
				}
			    }
			    else if (x == 0 && y > 0 && y < numcol - 1) {
				if(pasture[x+1][y] != -1){
				    temp[x][y] += pasture[x+1][y];
				}
				else if(pasture[x][y+1] != -1) {
				    temp[x][y] += pasture[x][y+1];
				}
				else if(pasture[x][y-1] != -1){
				    temp[x][y] += pasture[x][y-1];
				}
			    }
			    else if (x == numrow - 1 && y > 0 && y < numcol - 1) {
				if(pasture[x-1][y] != -1){
				    temp[x][y] += pasture[x-1][y];
				}
				else if(pasture[x][y+1] != -1) {
				    temp[x][y] += pasture[x][y+1];
				}
				else if(pasture[x][y-1] != -1){
				    temp[x][y] += pasture[x][y-1];
				}
				temp[x][y] = pasture[x-1][y] + pasture[x][y+1] + pasture[x][y-1];
			    }
			    else if (x > 0 && x < numrow - 1 && y == 0) {
				if(pasture[x+1][y] != -1){
				    temp[x][y] += pasture[x+1][y];
				}
				else if(pasture[x-1][y] != -1) {
				    temp[x][y] += pasture[x-1][y];
				}
				else if(pasture[x][y+1] != -1){
				    temp[x][y] += pasture[x][y+1];
				}
				temp[x][y] = pasture[x+1][y] + pasture[x-1][y] + pasture[x][y+1];
			    }
			    else if (x > 0 && x < numrow - 1 && y == numcol - 1) {
				if(pasture[x+1][y] != -1){
				    temp[x][y] += pasture[x+1][y];
				}
				else if(pasture[x-1][y] != -1) {
				    temp[x][y] += pasture[x-1][y];
				}
				else if(pasture[x][y-1] != -1){
				    temp[x][y] += pasture[x][y-1];
				}
				temp[x][y] = pasture[x+1][y] + pasture[x-1][y] + pasture[x][y-1];
			    }
			    else if(x > 0 && x < numrow - 1 && y < numcol - 1 && y > 0){
				if(pasture[x+1][y] != -1){
				    temp[x][y] += pasture[x+1][y];
				}
				else if(pasture[x][y+1] != -1) {
				    temp[x][y] += pasture[x][y+1];
				}
				else if(pasture[x][y-1] != -1){
				    temp[x][y] += pasture[x][y-1];
				}
				else if(pasture[x-1][y] != -1) {
				    temp[x][y] += pasture[x-1][y];
				    temp[x][y] = pasture[x+1][y] + pasture[x-1][y] + pasture[x][y+1] + pasture[x][y-1];
				}
	     
			    }
			    else if(pasture[x][y] == -1){
				temp[x][y] = -1;
				}
				else {
				temp[x][y] = 0;
				}
				}
				}

				}
				System.out.println(printary(pasture));
				pasture = temp;
				time--;*/
	
    
	    // return pasture[rowend][colend];
