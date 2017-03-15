import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;
    private int SrHolder;
    private int ScHolder;
  
    /*
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
		r1 += 1;
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
		r += 1;
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
    */
 public Maze(String filename, boolean b){
	animate = b;
        String ans = "";
	try{
	    int numE = 0;
	    int numS = 0;
	    File text = new File(filename);
	    Scanner infile1 = new Scanner(text);
	    int r = 0;
	    int c = 0;
	    while(infile1.hasNextLine()){
		String line = infile1.nextLine();
            ans += line;
		c = line.length();
		r += 1;
	    }
        maze = new char[r][c];
        while (ans.length() > 0) {
            for(int i = 0; i < maze.length; i++) {
                for(int j = 0; j < maze[0].length; j++) {
                    maze[i][j] = ans.charAt(0);
                    ans = ans.substring(1);
                }
            }
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


  
    public boolean solve(){
	maze[SrHolder][ScHolder] = ' ';
	return solve(SrHolder, ScHolder);
    }

 
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
		
    }      
    
    public static void main(String[] args){
	Maze a = new Maze("data2.dat", true);
	System.out.println(a);
	a.solve();
	System.out.println(a);
    }
   
}
