import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;
    private int SrHolder;
    private int ScHolder;
    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename, boolean b){
	animate = b;
	try{
	    int numE = 0;
	    int numS = 0;
	    File text = new File(filename);
	    Scanner infile1 = new Scanner(text);
	    int r1 = 0;
	    int c1 = 0;
	    while(infile1.hasNextLine()){
		String line = infile1.nextLine();
		c1 = line.length();
		r1 = r1 + 1;
	    }
	    maze = new char[r1][c1];
	    int r = 0;
	    Scanner infile = new Scanner(text);
	    while(infile.hasNextLine()) {
		String line = infile.nextLine();
		for(int c = 0; c < line.length(); c++) {
		    maze[r][c]= line.charAt(c);
		    if(line.charAt(c) == 'E') {
			numE += 1;
		    }
		    if(line.charAt(r) == 'S') {
			numS +=1;
			SrHolder = r;
			ScHolder = c;
		    }
		}
		r = r + 1;
	    }
	    if(numS != 1 || numE != 1) {
		System.out.println("you either have too many or no E's or S's");
		System.exit(1);
	    }
	}
	catch(FileNotFoundException e) {
	    System.out.println("Missing File");
	    System.exit(0);
	}
    }

    public void setAnimate(boolean b){

        animate = b;

    }

    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }
    
    public void clearTerminal(){

	System.out.println("\033[2J");

    }
    public String toString(){
	String temp = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		temp += maze[r][c];
	    }
	    temp += "\n";
	}
	return temp;
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startx=0,starty=0;

            //Initialize startx and starty with the location of the S. 

            maze[startx][starty] = ' ';//erase the S, and start solving!
            return solve(startx,starty);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int r, int c){
	if(animate){
	    System.out.println("\033[2J\033[1;1H"+ toString());
            wait(100);
	}
	if(maze[r][c] == 'E'){
	    return true;
	}
	maze[r][c] = '&';
	if(maze[r + 1][c] == ' ' || maze[r + 1][c] == 'E'){
	    if(solve(r + 1, c)){
		return true;
	    }
	}
	if(maze[r - 1][c] == ' ' || maze[r - 1][c] == 'E'){
	    if(solve(r - 1, c)){
		return true;
	    }
	}
	if(maze[r][c + 1] == ' ' || maze[r][c + 1] == 'E'){
	    if(solve(r, c + 1)){
		return true;
	    }
	}
	if(maze[r][c - 1] == ' ' || maze[r][c - 1] == 'E'){
	    if(solve(r, c - 1)){
		return true;
	    }
	}
	maze[r][c] = '.';
	return false;
		
    }        //COMPLETE SOLVE
    
    public static void main(String[] args){
	Maze a = new Maze("data2.dat", true);
	a.solve();
	System.out.println(a);
    }
   
}
