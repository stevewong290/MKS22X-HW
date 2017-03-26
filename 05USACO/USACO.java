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
	
    public static void main(String args[]){
	System.out.println(bronze("testfile1.txt"));
    }





}
