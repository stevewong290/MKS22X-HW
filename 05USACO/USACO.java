import java.util.*;
import java.io.*;
//cs pls yea
public class USACO{
    //usaco pls yea
    public USACO(){
	
    }
    //used to fine maximum in the 3 by 3 ary. max pls yea
    public int max(int[] ary){
	int max = 0;
	for(int fpy = 0; fpy < ary.length; fpy++){
	    if(ary[fpy] > max){
		max = ary[fpy];
	    }
	}
	return max;
    }
    public int bronze(String filename){
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
		int rowofcow = data.nextInt();
		int colofcow = data.nextInt();
		int tiempodestompodevaca = data.nextInt();
		int gluteusMAXimus = 0;
		int[] temporal = new int[9];
		temporal[0] = data[rowofcow][colofcow];
		temporal[1] = data[rowofcow][colofcow + 1];
		temporal[2] = data[rowofcow][colofcow + 2];
		temporal[3] = data[rowofcow + 1][colofcow];
		temporal[4] = data[rowofcow + 1][colofcow + 1];
		temporal[5] = data[rowofcow + 1][colofcow + 2];
		temporal[6] = data[rowofcow + 2][colofcow];
		temporal[7] = data[rowofcow + 2][colofcow + 1];
		temporal[8] = data[rowofcow + 2][colofcow + 2];
		maximumdevaca = max(temporal);
		while(tiempodestompodevaca > 0){
		    for(int isitthesame = 0; isitthesame < temporal.length; itistthesame++){
			if(temporal[isitthesame] == maximumdevaca){
			    temporal[isitthesame]--;
			}
		    }
		    tiempodestompodevaca--;
		    maximumdevaca--;
		}
	    }
	    int depthodeaggregacion = 0;
	    for(int rowdedata = 0; rowdedata < data.length; rowdedata++){
		for(int coldedata = 0; coldedata < data[0].length; coldedata++){
		    if(data[rowdedata][coldedata] < elevacion){
			depthodeaggregacion += elevacion - data[rowdedata][coldedata];
		    }
		}
	    }
	    return depthodeaggregacion * 72 * 72;
	}
	catch(FileNotFoundException e){
	    
	}
    }
	
    public static void main(String args[]){
	
    }





}
