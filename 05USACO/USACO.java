import java.util.*;
import java.io.*;
public class USACO{
    private int endRow;
    private int endCol;
    private int lake;
    private int startRow;
    private int startCol;
    private int[][] land;
    private int[][] grass;
    private int[][] grass2;
    private int[][] instructions;

    public USACO(){
    }
    public int bronze(String filename){
	try{
	    File text = new File(filename);
	    Scanner data = new Scanner(text);
	    String first = data.nextLine();
	    String[] firstList = first.split(" ");
	    land = new int[Integer.parseInt(firstList[0])][Integer.parseInt(firstList[1])];
	    lake = Integer.parseInt(firstList[2]);
	    instructions = new int[Integer.parseInt(firstList[3])][3];
	    for(int r = 0l r < land.length; r++){
		String line = data.nextLine();
		String[] lineList = line.split(" ");
		for(int c = 0; c < lineList.length; c++) {
		    land[r][c] = Integer.parseInt(lineList[c]);
		}
	    }
	    for(int r = 0; r < instructions.length; r++) {
		String line = data.nextLine();
		String[] lineList = line.split(" ");
		for (int c = 0; c < 3; c++){
		    instructions[r][c] = Integer.parseInt(lineList[c]);
		}
	    }
	    runCommands();
	    lake();
	    
	}
	catch(FileNotFoundException e) {
	    System.out.println("File Not Found.");
	    System.exit(0);
	}
	return math();

    }





}
